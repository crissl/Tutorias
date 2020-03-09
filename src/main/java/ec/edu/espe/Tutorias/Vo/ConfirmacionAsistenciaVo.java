package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class ConfirmacionAsistenciaVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int CODIGO;
	private int PLANIFICACION;
	private String TEMA;
	
	 public ConfirmacionAsistenciaVo() {
	    }
	 public ConfirmacionAsistenciaVo(int CODIGO, int PLANIFICACION, String TEMA) 
			  {
		 this.CODIGO=CODIGO;
		 this.PLANIFICACION=PLANIFICACION;
		 this.TEMA=TEMA;
	    }
	public int getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(int CODIGO) {
		this.CODIGO = CODIGO;
	}
	public int getPLANIFICACION() {
		return PLANIFICACION;
	}
	public void setPLANIFICACION(int PLANIFICACION) {
		this.PLANIFICACION = PLANIFICACION;
	}
	public String getTEMA() {
		return TEMA;
	}
	public void setTEMA(String TEMA) {
		this.TEMA = TEMA;
	}
	 
}
