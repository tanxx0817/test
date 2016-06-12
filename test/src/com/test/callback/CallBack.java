package com.test.callback;

/** 
 * 这是一个回调接口 
 * 
 * Class A实现接口CallBack callback——背景1
 * class A中包含一个class B的引用b ——背景2
 * class B有一个参数为callback的方法f(CallBack callback) ——背景3
 * A的对象a调用B的方法 f(CallBack callback) ——A类调用B类的某个方法 C
 * 然后b就可以在f(CallBack callback)方法中调用A的方法 ——B类调用A类的某个方法D
 * 
 * 有一天小王遇到一个很难的问题，问题是“1 + 1 = ?”，就打电话问小李，小李一下子也不知道，
 * 就跟小王说，等我办完手上的事情，就去想想答案，小王也不会傻傻的拿着电话去等小李的答案吧，
 * 于是小王就对小李说，我还要去逛街，你知道了答案就打我电话告诉我，于是挂了电话，自己办自己的事情，
 * 过了一个小时，小李打了小王的电话，告诉他答案是2
 */ 
public interface CallBack {
	/** 
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数 
     * @param result 是答案 
     */  
	public void solve(String result);
}
