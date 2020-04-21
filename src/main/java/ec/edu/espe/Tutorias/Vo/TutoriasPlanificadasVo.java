package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class TutoriasPlanificadasVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String TUTORIA;
	private String TEMA;
	private String ASIGNATURA;
	private String FECHA;
	private String HORA;
	private String AULA;

	private String FEC;
public TutoriasPlanificadasVo() {
	
}
public TutoriasPlanificadasVo(String TUTORIA, String TEMA, String ASIGNATURA, String FECHA, String AULA,String HORA, String FEC) {
	this.TUTORIA=TUTORIA;
	this.TEMA=TEMA;
	this.ASIGNATURA=ASIGNATURA;
	this.FECHA=FECHA;
	this.HORA=HORA;
	this.AULA=AULA;
	this.FEC=FEC;
	
}
public String getHORA() {
	return HORA;
}
public void setHORA(String hORA) {
	HORA = hORA;
}
public String getTUTORIA() {
	return TUTORIA;
}
public void setTUTORIA(String tUTORIA) {
	TUTORIA = tUTORIA;
}
public String getTEMA() {
	return TEMA;
}
public void setTEMA(String tEMA) {
	TEMA = tEMA;
}
public String getASIGNATURA() {
	return ASIGNATURA;
}
public void setASIGNATURA(String aSIGNATURA) {
	ASIGNATURA = aSIGNATURA;
}
public String getFECHA() {
	return FECHA;
}
public void setFECHA(String fECHA) {
	FECHA = fECHA;
}
public String getAULA() {
	return AULA;
}
public void setAULA(String aULA) {
	AULA = aULA;
}
public String getFEC() {
	return FEC;
}
public void setFEC(String fEC) {
	FEC = fEC;
}



}
