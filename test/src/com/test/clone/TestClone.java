package com.test.clone;

public class TestClone {

	public static void main(String[] args) {
		
		Address a1 = new Address();
		a1.setAddr("pudong");
		
		Student s1 = new Student();
		s1.setNumber(1111);
		s1.setAddr(a1);
		
		Student s2 = (Student) s1.clone();
		
		System.out.println("====s1.getNumber====" + s1.getNumber() + "====s1.getAddress====" + s1.getAddr().getAddr());
		System.out.println("====s2.getNumber====" + s2.getNumber() + "====s2.getAddress====" + s2.getAddr().getAddr());
		
//		Address a2 = new Address();
//		a2.setAddr("baoshan");
		a1.setAddr("baoshan");
		
		/*s2.setNumber(2222);
		s2.setAddr(a1);*/
		
		System.out.println("====s1.getNumber====" + s1.getNumber() + "====s1.getAddress====" + s1.getAddr().getAddr());
		System.out.println("====s2.getNumber====" + s2.getNumber() + "====s2.getAddress====" + s2.getAddr().getAddr());
	}

}
