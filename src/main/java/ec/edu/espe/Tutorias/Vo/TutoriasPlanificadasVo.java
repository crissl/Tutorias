package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class TutoriasPlanificadasVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String TUTORIA;
	private String TEMA;
	private String ASIGNATURA;
	private String FECHA;
	private String AULA;
	private String FECHA_CREA;
public TutoriasPlanificadasVo() {
	
}
public TutoriasPlanificadasVo(String TUTORIA, String TEMA, String ASIGNATURA, String FECHA, String AULA, String FECHA_CREA) {
	this.TUTORIA=TUTORIA;
	this.TEMA=TEMA;
	this.ASIGNATURA=ASIGNATURA;
	this.FECHA=FECHA;
	this.AULA=AULA;
	this.FECHA_CREA=FECHA_CREA;
	
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
public String getFECHA_CREA() {
	return FECHA_CREA;
}
public void setFECHA_CREA(String fECHA_CREA) {
	FECHA_CREA = fECHA_CREA;
}


}
