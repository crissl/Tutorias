/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Tutorias.Vo;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ec.edu.espe.Tutorias.model.Planificacion;

/**
 *
 * @author wils1
 */
@Service
public class SolicitudVo {

    private static String opciones = "   FROM SIRASGN, SSBSECT, SCBCRSE A ";

    private static String fromNrcSolicitud = " FROM sfrstcr,ssbsect, scbcrse a ";

    private static String confirma = " FROM UTIC.UZTASISTENTES a, UTIC.UZTPLANIF p ";
    
    private static String campus = " FROM SLBBLDG, SLBRDEF, STVCAMP ";
    
    private static String horario = " FROM SATURN.SZARPGN, SLBRDEF ";

    private static String reforzamiento = " FROM SIRASGN, SSBSECT, SCBCRSE A, SSRMEET ";
    
    private static String Asistencias = " FROM UTIC.UZTASISTENTES ";

    private static String convocados = " FROM GOREMAL ";
 
    private static String tutoriasPlanifiacadas = " FROM UTIC.UZTASISTENTES A, UTIC.UZTPLANIF P ";  

    private static String solicitadasAcompanamiento = " FROM UTIC.UZTPLANIF P, SATURN.SGRADVR T "; 
    
    private static String solicitadasReforzamiento = " FROM UTIC.UZTPLANIF P, SATURN.SIRASGN T ";
    
    private static String estudiantesAsistentes = " FROM UTIC.UZTPLANIF ";
    
    private static String estudiante = " FROM SGBSTDN ";
    
    private static String docente = " FROM SIRASGN ";
    
    private static String tipo = " FROM PEBEMPL ";



    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<NrcVo> getNrc(String q) throws SQLException {
        String opcion = "SELECT DISTINCT SIRASGN_CRN , A.SCBCRSE_SUBJ_CODE,  A.SCBCRSE_CRSE_NUMB , A.SCBCRSE_TITLE , SSBSECT_CAMP_CODE , SSBSECT_TERM_CODE ";
        String where = " AND A.SCBCRSE_EFF_TERM = (SELECT MAX( SCBCRSE_EFF_TERM)  FROM  SCBCRSE  WHERE SCBCRSE_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE  AND SCBCRSE_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB);";
        return jdbcTemplate.query(opcion + opciones + q, new BeanPropertyRowMapper<>(NrcVo.class));
    }

    public List<NrcSolicitudVo> getNrcSolicitud(String q) throws SQLException {
        String selectNrcSolicitud = "SELECT DISTINCT sfrstcr_crn as nrc ,a.scbcrse_subj_code||a.scbcrse_crse_numb as codigo,a.scbcrse_title as asignatura ,sfrstcr_camp_code as campus  ,sfrstcr_term_code as periodo ,sfrstcr_levl_code as nivel";
        String whereNrcSolicitud = " AND a.scbcrse_eff_term = (SELECT MAX(scbcrse_eff_term) FROM scbcrse WHERE scbcrse_subj_code = a.scbcrse_subj_code AND scbcrse_crse_numb = a.scbcrse_crse_numb)";
        return jdbcTemplate.query(selectNrcSolicitud + fromNrcSolicitud+q+whereNrcSolicitud, new BeanPropertyRowMapper<>(NrcSolicitudVo.class));
    }
    public List<ConfirmacionAsistenciaVo> getConfirmar(String q) throws SQLException {
    	
    	String selecConfirmacion = "SELECT UZTASISTENTES_CODIGO, p.CODIGO_UZTPLANIF, UZTPLANIF_TITOTUTORIA, UZTPLANIF_TEMA";
    	String whereConfirmacion = "AND (a.CODIGO_UZGTFORMULARIOS=3 OR a.CODIGO_UZGTFORMULARIOS=1) AND UZTASISTENTES_ESTADO='A' ORDER BY p.CODIGO_UZTPLANIF ASC";
    	return jdbcTemplate.query(selecConfirmacion + confirma + q + whereConfirmacion, new BeanPropertyRowMapper<>(ConfirmacionAsistenciaVo.class));
    
    }
    public List<CampusVo> getCampus(String q) throws SQLException {
    	String selecCampus = "SELECT DISTINCT STVCAMP_CODE AS CODIGO,STVCAMP_DESC AS CAMPUS";
    	String whereCampus = "AND SLBBLDG_CAMP_CODE = STVCAMP_CODE AND SLBRDEF_RMST_CODE = 'AC' AND SLBRDEF_ROOM_TYPE = 'C' ORDER BY 1";
    	return jdbcTemplate.query(selecCampus + campus + q + whereCampus, new BeanPropertyRowMapper<>(CampusVo.class));
    
    	
    }
    public List<HorarioVo> getHorario(String q) throws SQLException {
    	String selecHorario = "SELECT DISTINCT SZARPGN_CAMPVAR3 AS NIVEL, SZARPGN_CAMPVAR4 AS AULA, SZARPGN_CAMPVAR7||' - '||SZARPGN_CAMPVAR8 AS HORARIO, SZARPGN_CAMPVAR7 AS HORA_INICIO, SZARPGN_CAMPVAR8 AS HORA_FIN";
    	String whereHorario = "";
    	return jdbcTemplate.query(selecHorario + horario + q + whereHorario, new BeanPropertyRowMapper<>(HorarioVo.class));
    	
    	
    }
    public List<PlanificacionReforzamientoVo> getPlanificaionR(String q) throws SQLException {
        	String selecPlanificacion = "SELECT DISTINCT SIRASGN_CRN AS NRC, A.SCBCRSE_SUBJ_CODE || A.SCBCRSE_CRSE_NUMB AS CODIGO_ASIGNATURA, A.SCBCRSE_TITLE AS ASIGNATURA, SSBSECT_CAMP_CODE AS CAMPUS, SSBSECT_TERM_CODE AS PERIODO, SSRMEET_BEGIN_TIME AS INICIO, SSRMEET_END_TIME AS FIN\r\n" + 
        			"";
        	String wherePlanificacion = "";
        	return jdbcTemplate.query(selecPlanificacion + reforzamiento + q + wherePlanificacion, new BeanPropertyRowMapper<>(PlanificacionReforzamientoVo.class));
    
    	
    }
    public List<HorarioPlaVo> getHorarioPlanificacion(String q) throws SQLException {
    	String selecHorarioPlanificacion = "SELECT DISTINCT SZARPGN_CAMPVAR3 AS NIVEL, SZARPGN_CAMPVAR4 AS AULA, SZARPGN_CAMPVAR7 ||' - '||SZARPGN_CAMPVAR8 AS HORARIO, SZARPGN_CAMPVAR7 AS HORA_INICIO, SZARPGN_CAMPVAR8 AS HORA_FIN";
    	String whereHorarioPlanificacion = "ORDER BY 3,4,1";
    	return jdbcTemplate.query(selecHorarioPlanificacion + horario + q + whereHorarioPlanificacion, new BeanPropertyRowMapper<>(HorarioPlaVo.class));
    	
    	
    }

    
    public List<AsistentesVo> getRegistroAsistencia(String q) throws SQLException {
    	String selecRegistroAsistencia = "SELECT UZTASISTENTES_CEDULA , UZTASISTENTES_ID, UZTASISTENTES_ESTUDIANTE, UZTASISTENTES_EMAIL, UZTASISTENTES_ESTADO";
    	String whereRegistroAsistencia = "AND (CODIGO_UZGTFORMULARIOS =1 OR CODIGO_UZGTFORMULARIOS =3)";
    	return jdbcTemplate.query(selecRegistroAsistencia + Asistencias + q + whereRegistroAsistencia, new BeanPropertyRowMapper<>(AsistentesVo.class));
    }
    
//    public List<AsistentesVo> getRegistroAsistencia(String q) throws SQLException {
//    	String selecRegistroAsistencia = "SELECT UZTASISTENTES_CEDULA , UZTASISTENTES_ID, UZTASISTENTES_ESTUDIANTE, UZTASISTENTES_EMAIL, UZTASISTENTES_ESTADO";
//    	String whereRegistroAsistencia = "AND CODIGO_UZGTFORMULARIOS =3";
//    	return jdbcTemplate.query(selecRegistroAsistencia + Asistencias + q + whereRegistroAsistencia, new BeanPropertyRowMapper<>(AsistentesVo.class));
//    }
    
    
    
    public List<ConvocadosVo> getConvocadosMenos(String q) throws SQLException {
    	String selecConvocadosMenos = "SELECT DISTINCT SFRSTCR_PIDM AS PIDM, SUBSTR(f_getspridenid(SFRSTCR_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SFRSTCR_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosMenos = "";
    	return jdbcTemplate.query(selecConvocadosMenos + convocados + q + whereConvocadosMenos, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
    }
    public List<ConvocadosVo> getConvocadosTodos(String q) throws SQLException {
    	String selecConvocadosTodos = "SELECT DISTINCT SFRSTCR_PIDM AS PIDM, SUBSTR(f_getspridenid(SFRSTCR_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SFRSTCR_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosTodos = "";
    	return jdbcTemplate.query(selecConvocadosTodos + convocados + q + whereConvocadosTodos, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
  	
    }
    public List<ConvocadosVo> getConvocadosSolicitados(String q) throws SQLException {
    	String selecConvocadosSolicitados = "SELECT DISTINCT SPRIDEN_PIDM AS PIDM, SUBSTR(f_getspridenid(SPRIDEN_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SPRIDEN_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosSolicitados = "";
    	return jdbcTemplate.query(selecConvocadosSolicitados + convocados + q + whereConvocadosSolicitados, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
  	
    }
    
    public List<ConvocadosVo> getConvocadosTodosAcompanamiento(String q) throws SQLException {
    	String selecConvocadosTodosAcompanamiento= "SELECT DISTINCT SPBPERS_PIDM AS PIDM, SUBSTR(f_getspridenid(SGRADVR_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SGRADVR_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosTodosAcompanamiento = "";
    	return jdbcTemplate.query(selecConvocadosTodosAcompanamiento + convocados + q + whereConvocadosTodosAcompanamiento, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
  	
    }
    
    public List<ConvocadosVo> getConvocadosSolicitadosAcompanamiento(String q) throws SQLException {
    	String selecConvocadosSolicitadosAcompanamiento= "SELECT DISTINCT SPRIDEN_PIDM AS PIDM, SUBSTR(f_getspridenid(SPRIDEN_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SPRIDEN_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosSolicitadosAcompanamiento = "";
    	return jdbcTemplate.query(selecConvocadosSolicitadosAcompanamiento + convocados + q + whereConvocadosSolicitadosAcompanamiento, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
  	
    }
    
    public List<AlumnosAcompanamientoVo> getAlumnosAcompanamiento(String q) throws SQLException {
    	String selecAlumnosAcompanamiento= "SELECT DISTINCT SPBPERS_SSN AS CEDULA, SUBSTR(f_getspridenid(T.SGRADVR_PIDM),1,12) AS ID, SUBSTR(f_format_name(T.SGRADVR_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereAlumnosAcompanamiento = "";
    	return jdbcTemplate.query(selecAlumnosAcompanamiento + convocados + q + whereAlumnosAcompanamiento, new BeanPropertyRowMapper<>(AlumnosAcompanamientoVo.class));
    	
  	
    }
    
    
    public List<TutoriasPlanificadasVo> getTutoriasPlanificadas(String q) throws SQLException {
    	String selecTutoriasPlanificadas= "SELECT DISTINCT P.UZTPLANIF_TITOTUTORIA AS TUTORIA, P.UZTPLANIF_TEMA AS TEMA, NVL(P.UZTPLANIF_ASIGNATURA,' ') AS ASIGNATURA, P.UZTPLANIF_FECHATUTORIA AS FECHA, P.UZTPLANIF_AULA AS AULA, P.UZTPLANIF_HORAINICIO AS HORA, P.UZTPLANIF_FECHA_CREA AS FEC";
    	String whereTutoriasPlanificadas = "AND A.CODIGO_UZTPLANIF = P.CODIGO_UZTPLANIF AND A.CODIGO_UZGTFORMULARIOS = P.CODIGO_UZGTFORMULARIOS AND P.UZTPLANIF_TITOTUTORIA='ACOMPAÑAMIENTO' ORDER BY FEC, HORA, ASIGNATURA";
    	return jdbcTemplate.query(selecTutoriasPlanificadas + tutoriasPlanifiacadas + q + whereTutoriasPlanificadas, new BeanPropertyRowMapper<>(TutoriasPlanificadasVo.class));
    	
  	
    }
    public List<TutoriasPlanificadasVo> getTutoriasPlanificadasR(String q) throws SQLException {
    	String selecTutoriasPlanificadas= "SELECT DISTINCT P.UZTPLANIF_TITOTUTORIA AS TUTORIA, P.UZTPLANIF_TEMA AS TEMA, NVL(P.UZTPLANIF_ASIGNATURA,' ') AS ASIGNATURA, P.UZTPLANIF_FECHATUTORIA AS FECHA, P.UZTPLANIF_AULA AS AULA, P.UZTPLANIF_HORAINICIO AS HORA, P.UZTPLANIF_FECHA_CREA AS FEC";
    	String whereTutoriasPlanificadas = "AND A.CODIGO_UZTPLANIF = P.CODIGO_UZTPLANIF AND A.CODIGO_UZGTFORMULARIOS = P.CODIGO_UZGTFORMULARIOS AND P.UZTPLANIF_TITOTUTORIA='REFORZAMIENTO' ORDER BY FEC, HORA, ASIGNATURA";
    	return jdbcTemplate.query(selecTutoriasPlanificadas + tutoriasPlanifiacadas + q + whereTutoriasPlanificadas, new BeanPropertyRowMapper<>(TutoriasPlanificadasVo.class));
    	
  	
    }
    
    public List<SolicitadasAcompanamientoVo> getSolicitadasAcompanamiento(String q) throws SQLException {
    	String selecSolicitadasAcompanamiento= "SELECT DISTINCT P.UZTPLANIF_TITOTUTORIA AS TUTORIA, SUBSTR(f_getspridenid(P.SPRIDEN_PIDM),1,12) AS ID, SUBSTR(f_format_name(P.SPRIDEN_PIDM,'LFMI'),1,30) AS NOMBRES, P.UZTPLANIF_TEMA AS TEMA, P.UZTPLANIF_OBSERVACION AS OBSERVACION, P.UZTPLANIF_FECHAFORM AS FECHA";
    	String whereSolicitadasAcompanamiento = "AND T.SGRADVR_PIDM = P.SPRIDEN_PIDM "
                                                 + "AND P.UZTPLANIF_TITOTUTORIA = 'ACOMPAÑAMIENTO'"
//    			                                 + "AND T.SGRADVR_ADVR_CODE = 'TACO' "
    			                                 + "ORDER BY FECHA, NOMBRES";
    	return jdbcTemplate.query(selecSolicitadasAcompanamiento + solicitadasAcompanamiento + q + whereSolicitadasAcompanamiento, new BeanPropertyRowMapper<>(SolicitadasAcompanamientoVo.class));
    	
    }
    
    public List<SolicitadasReforzamientoVo> getSolicitadasReforzamiento(String q) throws SQLException {
    	String selecSolicitadasReforzamiento= "SELECT DISTINCT P.UZTPLANIF_TITOTUTORIA AS TUTORIA, SUBSTR(f_getspridenid(P.SPRIDEN_PIDM),1,12) AS ID, SUBSTR(f_format_name(P.SPRIDEN_PIDM,'LFMI'),1,30) AS NOMBRES, P.UZTPLANIF_ASIGNATURA AS ASIGNATURA, P.UZTPLANIF_TEMA AS TEMA, P.UZTPLANIF_FECHAFORM AS FECHA";
    	String whereSolicitadasReforzamiento = "AND T.SIRASGN_TERM_CODE = TRIM(P.UZTPLANIF_PERIODO) "
    			                              + "AND T.SIRASGN_CRN = TRIM(P.UZTPLANIF_NRC) "
    			                              + "AND P.UZTPLANIF_TIPOPERSONA = 'ESTUDIANTE'"
    			                              + " ORDER BY FECHA, NOMBRES";
    	return jdbcTemplate.query(selecSolicitadasReforzamiento + solicitadasReforzamiento + q + whereSolicitadasReforzamiento, new BeanPropertyRowMapper<>(SolicitadasReforzamientoVo.class));
    	
    }
    
    
    public List<PlanificacionSeleccionadaVo> planificacionSeleccion(String q) throws SQLException {
    	String selecPlanificacionEscogida = "SELECT DISTINCT SIRASGN_CRN AS NRC, A.SCBCRSE_SUBJ_CODE || A.SCBCRSE_CRSE_NUMB || ' - ' || A.SCBCRSE_TITLE AS ASIGNATURA, SSBSECT_CAMP_CODE AS CAMPUS, SSBSECT_TERM_CODE AS PERIODO";
    	String wherePlanificacionEscogida = "";
    	return jdbcTemplate.query(selecPlanificacionEscogida + reforzamiento + q + wherePlanificacionEscogida, new BeanPropertyRowMapper<>(PlanificacionSeleccionadaVo.class));

	
}
    public List<HorarioSeleccionadoVo> AulaEscogido(String q) throws SQLException {
    	String selecHorarioPlanificacion = "SELECT DISTINCT SZARPGN_CAMPVAR3||' - '||SZARPGN_CAMPVAR4 AS AULA";
    	String whereHorarioPlanificacion = "ORDER BY AULA";
    	return jdbcTemplate.query(selecHorarioPlanificacion + horario + q + whereHorarioPlanificacion, new BeanPropertyRowMapper<>(HorarioSeleccionadoVo.class));
    	
    	
    }
    
    public List<ResgistroAsistentesVo> getRegistroAsistentes(String q) throws SQLException {
    	String selecHorarioPlanificacion = "SELECT CODIGO_UZTPLANIF, UZTPLANIF_TITOTUTORIA, UZTPLANIF_TEMA";
    	String whereHorarioPlanificacion = "AND (UZTPLANIF_TITOTUTORIA='ACOMPAÑAMIENTO' OR UZTPLANIF_TITOTUTORIA='REFORZAMIENTO') AND (CODIGO_UZGTFORMULARIOS=3 OR CODIGO_UZGTFORMULARIOS=1) AND UZTPLANIF_ESTADO='A' ORDER BY CODIGO_UZTPLANIF ASC";
    	return jdbcTemplate.query(selecHorarioPlanificacion + estudiantesAsistentes + q + whereHorarioPlanificacion, new BeanPropertyRowMapper<>(ResgistroAsistentesVo.class));
    }
    public List<EstudianteVo> getEstudiante(String q) throws SQLException {
    	String selecEstudiante = "SELECT SGBSTDN_PIDM";
    	String whereEstudiante = "";
    	return jdbcTemplate.query(selecEstudiante + estudiante + q + whereEstudiante, new BeanPropertyRowMapper<>(EstudianteVo.class));
    }
    public List<DocenteVo> getDocente(String q) throws SQLException {
    	String selecDocente = "SELECT SIRASGN_PIDM";
    	String whereDocente = "";
    	return jdbcTemplate.query(selecDocente + docente + q + whereDocente, new BeanPropertyRowMapper<>(DocenteVo.class));
    }
    
    public List<TipoPersonaVo> getTipoPersona(String q) throws SQLException {
    	String selecTipo = "SELECT PEBEMPL_BCAT_CODE AS CODIGO";
    	String whereTipo = "";
    	return jdbcTemplate.query(selecTipo + tipo + q + whereTipo, new BeanPropertyRowMapper<>(TipoPersonaVo.class));
    }
}

