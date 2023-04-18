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

	}


}
