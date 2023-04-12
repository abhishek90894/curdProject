package com.boot.Curdproject.curdProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.io.IOException;

@SpringBootApplication
public class CurdProjectApplication {

	public static void main(String[] args)
	{

		SpringApplication.run(CurdProjectApplication.class, args);
		String hostname = "localhost";
		int port = 9999;
		int timeout = 5000; // 5 seconds

		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(hostname, port), timeout);

		} catch (SocketTimeoutException e) {
			System.err.println("Socket connection timed out");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
