package com.embarkx.challengeapp;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeappApplication {

	public static void main(String[] args) {

        SpringApplication.run(ChallengeappApplication.class, args);
	}

}
