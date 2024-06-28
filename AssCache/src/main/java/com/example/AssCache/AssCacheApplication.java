package com.example.AssCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AssCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssCacheApplication.class, args);
	}

}
