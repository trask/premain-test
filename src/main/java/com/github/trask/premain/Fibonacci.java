package com.github.trask.premain;

// from https://medium.com/@rodrigo.javier.ramirez/understanding-java-jit-compiler-787f87daa110

/**
 * Class used to measure the effect of JIT on a simple calculation.
 * It calculates the fibonacci of some number many times,
 * calculating and printing the average time per execution. The
 * process is repeated many times to understand the long term
 * effect.
 *
 * @author Rodrigo Ramirez
 */
public class Fibonacci {

    /**
     * Calculates the Fibonacci of n.
     *
     * @param n
     * @return f(n)
     */
    public static int f(int n) {
        if (n <= 2) {
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }

        return result;
    }

    /**
     * Prints the average time it takes to calculate f(n).
     */
    public static void trackExecutionSpeed(int iterations) {
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 50; j++) {
                f(100);
            }
            long totalTime = System.nanoTime() - startTime;
            System.out.println(totalTime / 50);
        }
    }
}
