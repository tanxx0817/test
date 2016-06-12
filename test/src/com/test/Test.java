package com.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	
	public void getObj () {
		System.out.println(this.getClass());
	}
	
	static void getString (String...strings ) {
		System.out.println(strings.length);
		for (String str : strings) {
			System.out.println("=====" + str);
		}
	}
	
	public static int isPowerOfTwo(int val) {
//        return (val & -val) == val;
		return (val & -val);
    }
	
	static <T> List<T>  getList(List<? extends Object> l) {
		return new ArrayList<T>();
	}
	
	static void getContentType (String url) {
		try {
			String encoding = "UTF-8";
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			String contentType = uc.getContentType();
			System.out.println(contentType);
			int encodingStart = contentType.indexOf("charset=");
			if (encodingStart != -1) {
				encoding = contentType.substring(encodingStart + 8);
			}
			InputStream in = new BufferedInputStream(uc.getInputStream());
			Reader r = new InputStreamReader(in, encoding);
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
			r.close();
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a parseable URL");
		} catch (UnsupportedEncodingException ex) {
			System.err.println("Server sent an encoding Java does not support: " + ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	static void getBootstrapClass () {
//		System.out.println(String.class.getClassLoader());
	    System.out.println(ClassLoader.getSystemResource("java/lang/String.class"));  
	    /*URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();  
	    for (int i = 0; i < urls.length; i++) {  
	    	urls.
	      System.out.println(urls.toExternalForm());  
	    }  */
	}
	public static void main(String[] args) {
//		new Test().getObj();
//		System.out.println(Test.isPowerOfTwo(2));
//		Test.getString("5","2","3");
//		List<? extends T> list = new ArrayList<T extends Server>();
//		List<E> list = new ArrayList<E>();
//		Test.getContentType("http://www.sina.com.cn/");
//		Test.getBootstrapClass();
//		int i = Integer.parseInt("$.info.assetsDto.paperProfit");
//		System.out.println(System.getProperty("user.home"));
		
//		String bankAcctId = "6225882130489255965";
		String txt = "";
		for (int i = 0; i < 200001; i++ ) {
			if (i < 10) {
				txt = "990000000000000" + i + "\r\n";
			} 
			if (i > 9 && i < 100 ) {
				txt = "99000000000000" + i + "\r\n";
			}
			if (i > 99 && i < 1000 ) {
				txt = "9900000000000" + i + "\r\n";
			}
			if (i > 999 && i < 10000 ) {
				txt = "990000000000" + i + "\r\n";
			}
			if (i > 9999 && i < 100000 ) {
				txt = "99000000000" + i + "\r\n";
			} 
			if (i > 99999 && i < 200001 ) {
				txt = "9900000000" + i + "\r\n";
			} 
			
			writeToFile(txt);
		}
		System.out.println("end");
	}
	
	static void writeToFile (String txt) {
		FileOutputStream out = null;
		try {
			String path="E:/cardNo.txt";
			File file=new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file, true); //如果追加方式用true        
			out.write(txt.getBytes("utf-8"));//注意需要转换对应的字符集
        } catch(IOException ex)  {
            System.out.println(ex.getStackTrace());
        } finally {
        	try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

}
