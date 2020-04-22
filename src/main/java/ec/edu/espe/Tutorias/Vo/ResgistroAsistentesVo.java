package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

public class ResgistroAsistentesVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String UZTPLANIF_TITOTUTORIA;
	private String UZTPLANIF_TEMA;
	
	public ResgistroAsistentesVo() {
		
	}
	public ResgistroAsistentesVo(String UZTPLANIF_TITOTUTORIA, String UZTPLANIF_TEMA) {
		this.UZTPLANIF_TEMA=UZTPLANIF_TEMA;
		this.UZTPLANIF_TITOTUTORIA=UZTPLANIF_TITOTUTORIA;
		
	}
	public String getUZTPLANIF_TITOTUTORIA() {
		return UZTPLANIF_TITOTUTORIA;
	}
	public void setUZTPLANIF_TITOTUTORIA(String uZTPLANIF_TITOTUTORIA) {
		UZTPLANIF_TITOTUTORIA = uZTPLANIF_TITOTUTORIA;
	}
	public String getUZTPLANIF_TEMA() {
		return UZTPLANIF_TEMA;
	}
	public void setUZTPLANIF_TEMA(String uZTPLANIF_TEMA) {
		UZTPLANIF_TEMA = uZTPLANIF_TEMA;
	}

	
	
}
