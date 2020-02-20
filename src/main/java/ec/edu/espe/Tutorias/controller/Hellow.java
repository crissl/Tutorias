package ec.edu.espe.Tutorias.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")

public class Hellow {
	

	
	public class Hi {
		@RequestMapping("/Hola")
	    String hola() 
	    {
	        return "Tutorias";
	    }
	}


}
