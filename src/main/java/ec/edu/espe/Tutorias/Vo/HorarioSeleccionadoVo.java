package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class HorarioSeleccionadoVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String AULA;

	
public HorarioSeleccionadoVo() {
		
	}
	
    public HorarioSeleccionadoVo(String AULA) {
    	this.AULA= AULA;

  
	}

	public String getAULA() {
		return AULA;
	}

	public void setAULA(String aULA) {
		AULA = aULA;
	}

	

	
}
