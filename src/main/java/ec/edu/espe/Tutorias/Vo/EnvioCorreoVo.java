package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity 
@Table(name="wfobjects")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery (
		name = "proceso1", 
		procedureName  =  "wzwkreport.P_Envio_Emails",
parameters   = {
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_mensaje" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_emailp" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_mensajeprincipal" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_notificacion1" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_notificacion2" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "Cedula" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "Nombres" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "Email" , type = String.class),
		@StoredProcedureParameter ( mode  =  ParameterMode . IN , name  =  "par_notificacion2" , type = String.class),

		},
resultClasses = EnvioCorreoVo.class

)})
public class EnvioCorreoVo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String Cedula = "1725292757";
	String Actividad = "";
	String Campus = "";
	String Razon = "";
	String Carrera ="";
	String Cod ="";
	
	private String Email="cac.lopez@yavirac.edu.ec";
	private String Nombres= "Christian Lopez";
	private String par_mensaje;
	private String par_emailp;
	private String par_mensajeprincipal;
	private String par_notificacion1;
	private String par_notificacion2;
	
	public EnvioCorreoVo() {
		
		
	}

	public EnvioCorreoVo(String par_mensaje, String par_emailp, String par_mensajeprincipal, String par_notificacion1, String par_notificacion2) {

		this.par_mensaje = " el formulario " + Cod + " " + Actividad + " fue llenado";
	    this.par_emailp = "auditoria_sis@espe.edu.ec";
	    this.par_mensajeprincipal = " espere por favor una hora y podrá realizar su matricula";
	    this.par_notificacion1 = " del Campus " + Campus + " y Carrera " + Carrera + ", por la siguiente Razon: " + Razon;
	    this.par_notificacion2 = " la solicitud será procesada ";
		
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String campus) {
		Campus = campus;
	}

	public String getRazon() {
		return Razon;
	}

	public void setRazon(String razon) {
		Razon = razon;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public String getPar_mensaje() {
		return par_mensaje;
	}

	public void setPar_mensaje(String par_mensaje) {
		this.par_mensaje = par_mensaje;
	}

	public String getPar_emailp() {
		return par_emailp;
	}

	public void setPar_emailp(String par_emailp) {
		this.par_emailp = par_emailp;
	}

	public String getPar_mensajeprincipal() {
		return par_mensajeprincipal;
	}

	public void setPar_mensajeprincipal(String par_mensajeprincipal) {
		this.par_mensajeprincipal = par_mensajeprincipal;
	}

	public Object getPar_notificacion1() {
		return par_notificacion1;
	}

	public void setPar_notificacion1(String par_notificacion1) {
		this.par_notificacion1 = par_notificacion1;
	}

	public String getPar_notificacion2() {
		return par_notificacion2;
	}

	public void setPar_notificacion2(String par_notificacion2) {
		this.par_notificacion2 = par_notificacion2;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	
}
