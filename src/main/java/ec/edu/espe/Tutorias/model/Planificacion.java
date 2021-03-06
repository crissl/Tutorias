package ec.edu.espe.Tutorias.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UZTPLANIF")
public class Planificacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_UZTPLANIF")
    private int id;

    @Basic(optional = false)
    @Column(name = " CODIGO_UZGTFORMULARIOS")
    @NotNull
    private int codigoFormularios;

    @Basic(optional = false)
    @Column(name = "UZGTRESPUESTAS_ITERACION")
    @NotNull
    private int interacion;

    @Column(name = "UZTPLANIF_FECHAFORM")
    
    private String fechaFormulario;

    @Column(name = "UZTPLANIF_TIPOPERSONA")
    
    private String tipoPersona;

    @Column(name = "UZTPLANIF_TITOTUTORIA")
    
    private String tipoTutoria;

    @Basic(optional = false)
    @Column(name = "SPRIDEN_PIDM")
    @NotNull
    private int spridenPidm;

    @Column(name = "UZTPLANIF_TEMA")
    
    private String tema;

    @Column(name = "UZTPLANIF_PUBLICO")
    
    private String publico;

    @Column(name = "UZTPLANIF_NRC")
    
    private String nrc;

    @Column(name = "UZTPLANIF_CODIGO_ASIGNATURA")
   
    private String codAsignatura;

    @Column(name = "UZTPLANIF_ASIGNATURA")
  
    private String asignatura;

    @Column(name = "UZTPLANIF_PERIODO")
   
    private String periodo;

    @Column(name = "UZTPLANIF_NIVEL")
    
    private String nivel;

    @Column(name = "UZTPLANIF_AULA")
    
    private String aula;

    @Column(name = "UZTPLANIF_FECHATUTORIA")
    
    private String fechaTutoria;

    @Column(name = "UZTPLANIF_HORAINICIO")
    
    private String horaInicio;

    @Column(name = "UZTPLANIF_HORAFIN")
    
    private String horaFin;

    @Column(name = "UZTPLANIF_OBSERVACION")
  
    private String observacion;

    @Column(name = "UZTPLANIF_ESTADO")
    
    private String estado;

    @Column(name = "UZTPLANIF_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;

    @Column(name = "UZTPLANIF_USUA_CREA")
    
    private String usuaCrea;

    @Column(name = "UZTPLANIF_FECHA_MODIF")
    
    private Date fechaModif;

    @Column(name = "UZTPLANIF_USUA_MODIF")
    
    private String usuaModif;

    @Column(name = "UZTPLANIF_CAMP_CODE")
    
    private String campCode;
    
    @Column(name = "UZTPLANIF_TUTO_HORARIO")
    private String horarioOpcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getCodigoFormularios() {
        return codigoFormularios;
    }

    public void setCodigoFormularios(int codigoFormularios) {
        this.codigoFormularios = codigoFormularios;
    }

    public int getInteracion() {
        return interacion;
    }

    public void setInteracion(int interacion) {
        this.interacion = interacion;
    }

    public String getFechaFormulario() {
        return fechaFormulario;
    }

    public void setFechaFormulario(String fechaFormulario) {
        this.fechaFormulario = fechaFormulario;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTipoTutoria() {
        return tipoTutoria;
    }

    public void setTipoTutoria(String tipoTutoria) {
        this.tipoTutoria = tipoTutoria;
    }

    public int getSpridenPidm() {
        return spridenPidm;
    }

    public void setSpridenPidm(int spridenPidm) {
        this.spridenPidm = spridenPidm;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getFechaTutoria() {
        return fechaTutoria;
    }

    public void setFechaTutoria(String fechaTutoria) {
        this.fechaTutoria = fechaTutoria;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getUsuaCrea() {
        return usuaCrea;
    }

    public void setUsuaCrea(String usuaCrea) {
        this.usuaCrea = usuaCrea;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public String getUsuaModif() {
        return usuaModif;
    }

    public void setUsuaModif(String usuaModif) {
        this.usuaModif = usuaModif;
    }

    public String getCampCode() {
        return campCode;
    }

    public void setCampCode(String campCode) {
        this.campCode = campCode;
    }

	public String getHorarioOpcion() {
		return horarioOpcion;
	}

	public void setHorarioOpcion(String horarioOpcion) {
		this.horarioOpcion = horarioOpcion;
	}
    

}
