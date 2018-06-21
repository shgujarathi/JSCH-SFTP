package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class JschSftpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JschSftpApplication.class, args);

	}

	@Scheduled(initialDelay = 1000, fixedRate = 15000)
	public void run() {
		new JSCHAPP().send();
	}

}
