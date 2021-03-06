package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class PlanificacionReforzamientoVo implements Serializable{
	private static final long serialVersionUID = 1L;
    private String NRC;
    private String CODIGO_ASIGNATURA;
    private String ASIGNATURA;
    private String CAMPUS;
    private String PERIODO;
    private String INICIO;
    private String FIN;
    

   public PlanificacionReforzamientoVo(){
   }
   
    
    public PlanificacionReforzamientoVo(String NRC, String CODIGO_ASIGNATURA, String ASIGNATURA, String CAMPUS, String PERIODO, String INICIO, String FIN )
    {
    this.NRC=NRC;
    this.CODIGO_ASIGNATURA=CODIGO_ASIGNATURA;
    this.ASIGNATURA=ASIGNATURA;
    this.CAMPUS=CAMPUS;
    this.PERIODO=PERIODO;
    this.INICIO=PERIODO;
    this.FIN=FIN;
    	
    }


	public String getCODIGO_ASIGNATURA() {
		return CODIGO_ASIGNATURA;
	}


	public void setCODIGO_ASIGNATURA(String cODIGO_ASIGNATURA) {
		CODIGO_ASIGNATURA = cODIGO_ASIGNATURA;
	}


	public String getNRC() {
		return NRC;
	}


	public void setNRC(String nRC) {
		NRC = nRC;
	}


	public String getASIGNATURA() {
		return ASIGNATURA;
	}


	public void setASIGNATURA(String aSIGNATURA) {
		ASIGNATURA = aSIGNATURA;
	}


	public String getCAMPUS() {
		return CAMPUS;
	}


	public void setCAMPUS(String cAMPUS) {
		CAMPUS = cAMPUS;
	}


	public String getPERIODO() {
		return PERIODO;
	}


	public void setPERIODO(String pERIODO) {
		PERIODO = pERIODO;
	}


	public String getINICIO() {
		return INICIO;
	}


	public void setINICIO(String iNICIO) {
		INICIO = iNICIO;
	}


	public String getFIN() {
		return FIN;
	}


	public void setFIN(String fIN) {
		FIN = fIN;
	}
    	
  


    

}
