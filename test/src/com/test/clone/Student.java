package com.test.clone;

public class Student implements Cloneable {
	
	private int number; 
    private Address addr; 
     
    public Address getAddr() {
        return addr; 
    } 
 
    public void setAddr(Address addr) {
        this.addr = addr; 
    } 
 
    public int getNumber() {
        return number; 
    } 
 
    public void setNumber(int number) {
        this.number = number; 
    } 
    
    public Object clone() {
    	Student s = null;
    	try {
    		s = (Student) super.clone(); //shallow copy
    	} catch (CloneNotSupportedException e) {
    		e.printStackTrace();
    	}
//    	s.addr = (Address) addr.clone(); //deep copy
    	return s;
    }
}
