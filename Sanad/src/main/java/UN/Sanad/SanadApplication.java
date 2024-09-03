package UN.Sanad;

import UN.Sanad.User.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SanadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanadApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(
			UserRepo userRepo
	){
		return args -> {
			//var user= Users.builder().name().email().build();

		};
	}

}
