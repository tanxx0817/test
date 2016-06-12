package com.test.callback;

public class Test {

	public static void main(String[] args) {
		Li li = new Li();
		Wang wang = new Wang(li);
		String question = "1 +1 = ?";
		wang.askQuestion(question);
	}
}
