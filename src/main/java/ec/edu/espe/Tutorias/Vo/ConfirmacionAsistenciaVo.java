package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class ConfirmacionAsistenciaVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int UZTASISTENTES_CODIGO;
	private int CODIGO_UZTPLANIF;
	private String UZTPLANIF_TEMA;
	
	 public ConfirmacionAsistenciaVo() {
	    }
	 public ConfirmacionAsistenciaVo(int CODIGO, int PLANIFICACION, String TEMA) 
			  {
		 this.UZTASISTENTES_CODIGO=CODIGO;
		 this.CODIGO_UZTPLANIF=PLANIFICACION;
		 this.UZTPLANIF_TEMA=TEMA;
	    }
	public int getUZTASISTENTES_CODIGO() {
		return UZTASISTENTES_CODIGO;
	}
	public void setUZTASISTENTES_CODIGO(int uZTASISTENTES_CODIGO) {
		UZTASISTENTES_CODIGO = uZTASISTENTES_CODIGO;
	}
	public int getCODIGO_UZTPLANIF() {
		return CODIGO_UZTPLANIF;
	}
	public void setCODIGO_UZTPLANIF(int cODIGO_UZTPLANIF) {
		CODIGO_UZTPLANIF = cODIGO_UZTPLANIF;
	}
	public String getUZTPLANIF_TEMA() {
		return UZTPLANIF_TEMA;
	}
	public void setUZTPLANIF_TEMA(String uZTPLANIF_TEMA) {
		UZTPLANIF_TEMA = uZTPLANIF_TEMA;
	}
	 }
	