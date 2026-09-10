package com.aigpu.resourceoptimizer.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForce {

    public static int findMaximumBenefit(
            int[] gpu,
            int[] benefit,
            int capacity) {

        return solve(gpu, benefit, capacity, 0);
    }

    private static int solve(
            int[] gpu,
            int[] benefit,
            int capacity,
            int index) {

        // Base case
        if (index == gpu.length || capacity == 0) {
            return 0;
        }

        // Don't select current job
        int notTake = solve(
                gpu,
                benefit,
                capacity,
                index + 1
        );

        // Select current job
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

        return Math.max(take, notTake);
    }


    public static List<Integer> findSelectedJobs(
            int[] gpu,
            int[] benefit,
            int capacity) {

        List<Integer> selectedJobs = new ArrayList<>();

        findJobs(
                gpu,
                benefit,
                capacity,
                0,
                selectedJobs
        );

        Collections.sort(selectedJobs);

        return selectedJobs;
    }


    private static void findJobs(
            int[] gpu,
            int[] benefit,
            int capacity,
            int index,
            List<Integer> selectedJobs) {

        // No more jobs or no capacity
        if (index == gpu.length || capacity == 0) {
            return;
        }

        int notTake = solve(
                gpu,
                benefit,
                capacity,
                index + 1
        );

        int take = -1;

        if (gpu[index] <= capacity) {

            take = benefit[index]
                    + solve(
                    gpu,
                    benefit,
                    capacity - gpu[index],
                    index + 1
            );
        }

        // If taking the job gives the optimal result
        if (take >= notTake && take != -1) {

            selectedJobs.add(index + 1);

            findJobs(
                    gpu,
                    benefit,
                    capacity - gpu[index],
                    index + 1,
                    selectedJobs
            );

        } else {

            // Don't take the job
            findJobs(
                    gpu,
                    benefit,
                    capacity,
                    index + 1,
                    selectedJobs
            );
        }
    }
}