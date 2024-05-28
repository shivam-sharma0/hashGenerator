package com.DotNetCoverter.hashGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.DotNetCoverter.hashGenerator.HashUtility.getHash;

@SpringBootApplication
public class HashGeneratorApplication {
	public static void main(String[] args) {

		SpringApplication.run(HashGeneratorApplication.class, args);

		try {
			String hashJson = getHash("archit");
			System.out.println(hashJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
