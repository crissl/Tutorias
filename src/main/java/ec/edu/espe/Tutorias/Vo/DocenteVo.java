package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class DocenteVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String SIRASGN_PIDM;
	
	public DocenteVo() {
		
	}
    public DocenteVo(String SIRASGN_PIDM) {
    	this.SIRASGN_PIDM=SIRASGN_PIDM;
		
	}
	public String getSIRASGN_PIDM() {
		return SIRASGN_PIDM;
	}
	public void setSIRASGN_PIDM(String sIRASGN_PIDM) {
		SIRASGN_PIDM = sIRASGN_PIDM;
	}
	

}
