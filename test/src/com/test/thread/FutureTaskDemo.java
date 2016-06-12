package com.test.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) {
		PrivateAccount accTask = new PrivateAccount();
		FutureTask<Object> futureTask = new FutureTask<Object>(accTask);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		System.out.println("submit the futureTask, time is : " + System.nanoTime()); 
		executor.submit(futureTask);
		System.out.println("the main thread begin to handle other tasks..."); 
		int amount_1 = new Random().nextInt(100000);  
        System.out.println("the total amount of your other accounts is : " + amount_1);  
        System.out.println("waiting for computing your private account..."); 
        while (!futureTask.isDone()) {
        	try {
        		Thread.sleep(100);
        		System.out.println("computing your private account is not finished..."); 
        	} catch (InterruptedException ex) {
        		ex.printStackTrace();
        	}
        }
        System.out.println("the end of futureTask, time is : " + System.nanoTime());  
        Integer amount_2 = null;
        try {
        	amount_2 = (Integer) futureTask.get();
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        } catch (ExecutionException ex) {
        	ex.printStackTrace();
        } finally {
        	executor.shutdown();
        }
        
        Integer amount = amount_1 + amount_2.intValue();
        System.out.println("the total amount is : " + amount);
	}
}
