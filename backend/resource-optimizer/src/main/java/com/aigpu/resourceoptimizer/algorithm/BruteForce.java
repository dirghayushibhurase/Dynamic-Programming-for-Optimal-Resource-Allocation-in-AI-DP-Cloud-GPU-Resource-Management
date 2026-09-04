package com.aigpu.resourceoptimizer.algorithm;

public class BruteForce {

    public static int findMaximumBenefit(int[] gpu, int[] benefit, int capacity) {

        return solve(gpu, benefit, capacity, 0);
    }

    private static int solve(int[] gpu, int[] benefit, int capacity, int index) {

        // Base case
        if (index == gpu.length || capacity == 0) {
            return 0;
        }

        // Option 1: Don't select the current job
        int notTake = solve(gpu, benefit, capacity, index + 1);

        // Option 2: Select the current job
        int take = 0;

        if (gpu[index] <= capacity) {

            take = benefit[index]
                    + solve(
                        gpu,
                        benefit,
                        capacity - gpu[index],
                        index + 1
                    );
        }

        // Return the better option
        return Math.max(take, notTake);
    }
}