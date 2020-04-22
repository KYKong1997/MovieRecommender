package com.movie_rec.postgresReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostgresReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresReaderApplication.class, args);
	}

}
