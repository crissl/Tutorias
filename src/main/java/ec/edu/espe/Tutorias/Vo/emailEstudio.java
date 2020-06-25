package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class emailEstudio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String UZTASISTENTES_EMAIL;
	
	public emailEstudio () {
		
	}
    public emailEstudio (String UZTASISTENTES_EMAIL) {
		this.UZTASISTENTES_EMAIL=UZTASISTENTES_EMAIL;
	}
	public String getUZTASISTENTES_EMAIL() {
		return UZTASISTENTES_EMAIL;
	}
	public void setUZTASISTENTES_EMAIL(String uZTASISTENTES_EMAIL) {
		UZTASISTENTES_EMAIL = uZTASISTENTES_EMAIL;
	}
	

}
