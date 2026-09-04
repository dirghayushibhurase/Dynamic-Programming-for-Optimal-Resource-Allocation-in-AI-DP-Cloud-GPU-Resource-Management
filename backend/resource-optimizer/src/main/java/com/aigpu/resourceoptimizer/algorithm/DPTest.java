package com.aigpu.resourceoptimizer.algorithm;

public class DPTest {

    public static void main(String[] args) {

        int[] gpu = {2, 3, 4, 5, 9};

        int[] benefit = {20, 30, 50, 60, 100};

        int capacity = 10;

        int result = DynamicProgramming.findMaximumBenefit(
                gpu,
                benefit,
                capacity
        );

        System.out.println("Maximum Benefit = " + result);
    }
}