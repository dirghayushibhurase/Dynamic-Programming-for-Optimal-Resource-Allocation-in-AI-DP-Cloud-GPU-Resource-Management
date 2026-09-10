package com.aigpu.resourceoptimizer.algorithm;

import java.util.List;

public class AlgorithmComparison {

    public static void main(String[] args) {

        // Same input for all algorithms
        int[] gpu = {2, 3, 4, 5, 9};

        int[] benefit = {20, 30, 50, 60, 100};

        int capacity = 10;


        // =========================
        // BRUTE FORCE
        // =========================

        long startTime = System.nanoTime();

        int bruteForceResult =
                BruteForce.findMaximumBenefit(
                        gpu,
                        benefit,
                        capacity
                );

        long endTime = System.nanoTime();

        long bruteForceTime = endTime - startTime;

        List<Integer> bruteForceJobs =
                BruteForce.findSelectedJobs(
                        gpu,
                        benefit,
                        capacity
                );


        // =========================
        // GREEDY
        // =========================

        startTime = System.nanoTime();

        int greedyResult =
                Greedy.findMaximumBenefit(
                        gpu,
                        benefit,
                        capacity
                );

        endTime = System.nanoTime();

        long greedyTime = endTime - startTime;

        List<Integer> greedyJobs =
                Greedy.findSelectedJobs(
                        gpu,
                        benefit,
                        capacity
                );


        // =========================
        // DYNAMIC PROGRAMMING
        // =========================

        startTime = System.nanoTime();

        int dpResult =
                DynamicProgramming.findMaximumBenefit(
                        gpu,
                        benefit,
                        capacity
                );

        endTime = System.nanoTime();

        long dpTime = endTime - startTime;

        List<Integer> dpJobs =
                DynamicProgramming.findSelectedJobs(
                        gpu,
                        benefit,
                        capacity
                );


        // =========================
        // DISPLAY RESULTS
        // =========================

        System.out.println(
                "========== ALGORITHM COMPARISON =========="
        );

        System.out.println();

        System.out.println("Brute Force:");
        System.out.println(
                "Maximum Benefit = " + bruteForceResult
        );
        System.out.println(
                "Selected Jobs = " + bruteForceJobs
        );
        System.out.println(
                "Execution Time = " + bruteForceTime + " ns"
        );

        System.out.println();


        System.out.println("Greedy:");
        System.out.println(
                "Maximum Benefit = " + greedyResult
        );
        System.out.println(
                "Selected Jobs = " + greedyJobs
        );
        System.out.println(
                "Execution Time = " + greedyTime + " ns"
        );

        System.out.println();


        System.out.println("Dynamic Programming:");
        System.out.println(
                "Maximum Benefit = " + dpResult
        );
        System.out.println(
                "Selected Jobs = " + dpJobs
        );
        System.out.println(
                "Execution Time = " + dpTime + " ns"
        );

        System.out.println();
        System.out.println(
                "==========================================="
        );
    }
}