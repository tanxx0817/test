package com.test.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class PrivateAccount implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		Thread.sleep(5000);  
        Integer totalMoney = new Integer(new Random().nextInt(10000));  
        System.out.println("the balance of your private account is : " + totalMoney);  
        return totalMoney;  
	}

}
