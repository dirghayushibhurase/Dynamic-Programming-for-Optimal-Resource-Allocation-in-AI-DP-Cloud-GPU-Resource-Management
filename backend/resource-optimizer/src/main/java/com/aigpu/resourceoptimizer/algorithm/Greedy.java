package com.aigpu.resourceoptimizer.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Greedy {

    static class Job {

        int jobNumber;
        int gpu;
        int benefit;
        double ratio;

        Job(int jobNumber, int gpu, int benefit) {

            this.jobNumber = jobNumber;
            this.gpu = gpu;
            this.benefit = benefit;
            this.ratio = (double) benefit / gpu;
        }
    }


    public static int findMaximumBenefit(
            int[] gpu,
            int[] benefit,
            int capacity) {

        int n = gpu.length;

        Job[] jobs = new Job[n];

        // Create jobs
        for (int i = 0; i < n; i++) {

            jobs[i] = new Job(
                    i + 1,
                    gpu[i],
                    benefit[i]
            );
        }

        // Sort by highest benefit/GPU ratio
        Arrays.sort(
                jobs,
                (a, b) -> Double.compare(
                        b.ratio,
                        a.ratio
                )
        );

        int totalBenefit = 0;
        int usedGpu = 0;

        // Select jobs
        for (Job job : jobs) {

            if (usedGpu + job.gpu <= capacity) {

                usedGpu += job.gpu;
                totalBenefit += job.benefit;
            }
        }

        return totalBenefit;
    }


    public static List<Integer> findSelectedJobs(
            int[] gpu,
            int[] benefit,
            int capacity) {

        int n = gpu.length;

        Job[] jobs = new Job[n];

        // Create jobs
        for (int i = 0; i < n; i++) {

            jobs[i] = new Job(
                    i + 1,
                    gpu[i],
                    benefit[i]
            );
        }

        // Sort by highest ratio
        Arrays.sort(
                jobs,
                (a, b) -> Double.compare(
                        b.ratio,
                        a.ratio
                )
        );

        List<Integer> selectedJobs = new ArrayList<>();

        int usedGpu = 0;

        // Select jobs
        for (Job job : jobs) {

            if (usedGpu + job.gpu <= capacity) {

                usedGpu += job.gpu;

                selectedJobs.add(job.jobNumber);
            }
        }

        // Display jobs in original order
        Collections.sort(selectedJobs);

        return selectedJobs;
    }
}