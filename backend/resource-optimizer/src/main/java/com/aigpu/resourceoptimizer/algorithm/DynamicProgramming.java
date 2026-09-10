package com.aigpu.resourceoptimizer.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicProgramming {

    public static int findMaximumBenefit(int[] gpu, int[] benefit, int capacity) {

        int n = gpu.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
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


    public static List<Integer> findSelectedJobs(
            int[] gpu,
            int[] benefit,
            int capacity) {

        int n = gpu.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table again
        for (int i = 1; i <= n; i++) {

            for (int c = 0; c <= capacity; c++) {

                dp[i][c] = dp[i - 1][c];

                if (gpu[i - 1] <= c) {

                    dp[i][c] = Math.max(
                            dp[i][c],
                            benefit[i - 1] + dp[i - 1][c - gpu[i - 1]]
                    );
                }
            }
        }

        // Backtracking
        List<Integer> selectedJobs = new ArrayList<>();

        int c = capacity;

        for (int i = n; i > 0; i--) {

            // If value changed, current job was selected
            if (dp[i][c] != dp[i - 1][c]) {

                selectedJobs.add(i);

                c = c - gpu[i - 1];
            }
        }

        // Reverse so jobs appear in normal order
        Collections.reverse(selectedJobs);

        return selectedJobs;
    }
}