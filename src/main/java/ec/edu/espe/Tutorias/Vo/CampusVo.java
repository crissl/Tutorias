package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class CampusVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int CODIGO;
	private String CAMPUS;

	public CampusVo () {
    }
	public CampusVo (int CODIGO, String CAMPUS) {
		this.CODIGO=CODIGO;
		this.CAMPUS=CAMPUS;
    }
	public int getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}
	public String getCAMPUS() {
		return CAMPUS;
	}
	public void setCAMPUS(String cAMPUS) {
		CAMPUS = cAMPUS;
	}
	
	

}
