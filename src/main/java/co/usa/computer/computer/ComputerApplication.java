package co.usa.computer.computer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.computer.computer.model"})
@SpringBootApplication
public class ComputerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerApplication.class, args);
	}

}
