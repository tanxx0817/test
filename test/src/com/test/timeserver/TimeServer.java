package com.test.timeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	
	static void startup (int port) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("server started...");
			Socket socket = null;
			TimeServerPool pool = new TimeServerPool(50, 1000);
			while (true) {
				socket = server.accept(); 
				System.out.println("accept a connection..");
//				new Thread(new TimeServerHandler(socket)).start();
				pool.execute(new TimeServerHandler(socket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != server) {
				System.out.println("the time server closed");
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		TimeServer.startup(8080);
//		System.out.println(System.getProperty("user.home") );
	}
}
