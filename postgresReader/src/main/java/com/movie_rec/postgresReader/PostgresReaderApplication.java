package com.movie_rec.postgresReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.movie_rec.postgresReader"})
@ComponentScan({"com.movie_rec.postgresReader"})
@EnableJpaAuditing
public class PostgresReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresReaderApplication.class, args);
	}

}
