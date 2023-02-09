package co.com.sofka.prueba.pruebajavaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PruebaJavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaJavaSpringApplication.class, args);
	}

}
