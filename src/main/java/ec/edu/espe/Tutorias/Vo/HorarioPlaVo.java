package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class HorarioPlaVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String AULA;
	private String HORARIO;
	private int HORA_INICIO;
	private int HORA_FIN;
	
public HorarioPlaVo() {
		
	}
	
    public HorarioPlaVo(String AULA, String HORARIO, int HORA_INICIO, int HORA_FIN) {
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

	public int getHORA_INICIO() {
		return HORA_INICIO;
	}

	public void setHORA_INICIO(int hORA_INICIO) {
		HORA_INICIO = hORA_INICIO;
	}

	public int getHORA_FIN() {
		return HORA_FIN;
	}

	public void setHORA_FIN(int hORA_FIN) {
		HORA_FIN = hORA_FIN;
	}

	
}
