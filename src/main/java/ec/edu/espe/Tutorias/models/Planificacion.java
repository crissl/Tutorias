package ec.edu.espe.Tutorias.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

public class Planificacion implements Serializable {
	
	 
	 @Basic(optional = false)
	 @Column(name = "CODIGO_UZTPLANIF")
	 private int codigoPlanificacion;
	 
	@Basic(optional = false)
	 @Column(name = " CODIGO_UZGTFORMULARIOS")
	 private int codigoFormularios;
	 
	 @Basic(optional = false)
	 @Column(name = "UZGTRESPUESTAS_ITERACION")
	 private int interacion;
	 
	 @Column(name = "UZTPLANIF_FECHAFORM")
	 //@NotNull
	 private String fechaFormulario;
	 
	 @Column(name = "UZTPLANIF_TIPOPERSONA")
	 @NotNull
	 private String tipoPersona;
	 
	 @Column(name = "UZTPLANIF_TITOTUTORIA")
	 @NotNull
	 private String tipoTutoria;
	 
	 @Basic(optional = false)
	 @Column(name = "SPRIDEN_PIDM")
	 private int spridenPidm;
	 
	 @Column(name = "UZTPLANIF_TEMA")
	 @NotNull
	 private String tema;

	 @Column(name = "UZTPLANIF_PUBLICO")
	 @NotNull
	 private String publico;
	 
	 @Column(name = "UZTPLANIF_NRC")
	 @NotNull
	 private String nrc;
	 
	 @Column(name = "UZTPLANIF_CODIGO_ASIGNATURA")
	 @NotNull
	 private String codAsignatura;
	 
	 @Column(name = "UZTPLANIF_ASIGNATURA")
	 @NotNull
	 private String asignatura;
	 
	 @Column(name = "UZTPLANIF_PERIODO")
	 @NotNull
	 private String periodo;
	 
	 @Column(name = "UZTPLANIF_NIVEL")
	 @NotNull
	 private String nivel;
	 
	 @Column(name = "UZTPLANIF_AULA")
	 @NotNull
	 private String aula;
	 
	 @Column(name = "UZTPLANIF_FECHATUTORIA")
	 @NotNull
	 private String fechaTutoria;
	 
	 @Column(name = "UZTPLANIF_HORAINICIO")
	 @NotNull
	 private String horaInicio;
	 
	 @Column(name = "UZTPLANIF_HORAFIN")
	 @NotNull
	 private String horaFin;
	 
	 @Column(name = "UZTPLANIF_OBSERVACION")
	 @NotNull
	 private String observacion;
	 
	 @Column(name = "UZTPLANIF_ESTADO")
	 @NotNull
	 private String estado;
	 
	 @Column(name = "UZTPLANIF_FECHA_CREA")
	 @NotNull
	 private Date fechaCrea;
	 
	 @Column(name = "UZTPLANIF_USUA_CREA")
	 @NotNull
	 private String usuaCrea;
	 
	 @Column(name = "UZTPLANIF_FECHA_MODIF")
	 @NotNull
	 private Data fechaModif;
	 
	 @Column(name = "UZTPLANIF_USUA_MODIF")
	 @NotNull
	 private String usuaModif;
	 
	 @Column(name = "UZTPLANIF_CAMP_CODE")
	 @NotNull
	 private String campCode;
	 
	 
	 public int getCodigoPlanificacion() {
			return codigoPlanificacion;
		}

		public void setCodigoPlanificacion(int codigoPlanificacion) {
			this.codigoPlanificacion = codigoPlanificacion;
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

		public Data getFechaModif() {
			return fechaModif;
		}

		public void setFechaModif(Data fechaModif) {
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

}



	 
	   
	  
	 
	