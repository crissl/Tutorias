package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class HorarioVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String AULA;
	private String HORARIO;
	private String HORA_INICIO;
	private String HORA_FIN;
	
	public HorarioVo() {
		
	}
	
    public HorarioVo(String AULA, String HORARIO, String HORA_INICIO, String HORA_FIN) {
    	this.AULA= AULA;
    	this.HORARIO=HORARIO;
    	this.HORA_INICIO=HORA_INICIO;
    	this.HORA_FIN=HORA_FIN;
    			
  
	}

	public String getAULA() {
		return AULA;
	}

	public void setAULA(String aULA) {
		AULA = aULA;
	}

	public String getHORARIO() {
		return HORARIO;
	}

	public void setHORARIO(String hORARIO) {
		HORARIO = hORARIO;
	}

	public String getHORA_INICIO() {
		return HORA_INICIO;
	}

	public void setHORA_INICIO(String hORA_INICIO) {
		HORA_INICIO = hORA_INICIO;
	}

	public String getHORA_FIN() {
		return HORA_FIN;
	}

	public void setHORA_FIN(String hORA_FIN) {
		HORA_FIN = hORA_FIN;
	}
	
	
}