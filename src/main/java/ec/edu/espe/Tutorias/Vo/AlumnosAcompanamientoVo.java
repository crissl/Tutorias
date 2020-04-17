package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class AlumnosAcompanamientoVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String CEDULA;
	private String NOMBRES;
	private String ID;
	private String CORREO_INSTITUCIONAL;
	private String CORREO_PERSONAL;
	private String CELULAR;
public AlumnosAcompanamientoVo() {
	
}
public  AlumnosAcompanamientoVo(  String CEDULA, String ID, String NOMBRES, String CORREO_INSTITUCIONAL, String CORREO_PERSONAL, String CELULAR) {
	this.CEDULA=CEDULA;
	this.ID=ID;
	this.NOMBRES=NOMBRES;
	this.CORREO_INSTITUCIONAL=CORREO_INSTITUCIONAL;
	this.CORREO_PERSONAL=CORREO_PERSONAL;
	this.CELULAR =CELULAR;
}
public String getCEDULA() {
	return CEDULA;
}
public void setCEDULA(String cEDULA) {
	CEDULA = cEDULA;
}
public String getNOMBRES() {
	return NOMBRES;
}
public void setNOMBRES(String nOMBRES) {
	NOMBRES = nOMBRES;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getCORREO_INSTITUCIONAL() {
	return CORREO_INSTITUCIONAL;
}
public void setCORREO_INSTITUCIONAL(String cORREO_INSTITUCIONAL) {
	CORREO_INSTITUCIONAL = cORREO_INSTITUCIONAL;
}
public String getCORREO_PERSONAL() {
	return CORREO_PERSONAL;
}
public void setCORREO_PERSONAL(String cORREO_PERSONAL) {
	CORREO_PERSONAL = cORREO_PERSONAL;
}
public String getCELULAR() {
	return CELULAR;
}
public void setCELULAR(String cELULAR) {
	CELULAR = cELULAR;
}


}
