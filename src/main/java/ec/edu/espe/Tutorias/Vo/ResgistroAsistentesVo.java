package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class ResgistroAsistentesVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int CODIGO_UZTPLANIF;
	private String UZTPLANIF_TITOTUTORIA;
	private String UZTPLANIF_TEMA;
	
	public ResgistroAsistentesVo() {
		
	}

    public ResgistroAsistentesVo(int CODIGO_UZTPLANIF, String UZTPLANIF_TITOTUTORIA, String UZTPLANIF_TEMA) {
        this.CODIGO_UZTPLANIF = CODIGO_UZTPLANIF;
        this.UZTPLANIF_TITOTUTORIA = UZTPLANIF_TITOTUTORIA;
        this.UZTPLANIF_TEMA = UZTPLANIF_TEMA;
    }

    public int getCODIGO_UZTPLANIF() {
        return CODIGO_UZTPLANIF;
    }

    public void setCODIGO_UZTPLANIF(int CODIGO_UZTPLANIF) {
        this.CODIGO_UZTPLANIF = CODIGO_UZTPLANIF;
    }

    public String getUZTPLANIF_TITOTUTORIA() {
        return UZTPLANIF_TITOTUTORIA;
    }

    public void setUZTPLANIF_TITOTUTORIA(String UZTPLANIF_TITOTUTORIA) {
        this.UZTPLANIF_TITOTUTORIA = UZTPLANIF_TITOTUTORIA;
    }

    public String getUZTPLANIF_TEMA() {
        return UZTPLANIF_TEMA;
    }

    public void setUZTPLANIF_TEMA(String UZTPLANIF_TEMA) {
        this.UZTPLANIF_TEMA = UZTPLANIF_TEMA;
    }
        
        
    
	
	
}
