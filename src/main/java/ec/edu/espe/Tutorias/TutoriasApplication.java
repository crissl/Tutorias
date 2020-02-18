package ec.edu.espe.Tutorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TutoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoriasApplication.class, args);
		 System.out.println("Tutorias");

	}

}
