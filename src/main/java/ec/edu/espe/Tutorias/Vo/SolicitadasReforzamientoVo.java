package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class SolicitadasReforzamientoVo implements Serializable{
	private static final long serialVersionUID = 1L;
    private String TUTORIA;
    private String ID;
    private String NOMBRES;
    private String ASIGNATURA;
    private String TEMA;
    private String FECHA;
    
public SolicitadasReforzamientoVo() {
	
}
public SolicitadasReforzamientoVo(String TUTORIA, String ID, String NOMBRES, String ASIGNATURA, String TEMA, String FECHA_CREA) {
	this.TUTORIA=TUTORIA;
	this.ID=ID;
	this.NOMBRES=NOMBRES;
	this.ASIGNATURA=ASIGNATURA;
	this.TEMA=TEMA;
	this.FECHA=FECHA_CREA;

}
public String getTUTORIA() {
	return TUTORIA;
}
public void setTUTORIA(String tUTORIA) {
	TUTORIA = tUTORIA;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getNOMBRES() {
	return NOMBRES;
}
public void setNOMBRES(String nOMBRES) {
	NOMBRES = nOMBRES;
}
public String getASIGNATURA() {
	return ASIGNATURA;
}
public void setASIGNATURA(String aSIGNATURA) {
	ASIGNATURA = aSIGNATURA;
}
public String getTEMA() {
	return TEMA;
}
public void setTEMA(String tEMA) {
	TEMA = tEMA;
}
public String getFECHA() {
	return FECHA;
}
public void setFECHA(String fECHA) {
	FECHA = fECHA;
}


}
