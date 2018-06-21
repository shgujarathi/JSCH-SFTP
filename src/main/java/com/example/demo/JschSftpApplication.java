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

	// Scheduler which will invoke send method for every 15 Seconds
	@Scheduled(initialDelay = 1000, fixedRate = 15000)
	public void run() {
		new JschApp().send();
	}

}
