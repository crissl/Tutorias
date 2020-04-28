package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class EstudianteVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int SGBSTDN_PIDM;

    public EstudianteVo() {
		
	}

	public EstudianteVo(int SGBSTDN_PIDM) {
		this.SGBSTDN_PIDM=SGBSTDN_PIDM;
	}

	public int getSGBSTDN_PIDM() {
		return SGBSTDN_PIDM;
	}

	public void setSGBSTDN_PIDM(int sGBSTDN_PIDM) {
		SGBSTDN_PIDM = sGBSTDN_PIDM;
	}
	
}
