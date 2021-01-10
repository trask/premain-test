package com.github.trask.premain;

import java.lang.instrument.Instrumentation;

public class Test {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        Fibonacci.trackExecutionSpeed(100000);
    }

    public static void main(String[] args) {
        Fibonacci.trackExecutionSpeed(100000);
    }
}
