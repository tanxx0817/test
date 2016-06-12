package com.test.thread;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("the sub thread is computing...");
        Thread.sleep(3000);
        System.out.println("the sub thread sleep 3 seconds...");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
        	sum += i;
        }
        return sum;
	}
}
