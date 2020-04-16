package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class ConvocadosVo implements Serializable{
private static final long serialVersionUID = 1L;

private int PIDM;
private String ID;
private String CEDULA;
private String NOMBRES;
private String CORREO_INSTITUCIONAL;
private String CORREO_PERSONAL;

public ConvocadosVo () {
	
}
public ConvocadosVo (int PIDM, String ID, String CEDULA, String NOMBRES, String CORREO_INSTITUCIONAL, String CORREO_PERSONAL) {

this.PIDM=PIDM;
this.ID=ID;
this.CEDULA=CEDULA;
this.NOMBRES=NOMBRES;
this.CORREO_INSTITUCIONAL=CORREO_INSTITUCIONAL;
this.CORREO_PERSONAL=CORREO_PERSONAL;
}
public int getPIDM() {
	return PIDM;
}
public void setPIDM(int pIDM) {
	PIDM = pIDM;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
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




	

}
