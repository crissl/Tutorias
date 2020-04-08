package ec.edu.espe.Tutorias.controller;

import ec.edu.espe.Tutorias.Vo.ConfirmacionAsistenciaVo;
import ec.edu.espe.Tutorias.Vo.NrcSolicitudVo;
import ec.edu.espe.Tutorias.Vo.NrcVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;
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

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tutoring")
public class Planificaciones {

    @Autowired
    private PlanificacionRepository planificacionRepository;
    private final Mensaje msg = new Mensaje();

    @Autowired
    private SolicitudVo libretaRepository;
    @Autowired
    private SolicitudVo confirmacionAsi;
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    
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


    //metodo agregar solicitud de 
    @RequestMapping(value = "/crearPlanificacion", method = RequestMethod.POST)
    public ResponseEntity<Planificacion> crearPlanificacion(@Valid @RequestBody Planificacion usuario) {
        Planificacion planif = new Planificacion();
        int ultimo = planificacionRepository.findTopByOrderByIdDesc().getId() + 1;
        usuario.setId(ultimo);
        //planif.setId(ultimo);
        planificacionRepository.save(usuario);
        return new ResponseEntity(msg.add(), HttpStatus.CREATED);
    }
  

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
        String wi = " WHERE sfrstcr_pidm = " + data + " AND sfrstcr_term_code = ssbsect_term_code AND sfrstcr_crn = ssbsect_crn  AND ssbsect_subj_code = a.scbcrse_subj_code AND ssbsect_crse_numb = a.scbcrse_crse_numb ";
        List<NrcSolicitudVo> NrcEstudiante = libretaRepository.getNrcSolicitud(wi);
        return new ResponseEntity(NrcEstudiante, HttpStatus.OK);
    }

    @RequestMapping(value = "/confirmarAsistencia/{data}", method = RequestMethod.GET)
    public ResponseEntity getConfirmar(@PathVariable int data) throws SQLException {
        String wi = "  WHERE a.CODIGO_UZTPLANIF=p.CODIGO_UZTPLANIF AND a.SPRIDEN_PIDM = " + data + " ";
        List<ConfirmacionAsistenciaVo> Confirmar = confirmacionAsi.getConfirmar(wi);
        return new ResponseEntity(Confirmar, HttpStatus.OK);
    }
}