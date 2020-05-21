package ec.edu.espe.Tutorias.controller;

import ec.edu.espe.Tutorias.Vo.AlumnosAcompanamientoVo;
import ec.edu.espe.Tutorias.Vo.ConfirmacionAsistenciaVo;
import ec.edu.espe.Tutorias.Vo.ConvocadosVo;
import ec.edu.espe.Tutorias.Vo.NrcSolicitudVo;
import ec.edu.espe.Tutorias.Vo.NrcVo;
import ec.edu.espe.Tutorias.Vo.SolicitadasAcompanamientoVo;
import ec.edu.espe.Tutorias.Vo.SolicitadasReforzamientoVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;
import ec.edu.espe.Tutorias.Vo.TutoriasPlanificadasVo;
import ec.edu.espe.Tutorias.constants.DominiosConstantes;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.Tutorias.dao.AsistenciaRepository;
import ec.edu.espe.Tutorias.dao.PlanificacionRepository;
import ec.edu.espe.Tutorias.model.Asistencia;
import ec.edu.espe.Tutorias.model.Planificacion;
import ec.edu.espe.Tutorias.util.Mensaje;

//@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@CrossOrigin(origins = { DominiosConstantes.DOMAIN_1, DominiosConstantes.DOMAIN_2})

@RestController
@RequestMapping(DominiosConstantes.context)
//@RequestMapping("/tutoring")
public class Planificaciones {

    @Autowired
    private PlanificacionRepository planificacionRepository;
    private final Mensaje msg = new Mensaje();

    @Autowired
    private SolicitudVo libretaRepository;
    @Autowired
    private SolicitudVo confirmacionAsi;
    @Autowired
    private SolicitudVo convocados;
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Autowired
    private SolicitudVo planificadas;
    @Autowired
    private SolicitudVo solicitadasAcompanamiento;
    @Autowired
    private SolicitudVo solicitadasReforzamiento;

    // funcion para listar un formulario
    @RequestMapping(value = "/listarPlanificacion", method = RequestMethod.GET)
    public ResponseEntity<Planificacion> listarPlanificacion() throws SQLException {
        List<Planificacion> tutorias = planificacionRepository.findallPlanifica();
        if (tutorias.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        } else {
            return new ResponseEntity(tutorias, HttpStatus.OK);
        }
    }
    
    
    //  Funcion Actualizar un asistencia
    @RequestMapping(value = "/actualizarPlanificacion", method = RequestMethod.PUT)
    public ResponseEntity<Planificacion> actualizarAsistencia(@Valid @RequestBody Planificacion confirmacion) throws SQLException {
       planificacionRepository.save(confirmacion);
        return new ResponseEntity(msg.update(), HttpStatus.OK);
    }

    //metodo agregar solicitud de PLanificacion acompañamineto, reforzamiento y de Solicitud de acompanamiento y reforzamiento 
    @RequestMapping(value = "/crearPlanificacion", method = RequestMethod.POST)
    public ResponseEntity<Planificacion> crearPlanificacion(@Valid @RequestBody Planificacion usuario) {
        Planificacion planif = new Planificacion();
        int ultimo = planificacionRepository.findTopByOrderByIdDesc().getId() + 1;//busca el ultimo id y le suma uno para remplazar a la secuencia 
        usuario.setId(ultimo);
        //planif.setId(ultimo);
        planificacionRepository.save(usuario);
        return new ResponseEntity(msg.add(), HttpStatus.CREATED);
    }

    //método busca el ultimo registro de planificacion que se ingreso
    @RequestMapping(value = "/ultimoPlanif", method = RequestMethod.GET)
    public ResponseEntity<Planificacion> verUltimoRegistroPlanificacion() {
        int ultimo = planificacionRepository.findTopByOrderByIdDesc().getId();
        return new ResponseEntity(ultimo, HttpStatus.OK);
    }

    //método busca el ultimo registro de planificacion que se ingreso y suma 1 para generar un autoincrementable debido a que no existe secuencia
    @RequestMapping(value = "/ultimo", method = RequestMethod.GET)
    public ResponseEntity<Planificacion> ultimo() {
        int ultimo = planificacionRepository.findTopByOrderByIdDesc().getId() + 1;
        return new ResponseEntity(ultimo, HttpStatus.OK);

    }

    @RequestMapping(value = "/nrcS/{data}", method = RequestMethod.GET)
    public ResponseEntity getNrc(@PathVariable int data) throws SQLException {
        String wi = " WHERE SIRASGN_PIDM  = " + data + ""
                + " AND SIRASGN_TERM_CODE = SSBSECT_TERM_CODE"
                + " AND SIRASGN_CRN = SSBSECT_CRN"
                + " AND SSBSECT_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE"
                + " AND SSBSECT_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB";
        List<NrcVo> libreta1 = libretaRepository.getNrc(wi);
        return new ResponseEntity(libreta1, HttpStatus.OK);
    }

    //Lista nrc de un solicitud de reforzzamineto estudiante
    @RequestMapping(value = "/nrcSolicitud/{data}", method = RequestMethod.GET)
    public ResponseEntity getNrcSolicitud(@PathVariable int data) throws SQLException {
        String wi = " WHERE sfrstcr_pidm = " + data + " AND sfrstcr_term_code = ssbsect_term_code AND sfrstcr_crn = ssbsect_crn"
//                + " AND ssbsect_ptrm_end_date >= sysdate"
        		+ " AND ssbsect_subj_code = a.scbcrse_subj_code"
        		+ " AND ssbsect_crse_numb = a.scbcrse_crse_numb ";
        List<NrcSolicitudVo> NrcEstudiante = libretaRepository.getNrcSolicitud(wi);
        return new ResponseEntity(NrcEstudiante, HttpStatus.OK);
    }

    @RequestMapping(value = "/confirmarAsistencia/{data}", method = RequestMethod.GET)
    public ResponseEntity getConfirmar(@PathVariable int data) throws SQLException {
        String wi = "  WHERE a.CODIGO_UZTPLANIF=p.CODIGO_UZTPLANIF AND a.SPRIDEN_PIDM = " + data + " ";
        List<ConfirmacionAsistenciaVo> Confirmar = confirmacionAsi.getConfirmar(wi);
        return new ResponseEntity(Confirmar, HttpStatus.OK);
    }

    @RequestMapping(value = "/convocadosMeno14/{nrc}/{periodo}", method = RequestMethod.GET)
    public ResponseEntity getConvocadosMenos(@PathVariable int nrc, @PathVariable String periodo) throws SQLException {
        String wi = "WHERE GOREMAL.GOREMAL_PIDM = SFRSTCR_PIDM\r\n" + 
        		"                                AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'), '') AS CORREO_INSTITUCIONAL,\r\n" + 
        		"                                NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)\r\n" + 
        		"                                FROM GOREMAL\r\n" + 
        		"                                WHERE GOREMAL.GOREMAL_PIDM = SFRSTCR_PIDM\r\n" + 
        		"                                AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'), '') AS CORREO_PERSONAL\r\n" + 
        		"                                FROM SFRSTCR, SPBPERS\r\n" + 
        		"                                WHERE SFRSTCR_TERM_CODE =  '" + periodo + "'\r\n" + 
        		"                                AND SFRSTCR_CRN = " + nrc + "\r\n" + 
        		"                                AND SFRSTCR_PIDM = SPBPERS_PIDM\r\n" + 
        		"                                AND SFRSTCR_PIDM IN (SELECT DISTINCT SHRMRKS_PIDM\r\n" + 
        		"                                FROM SHRMRKS\r\n" + 
        		"                                WHERE SHRMRKS_TERM_CODE =  '" + periodo + "'\r\n" + 
        		"                                AND SHRMRKS_CRN = " + nrc + "\r\n" + 
        		"                                AND SHRMRKS_SCORE <= 14)\r\n" + 
//        		"                                AND SHRMRKS_COMPLETED_DATE = (SELECT MAX(SHRMRKS_COMPLETED_DATE)\r\n" + 
//        		"                                FROM SHRMRKS\r\n" + 
//        		"                                WHERE SHRMRKS_COMPLETED_DATE <= SYSDATE\r\n" + 
//        		"                                AND SHRMRKS_TERM_CODE = '" + periodo + "' \r\n" + 
//        		"                                AND SHRMRKS_CRN = " + nrc + ")" +
        		"";
        List<ConvocadosVo> Convocar = convocados.getConvocadosMenos(wi);
        if (Convocar.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        } else {
            return new ResponseEntity(Convocar, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/convocadosTodos/{nrc}/{periodo}", method = RequestMethod.GET)
    public ResponseEntity getConvocadosTodos(@PathVariable int nrc, @PathVariable String periodo) throws SQLException {
        String wi = "WHERE GOREMAL.GOREMAL_PIDM = SFRSTCR_PIDM\r\n"
                + "                                AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'),'') AS CORREO_INSTITUCIONAL,\r\n"
                + "                                NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)\r\n"
                + "                                FROM GOREMAL\r\n"
                + "                                WHERE GOREMAL.GOREMAL_PIDM = SFRSTCR_PIDM\r\n"
                + "                                AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'),'') AS CORREO_PERSONAL\r\n"
                + "                                FROM SFRSTCR, SPBPERS\r\n"
                + "                                WHERE SFRSTCR_TERM_CODE = '" + periodo + "'\r\n"
                + "                                AND SFRSTCR_CRN = " + nrc + "\r\n"
                + "                                AND SFRSTCR_PIDM = SPBPERS_PIDM";
        List<ConvocadosVo> ConvocarT = convocados.getConvocadosTodos(wi);
        if (ConvocarT.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        } else {
            return new ResponseEntity(ConvocarT, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/convocadosSolicitados/{nrc}/{periodo}", method = RequestMethod.GET)
    public ResponseEntity getConvocadosSolicitados(@PathVariable int nrc, @PathVariable String periodo) throws SQLException {
        String wi = "                                WHERE GOREMAL.GOREMAL_PIDM = SPRIDEN_PIDM\r\n"
                + "                                AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'), '') AS CORREO_INSTITUCIONAL,\r\n"
                + "                                NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)\r\n"
                + "                                FROM GOREMAL\r\n"
                + "                                WHERE GOREMAL.GOREMAL_PIDM = SPRIDEN_PIDM\r\n"
                + "                                AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'), '') AS CORREO_PERSONAL\r\n"
                + "                                FROM UTIC.UZTPLANIF, SPBPERS\r\n"
                + "                                WHERE UZTPLANIF_TIPOPERSONA = 'ESTUDIANTE'\r\n"
                + "                                AND UZTPLANIF_TITOTUTORIA = 'REFORZAMIENTO'\r\n"
                + "                                AND UZTPLANIF_NRC = " + nrc + "\r\n"
                + "                                AND UZTPLANIF_PERIODO = '" + periodo + "'\r\n"
                + "                                AND UZTPLANIF_ESTADO = 'A'\r\n"
                + "                                AND SPRIDEN_PIDM=SPBPERS_PIDM";
        List<ConvocadosVo> ConvocarS = convocados.getConvocadosSolicitados(wi);
        if(ConvocarS.isEmpty()){
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        }else{
            return new ResponseEntity(ConvocarS, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/convocadosTodosAcompanamiento/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getConvocadosTodosAcompanamiento(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM\r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'), '') AS CORREO_INSTITUCIONAL,\r\n"
                + "NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)\r\n"
                + "FROM GOREMAL\r\n"
                + "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM\r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'), '') AS CORREO_PERSONAL\r\n"
                + "FROM SGRADVR, SPBPERS\r\n"
                + "WHERE SGRADVR_ADVR_PIDM = " + pidm + "\r\n"
//                + "AND SGRADVR_ADVR_CODE = 'TACO'\r\n"  
                + "AND SGRADVR_PIDM = SPBPERS_PIDM";
        List<ConvocadosVo> ConvocarST = convocados.getConvocadosTodosAcompanamiento(wi);
        if (ConvocarST.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(ConvocarST, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/convocadosSolicitadosAcompanamiento/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getConvocadosSolicitadosAcompanamiento(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM\r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'), '') AS CORREO_INSTITUCIONAL,\r\n"
                + "NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS)\r\n"
                + "FROM GOREMAL\r\n"
                + "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM\r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'), '') AS CORREO_PERSONAL\r\n"
                + "FROM UTIC.UZTPLANIF, SATURN.SGRADVR, SATURN.SPBPERS\r\n"
                + "WHERE SGRADVR_ADVR_PIDM = " + pidm + "\r\n"
//                + "AND SGRADVR_ADVR_CODE = 'TACO'\r\n"  
                + "AND UZTPLANIF_TIPOPERSONA = 'ESTUDIANTE'\r\n"
                + "AND SPRIDEN_PIDM = SGRADVR_PIDM\r\n"
                + "AND SPRIDEN_PIDM = SPBPERS_PIDM\r\n"
                + "AND UZTPLANIF_TITOTUTORIA = 'ACOMPA�AMIENTO'\r\n"
                + "AND UZTPLANIF_ESTADO = 'A'";
        List<ConvocadosVo> ConvocarSA = convocados.getConvocadosSolicitadosAcompanamiento(wi);
        if (ConvocarSA.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        } else {
            return new ResponseEntity(ConvocarSA, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/AlumnosAcompanamiento/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getAlumnosAcompanamiento(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM \r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'STAN'), '') AS CORREO_INSTITUCIONAL, \r\n"
                + "NVL((SELECT DISTINCT MAX (GOREMAL.GOREMAL_EMAIL_ADDRESS) \r\n"
                + "FROM GOREMAL \r\n"
                + "WHERE GOREMAL.GOREMAL_PIDM = SGRADVR_PIDM \r\n"
                + "AND GOREMAL.GOREMAL_EMAL_CODE = 'PERS'), '') AS CORREO_PERSONAL, \r\n"
                + "NVL((SELECT distinct MAX(F.SPRTELE_PHONE_NUMBER) \r\n"
                + "FROM SPRTELE F \r\n"
                + "WHERE F.SPRTELE_PIDM = SGRADVR_PIDM \r\n"
                + "AND F.SPRTELE_TELE_CODE = 'TM' \r\n"
                + "AND F.SPRTELE_SEQNO = (SELECT MAX(T.SPRTELE_SEQNO) \r\n"
                + "FROM SPRTELE T \r\n"
                + "WHERE T.SPRTELE_PIDM = F.SPRTELE_PIDM \r\n"
                + "AND T.SPRTELE_TELE_CODE = 'TM')), '') AS CELULAR \r\n"
                + "FROM SATURN.SGRADVR T, SATURN.SPBPERS P \r\n"
                + "WHERE T.SGRADVR_ADVR_PIDM = " + pidm + "\r\n"
//                + "AND T.SGRADVR_ADVR_CODE = 'TACO' \r\n"  
                + "AND T.SGRADVR_PIDM = P.SPBPERS_PIDM \r\n"
                + "ORDER BY NOMBRES ";
        List<AlumnosAcompanamientoVo> AlumnosA = convocados.getAlumnosAcompanamiento(wi);
        return new ResponseEntity(AlumnosA, HttpStatus.OK);
    }

    @RequestMapping(value = "/TutoriasPlanificadas/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getTutoriasPlanificadas(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE A.SPRIDEN_PIDM = " + pidm + "";
        List<TutoriasPlanificadasVo> Planificadas = planificadas.getTutoriasPlanificadas(wi);
        return new ResponseEntity(Planificadas, HttpStatus.OK);
    }
    @RequestMapping(value = "/TutoriasPlanificadasR/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getTutoriasPlanificadasR(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE A.SPRIDEN_PIDM = " + pidm + "";
        List<TutoriasPlanificadasVo> PlanificadasR = planificadas.getTutoriasPlanificadasR(wi);
        return new ResponseEntity(PlanificadasR, HttpStatus.OK);
    }

    @RequestMapping(value = "/SolicitadasAcompanamiento/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getSolicitadasAcompanamiento(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE T.SGRADVR_ADVR_PIDM = " + pidm + "";
        List<SolicitadasAcompanamientoVo> SolicitadasA = solicitadasAcompanamiento.getSolicitadasAcompanamiento(wi);
        return new ResponseEntity(SolicitadasA, HttpStatus.OK);
    }

    @RequestMapping(value = "/SolicitadasReforzamiento/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getSolicitadasReforzamiento(@PathVariable int pidm) throws SQLException {
        String wi = "WHERE T.SIRASGN_PIDM = " + pidm + "";
        List<SolicitadasReforzamientoVo> SolicitadasA = solicitadasReforzamiento.getSolicitadasReforzamiento(wi);
        return new ResponseEntity(SolicitadasA, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getPlanificacion/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getPlanificacion(@PathVariable int pidm) throws SQLException {
        
        Planificacion SolicitadasA = planificacionRepository.findById(pidm);
        return new ResponseEntity(SolicitadasA, HttpStatus.OK);
    }
    
    
}
