package com.aigpu.resourceoptimizer.algorithm;

public class GreedyCounterExampleTest {

    public static void main(String[] args) {

        int[] gpu = {10, 20, 30};

        int[] benefit = {60, 100, 120};

        int capacity = 50;

        int result = Greedy.findMaximumBenefit(
                gpu,
                benefit,
                capacity
        );

        System.out.println("Greedy Benefit = " + result);
    }
}