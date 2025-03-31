package org.splitwise.services;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.splitwise.models.Expense;
import org.splitwise.models.Group;
import org.splitwise.models.Split;

public class GroupService {

    // SELECT * FROM group where id = 'groupId'
    Map<String, Group> groups;

    ExpenseService expenseService;

    public GroupService(ExpenseService expenseService) {
        this.expenseService = expenseService;
        groups = new HashMap<>();
    }

    public Group createGroup(String id, String name, List<String> users, String createdBy) {
        Group group = new Group(id, name, users, createdBy);
        return group;
    }

    public void addUser(Group group, String userId) {
        group.addUser(userId);
    }

    public Map<String, Integer> getBalance(String groupId) {
        List<Expense> expenses = expenseService.getAllGroupExpneses(groupId);
        System.out.println(expenses);
        Map<String, Integer> balance = new HashMap<>();
        for (Expense exp : expenses) {
            for (Split split : exp.splits) {
                balance.put(split.getUserId(), balance.getOrDefault(split.getUserId(), 0) - split.getAmount());
            }

            balance.put(exp.paidBy, balance.getOrDefault(exp.paidBy, 0) + exp.amount);
        }

        return balance;
    }

    public Map<String, List<Split>> getPaymentGraph(Map<String, Integer> balances) {
        PriorityQueue<Map.Entry<String, Integer>> positiveBalance = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<String, Integer>> negativeBalance = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> balance : balances.entrySet()) {
            if (balance.getValue() > 0) {
                positiveBalance.add(balance);
            } else {
                negativeBalance.add(balance);
            }
        }

        Map<String, List<Split>> paymentGraph = new HashMap<>();

        while (!positiveBalance.isEmpty()) {
            Map.Entry<String, Integer> highestPostiveBalance = positiveBalance.poll();
            Map.Entry<String, Integer> highestNegativeBalance = negativeBalance.poll();

            int remainingAmount = highestPostiveBalance.getValue() + highestNegativeBalance.getValue();

            paymentGraph.putIfAbsent(highestPostiveBalance.getKey(), new ArrayList<>());

            paymentGraph.get(highestPostiveBalance.getKey()).add(
                    new Split(highestNegativeBalance.getKey(),
                            Math.min(highestPostiveBalance.getValue(), Math.abs(highestNegativeBalance.getValue()))));

            if (remainingAmount > 0) {
                positiveBalance.add(new AbstractMap.SimpleEntry<>(highestPostiveBalance.getKey(), remainingAmount));
            } else if (remainingAmount < 0) {
                negativeBalance.add(new AbstractMap.SimpleEntry<>(highestNegativeBalance.getKey(), remainingAmount));
            }
        }

        return paymentGraph;
    }
}
