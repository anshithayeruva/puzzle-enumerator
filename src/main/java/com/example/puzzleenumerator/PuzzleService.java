package com.example.puzzleenumerator;

import java.util.*;

public class PuzzleService {

    public List<List<Integer>> results = new ArrayList<>();
    public List<String> constraintMessages = new ArrayList<>();

    public List<List<Integer>> generateSolutions(String elementsInput, String constraintsInput) {

        results.clear();
        constraintMessages.clear();

        // Step 1: Parse elements
        List<Integer> elements = new ArrayList<>();
        for (String s : elementsInput.trim().split("\\s+")) {
            elements.add(Integer.parseInt(s));
        }

        // Step 2: Parse constraints
        List<int[]> constraints = new ArrayList<>();

        if (!constraintsInput.isEmpty()) {
            String[] pairs = constraintsInput.split(",");

            for (String pair : pairs) {
                String[] nums = pair.trim().split("\\s+");

                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);

                constraints.add(new int[]{a, b});

                constraintMessages.add(a + " & " + b + " should not be adjacent");
            }
        }

        // Step 3: Backtracking
        backtrack(new ArrayList<>(), elements, constraints);

        return results;
    }

    private void backtrack(List<Integer> current, List<Integer> remaining, List<int[]> constraints) {

        if (remaining.isEmpty()) {
            if (isValid(current, constraints)) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            int num = remaining.get(i);

            current.add(num);

            List<Integer> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove(i);

            backtrack(current, newRemaining, constraints);

            current.remove(current.size() - 1);
        }
    }

    private boolean isValid(List<Integer> list, List<int[]> constraints) {

        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);

            for (int[] c : constraints) {
                if ((c[0] == a && c[1] == b) || (c[0] == b && c[1] == a)) {
                    return false;
                }
            }
        }

        return true;
    }
}