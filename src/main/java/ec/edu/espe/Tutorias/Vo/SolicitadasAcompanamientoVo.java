package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class SolicitadasAcompanamientoVo implements Serializable{
	private static final long serialVersionUID = 1L;
    private String TUTORIA;
    private String ID;
    private String NOMBRES;
    private String TEMA;
    private String OBSERVACION;
    private String FECHA;
    
    public SolicitadasAcompanamientoVo () {
    	
    }
    public SolicitadasAcompanamientoVo (String TUTORIA, String ID, String NOMBRES, String TEMA, String OBSERVACION, String FECHA) {
    	
    this.TUTORIA=TUTORIA;
    this.ID=ID;
    this.NOMBRES=NOMBRES;
    this.TEMA=TEMA;
    this.OBSERVACION=OBSERVACION;
    this.FECHA=FECHA;
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
	public String getTEMA() {
		return TEMA;
	}
	public void setTEMA(String tEMA) {
		TEMA = tEMA;
	}
	public String getOBSERVACION() {
		return OBSERVACION;
	}
	public void setOBSERVACION(String oBSERVACION) {
		OBSERVACION = oBSERVACION;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}


    
}
