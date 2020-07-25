package com.sinhro.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {//Spring1Application

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	public static void test(){
		String port = System.getenv("PORT");
		System.out.println(port);
	}
}
