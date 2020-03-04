package ec.edu.espe.Tutorias.model;
import java.io.Serializable;

public class mensajeApi implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 private String mensaje;

	 public mensajeApi() {
	 }

	 public String getMensaje() {
	  return mensaje;
	 }

	 public void setMensaje(String mensaje) {
	  this.mensaje = mensaje;
	 }
}
