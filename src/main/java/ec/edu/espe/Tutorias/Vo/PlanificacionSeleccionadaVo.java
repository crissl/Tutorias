package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class PlanificacionSeleccionadaVo implements Serializable{
	private static final long serialVersionUID = 1L;
    private String NRC;
    private String ASIGNATURA;
    private String CAMPUS;
    private String PERIODO;


   public PlanificacionSeleccionadaVo(){
   }
   
    
    public PlanificacionSeleccionadaVo(String NRC, String ASIGNATURA, String CAMPUS, String PERIODO)
    {
    this.NRC=NRC;
    this.ASIGNATURA=ASIGNATURA;
    this.CAMPUS=CAMPUS;
    this.PERIODO=PERIODO;
  
    	
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


	
    	
  


    

}
