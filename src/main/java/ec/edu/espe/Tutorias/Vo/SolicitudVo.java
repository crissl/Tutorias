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
    	
    	String selecConfirmacion = "SELECT UZTASISTENTES_CODIGO, p.CODIGO_UZTPLANIF, UZTPLANIF_TEMA";
    	String whereConfirmacion = "AND (a.CODIGO_UZGTFORMULARIOS=3 OR a.CODIGO_UZGTFORMULARIOS=1) AND UZTASISTENTES_ESTADO='A' ORDER BY p.CODIGO_UZTPLANIF ASC";
    	return jdbcTemplate.query(selecConfirmacion + confirma + q + whereConfirmacion, new BeanPropertyRowMapper<>(ConfirmacionAsistenciaVo.class));
    
    }
    public List<CampusVo> getCampus(String q) throws SQLException {
    	String selecCampus = "SELECT DISTINCT STVCAMP_CODE AS CODIGO,STVCAMP_DESC AS CAMPUS";
    	String whereCampus = "AND SLBBLDG_CAMP_CODE = STVCAMP_CODE AND SLBRDEF_RMST_CODE = 'AC' AND SLBRDEF_ROOM_TYPE = 'C' ORDER BY 1";
    	return jdbcTemplate.query(selecCampus + campus + q + whereCampus, new BeanPropertyRowMapper<>(CampusVo.class));
    
    	
    }
    public List<HorarioVo> getHorario(String q) throws SQLException {
    	String selecHorario = "SELECT DISTINCT SZARPGN_CAMPVAR3||' - '||SZARPGN_CAMPVAR4 AS AULA, SZARPGN_CAMPVAR7||' - '||SZARPGN_CAMPVAR8 AS HORARIO, SZARPGN_CAMPVAR7 AS HORA_INICIO, SZARPGN_CAMPVAR8 AS HORA_FIN";
    	String whereHorario = "";
    	return jdbcTemplate.query(selecHorario + horario + q + whereHorario, new BeanPropertyRowMapper<>(HorarioVo.class));
    	
    	
    }
    public List<PlanificacionReforzamientoVo> getPlanificaionR(String q) throws SQLException {
        	String selecPlanificacion = "SELECT DISTINCT SIRASGN_CRN AS NRC, A.SCBCRSE_SUBJ_CODE || A.SCBCRSE_CRSE_NUMB || ' - ' || A.SCBCRSE_TITLE AS ASIGNATURA, SSBSECT_CAMP_CODE AS CAMPUS, SSBSECT_TERM_CODE AS PERIODO, SSRMEET_BEGIN_TIME AS INICIO, SSRMEET_END_TIME AS FIN";
        	String wherePlanificacion = "";
        	return jdbcTemplate.query(selecPlanificacion + reforzamiento + q + wherePlanificacion, new BeanPropertyRowMapper<>(PlanificacionReforzamientoVo.class));
    
    	
    }
    public List<HorarioPlaVo> getHorarioPlanificacion(String q) throws SQLException {
    	String selecHorarioPlanificacion = "SELECT DISTINCT SZARPGN_CAMPVAR3||' - '||SZARPGN_CAMPVAR4 AS AULA, SZARPGN_CAMPVAR7||' - '||SZARPGN_CAMPVAR8 AS HORARIO, SZARPGN_CAMPVAR7 AS HORA_INICIO, SZARPGN_CAMPVAR8 AS HORA_FIN";
    	String whereHorarioPlanificacion = "ORDER BY 3,4,1";
    	return jdbcTemplate.query(selecHorarioPlanificacion + horario + q + whereHorarioPlanificacion, new BeanPropertyRowMapper<>(HorarioPlaVo.class));
    	
    	
    }

    
    public List<AsistentesVo> getRegistroAsistencia(String q) throws SQLException {
    	String selecRegistroAsistencia = "SELECT UZTASISTENTES_CEDULA , UZTASISTENTES_ID, UZTASISTENTES_ESTUDIANTE, UZTASISTENTES_EMAIL, UZTASISTENTES_ESTADO";
    	String whereRegistroAsistencia = "AND CODIGO_UZGTFORMULARIOS =3";
    	return jdbcTemplate.query(selecRegistroAsistencia + Asistencias + q + whereRegistroAsistencia, new BeanPropertyRowMapper<>(AsistentesVo.class));
    	
   	
    }
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
    	String selecConvocadosTodos = "SELECT DISTINCT SPRIDEN_PIDM AS PIDM, SUBSTR(f_getspridenid(SPRIDEN_PIDM),1,12) AS ID, SPBPERS_SSN AS CEDULA, SUBSTR(f_format_name(SPRIDEN_PIDM,'LFMI'),1,30) AS NOMBRES, NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)";
    	String whereConvocadosTodos = "";
    	return jdbcTemplate.query(selecConvocadosTodos + convocados + q + whereConvocadosTodos, new BeanPropertyRowMapper<>(ConvocadosVo.class));
    	
  	
    }
}
