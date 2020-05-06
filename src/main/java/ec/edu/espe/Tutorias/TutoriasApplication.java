package ec.edu.espe.Tutorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class TutoriasApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TutoriasApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(TutoriasApplication.class, args);
		 System.out.println("Tutorias esta corriendo");

	}

}
