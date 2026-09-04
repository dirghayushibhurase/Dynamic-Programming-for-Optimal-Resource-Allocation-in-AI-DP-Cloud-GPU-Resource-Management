package com.aigpu.resourceoptimizer.algorithm;

public class DynamicProgramming {

    public static int findMaximumBenefit(int[] gpu, int[] benefit, int capacity) {

        int n = gpu.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            for (int c = 0; c <= capacity; c++) {

                // Don't select the current job
                dp[i][c] = dp[i - 1][c];

                // Select the current job if it fits
                if (gpu[i - 1] <= c) {

                    dp[i][c] = Math.max(
                            dp[i][c],
                            benefit[i - 1] + dp[i - 1][c - gpu[i - 1]]
                    );
                }
            }
        }

        return dp[n][capacity];
    }
}