package com.boot.Curdproject.curdProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.io.IOException;

@SpringBootApplication
public class CurdProjectApplication implements CommandLineRunner {


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

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {

		//System.out.println(passwordEncoder.encode("9415234567"));
		String password = "9415234567";
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(hashedPassword);
	}
}
