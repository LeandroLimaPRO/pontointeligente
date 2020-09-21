package com.pulse.provarh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.pulse.provarh")
@EntityScan(basePackages = "com.pulse.provarh.datasource.model")
public class ProvarhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvarhApplication.class, args);
	}

}
