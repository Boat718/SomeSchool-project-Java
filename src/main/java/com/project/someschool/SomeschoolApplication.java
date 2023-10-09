package com.project.someschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.someschool.repository")
@EntityScan("com.project.someschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SomeschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeschoolApplication.class, args);
	}

}
