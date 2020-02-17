package controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HolaMundoControlador {
	@GetMapping
public String Saludo(@RequestParam(required = false, defaultValue = "")String nombre) {
	return "".equals(nombre)? "hola mundo": "bienvenido" + nombre;
	
}
}
