package com.aigpu.resourceoptimizer.algorithm;

import java.util.List;

public class GreedyTest {

    public static void main(String[] args) {

        int[] gpu = {2, 3, 4, 5, 9};

        int[] benefit = {20, 30, 50, 60, 100};

        int capacity = 10;

        int result = Greedy.findMaximumBenefit(
                gpu,
                benefit,
                capacity
        );

        List<Integer> selectedJobs =
                Greedy.findSelectedJobs(
                        gpu,
                        benefit,
                        capacity
                );

        System.out.println(
                "Maximum Benefit = " + result
        );

        System.out.println(
                "Selected Jobs = " + selectedJobs
        );
    }
}