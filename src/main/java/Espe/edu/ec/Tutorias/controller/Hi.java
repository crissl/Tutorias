package Espe.edu.ec.Tutorias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sdn")
public class Hi {
	@RequestMapping("/Hola")
    String hola() 
    {
        return "Tutorias";
    }
}
