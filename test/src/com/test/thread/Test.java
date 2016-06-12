package com.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		
		/*Future<Integer> result = executor.submit(task);
		executor.shutdown();*/
		
		FutureTask<Integer> result = new FutureTask<Integer>(task);
		executor.submit(result);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("the main thread is executing a task...");
		try {
			System.out.println("the result of main thread is " + result.get());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (ExecutionException ex) {
			ex.printStackTrace();
		}
		System.out.println("the end of the thread...");
	}
}
