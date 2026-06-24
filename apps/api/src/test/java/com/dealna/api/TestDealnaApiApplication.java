package com.dealna.api;

import org.springframework.boot.SpringApplication;

public class TestDealnaApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(DealnaApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
