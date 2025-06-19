package org.fakebankproject.fakebankproject;//package org.fakebankproject.fakebankproject;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FakebankprojectApplication {

	public static void main(String[] args) {

		String envPath = System.getProperty("user.dir") + "/fakebankproject";
		Dotenv dotenv = Dotenv.configure()
				.directory(envPath)
				.filename(".env")
				.load();
		System.setProperty("spring.datasource.url",      dotenv.get("DB_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("DB_USER"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		System.setProperty("spring.datasource.driver-class-name", "org.postgresql.Driver");
		System.setProperty("jwt.secret", dotenv.get("JWT_SECRET"));
		System.setProperty("jwt.expiration", dotenv.get("JWT_EXPIRATION"));
		SpringApplication.run(FakebankprojectApplication.class, args);
	}
}
