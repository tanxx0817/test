package com.test.clone;

public class Address implements Cloneable {
	
	private String addr; 
	 
    public String getAddr() { 
        return addr; 
    } 
 
    public void setAddr(String addr) { 
        this.addr = addr; 
    } 
    
    public Object clone() {
    	Address addr = null;
    	try {
    		addr = (Address) super.clone();
    	} catch (CloneNotSupportedException e) {
    		e.printStackTrace();
    	}
    	return addr;
    }
    
}
