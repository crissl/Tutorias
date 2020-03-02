package ec.edu.espe.Tutorias.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UZTASISTENTES")
public class Asistencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	 @Basic(optional = false)
	 @Column(name = "UZTASISTENTES_CODIGO")
	 private int id;
	 
	 @Basic(optional = false)
	 @Column(name = " CODIGO_UZTPLANIF")
	 @NotNull
	 private int codigoPlanifiacion;
	 
	 @Basic(optional = false)
	 @Column(name = " CODIGO_UZGTFORMULARIOS")
	 @NotNull
	 private int codigoFormularios;
	 
	 @Basic(optional = false)
	 @Column(name = "UZGTRESPUESTAS_ITERACION")
	 @NotNull
	 private int interacion;
	 
	 @Basic(optional = false)
	 @Column(name = "SPRIDEN_PIDM")
	 @NotNull
	 private int pidm;
	 
	 
	 @Column(name = "UZTASISTENTES_FECHATUTORIA")
	    
	    private Date fechaTutoriaAsi;
	 
	 @Column(name = "UZTASISTENTES_FECHAREGISTRO")
	    
	    private Date fechaRegistroAsi;
	 
	
	    @Column(name = "UZTASISTENTES_ASISTESN")
	    
	    private String asistentes;

	    @Column(name = "UZTASISTENTES_COMENTARIO")
	    
	    private String comentario;

	    @Column(name = "UZTASISTENTES_OBSERVACION")
	    
	    private String observacionAsi;
	    
	    @Column(name = "UZTPLANIF_HORAINICIO")
	    
	    private String horaInicio;

	    @Column(name = "UZTPLANIF_HORAFIN")
	    
	    private String horaFin;

	    @Column(name = "UZTPLANIF_OBSERVACION")
	  
	    private String observacion;

	    @Column(name = "UZTASISTENTES_ESTADO")
	    
	    private String estado;

	    @Column(name = "UZTASISTENTES_ID")
	    
	    private String idAsistentes;

	    @Column(name = "UZTASISTENTES_ESTUDIANTE")
	  
	    private String estudiante;

	    @Column(name = "UZTASISTENTES_EMAIL")
	    
	    private Date  email;
  
	    @Column(name = "UZTASISTENTES_CEDULA")
		  
	    private String ci;
	    
	    @Column(name = "UZTASISTENTES_CONFIRMACION")
		  
	    private String confirmacion;
	    
	    
	    
	    
	    
		 public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getCodigoPlanifiacion() {
				return codigoPlanifiacion;
			}

			public void setCodigoPlanifiacion(int codigoPlanifiacion) {
				this.codigoPlanifiacion = codigoPlanifiacion;
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

			public int getPidm() {
				return pidm;
			}

			public void setPidm(int pidm) {
				this.pidm = pidm;
			}

			public Date getFechaTutoriaAsi() {
				return fechaTutoriaAsi;
			}

			public void setFechaTutoriaAsi(Date fechaTutoriaAsi) {
				this.fechaTutoriaAsi = fechaTutoriaAsi;
			}

			public Date getFechaRegistroAsi() {
				return fechaRegistroAsi;
			}

			public void setFechaRegistroAsi(Date fechaRegistroAsi) {
				this.fechaRegistroAsi = fechaRegistroAsi;
			}

			public String getAsistentes() {
				return asistentes;
			}

			public void setAsistentes(String asistentes) {
				this.asistentes = asistentes;
			}

			public String getComentario() {
				return comentario;
			}

			public void setComentario(String comentario) {
				this.comentario = comentario;
			}

			public String getObservacionAsi() {
				return observacionAsi;
			}

			public void setObservacionAsi(String observacionAsi) {
				this.observacionAsi = observacionAsi;
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

			public String getIdAsistentes() {
				return idAsistentes;
			}

			public void setIdAsistentes(String idAsistentes) {
				this.idAsistentes = idAsistentes;
			}

			public String getEstudiante() {
				return estudiante;
			}

			public void setEstudiante(String estudiante) {
				this.estudiante = estudiante;
			}

			public Date getEmail() {
				return email;
			}

			public void setEmail(Date email) {
				this.email = email;
			}

			public String getCi() {
				return ci;
			}

			public void setCi(String ci) {
				this.ci = ci;
			}

			public String getConfirmacion() {
				return confirmacion;
			}

			public void setConfirmacion(String confirmacion) {
				this.confirmacion = confirmacion;
			}

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

	    
	    

}
