package ec.edu.espe.Tutorias.controller;

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

import ec.edu.espe.Tutorias.Vo.CampusVo;
import ec.edu.espe.Tutorias.Vo.ConfirmacionAsistenciaVo;
import ec.edu.espe.Tutorias.Vo.HorarioPlaVo;
import ec.edu.espe.Tutorias.Vo.HorarioVo;
import ec.edu.espe.Tutorias.Vo.PlanificacionReforzamientoVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;
import ec.edu.espe.Tutorias.dao.asistenciaRepository;
import ec.edu.espe.Tutorias.model.Asistencia;
import ec.edu.espe.Tutorias.util.Mensaje;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tut")
public class asistentesRest  {
	
	@Autowired
    private asistenciaRepository asistenciaRep;
	@Autowired
	private SolicitudVo campusRep;
	@Autowired
	private SolicitudVo horarioAsi;
	@Autowired
	private SolicitudVo nrcPlanificacion;
	@Autowired
	private SolicitudVo horarioPla;


    private final Mensaje msg = new Mensaje();

 // funcion para listar un asistencia
    @RequestMapping(value = "/seguA", method = RequestMethod.GET)
    public ResponseEntity<Asistencia> listarAsistencia() throws SQLException {
        List<Asistencia> asistencias = asistenciaRep.findallAsiste();
       if (asistencias.isEmpty()) {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        } else {
            return new ResponseEntity(asistencias, HttpStatus.OK);
        }
   }
    //metodo agregar confirmados
    //@RequestMapping(value = "/seguA", method = RequestMethod.POST)
    //public ResponseEntity<Asistencia> crearAsistencia(@Valid @RequestBody Asistencia asistio) {
    //	Asistencia asiste = new Asistencia();
    //    int ultimo = asistenciaRep.findTopByOrderByIdDesc().getId() + 1;
    //    asistio.setId(ultimo);
        //planif.setId(ultimo);
     //   asistenciaRep.save(asistio);
    //    return new ResponseEntity(msg.add(), HttpStatus.CREATED);
  //  }

//  Funcion Actualizar un asistencia
    
@RequestMapping(value = "/segu2", method = RequestMethod.PUT)
public ResponseEntity<Asistencia> actualizarAsistencia(@Valid @RequestBody  Asistencia asistencia) throws SQLException {
     asistenciaRep.save(asistencia);
     return new ResponseEntity(msg.update(), HttpStatus.OK);
     }

@RequestMapping(value = "/campus", method = RequestMethod.GET)
public ResponseEntity getCampus () throws SQLException {
    String wi = "  WHERE SLBRDEF_BLDG_CODE = SLBBLDG_BLDG_CODE ";
    List<CampusVo> campus = campusRep.getCampus(wi);
    return new ResponseEntity(campus, HttpStatus.OK);
}
@RequestMapping(value = "/Horario/{campus}/{dia}", method = RequestMethod.GET)
public ResponseEntity getHorario(@PathVariable String campus, String dia) throws SQLException {
    String wi = "WHERE SZARPGN_IDREPORT = 'AULAS_'||'" + campus + "' AND SLBRDEF_BLDG_CODE = SZARPGN_CAMPVAR3 AND SLBRDEF_ROOM_NUMBER = SZARPGN_CAMPVAR4 AND SLBRDEF_RMST_CODE = 'AC' AND SLBRDEF_ROOM_TYPE = 'C' AND '" + dia + "' IS NOT NULL ORDER BY 3,4,1";
    List<HorarioVo> horario = horarioAsi.getHorario(wi);
    return new ResponseEntity(horario, HttpStatus.OK);
}
@RequestMapping(value = "/planificaionReforzamiento/{pidm}", method = RequestMethod.GET)
public ResponseEntity getPlanificaionR(@PathVariable String pidm) throws SQLException {
    String wi = "WHERE SIRASGN_PIDM  = "+ pidm +" \r\n" + 
    		"                AND SIRASGN_TERM_CODE = SSBSECT_TERM_CODE\r\n" + 
    		"                AND SIRASGN_CRN = SSBSECT_CRN\r\n" + 
    		"                AND SSRMEET_TERM_CODE = SSBSECT_TERM_CODE\r\n" + 
    		"                AND SSRMEET_CRN = SSBSECT_CRN       \r\n" + 
    		"                AND SSRMEET_MTYP_CODE = 'TUTO' \r\n" + 
    		//"                AND SSBSECT_PTRM_END_DATE >= SYSDATE\r\n" + 
    		"                AND SSBSECT_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE\r\n" + 
    		"                AND SSBSECT_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB\r\n" + 
    		"                AND A.SCBCRSE_EFF_TERM = (SELECT MAX( SCBCRSE_EFF_TERM)\r\n" + 
    		"                FROM  SCBCRSE\r\n" + 
    		"                WHERE SCBCRSE_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE\r\n" + 
    		"                AND SCBCRSE_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB) ";
    List<PlanificacionReforzamientoVo> nrcPlanif = nrcPlanificacion.getPlanificaionR(wi);
    return new ResponseEntity(nrcPlanif, HttpStatus.OK);
}
@RequestMapping(value = "/HorarioP/{campus1}/{dia}/{hora_INICIO}/{hora_FIN}", method = RequestMethod.GET)
public ResponseEntity getHorarioPla(@PathVariable String campus1,@PathVariable String dia, @PathVariable String hora_INICIO,@PathVariable String hora_FIN) throws SQLException {
	System.out.println(campus1+dia+hora_INICIO+hora_FIN);
    String wi = "WHERE SZARPGN_IDREPORT = 'AULAS_'||'" + campus1 + "' AND SLBRDEF_BLDG_CODE = SZARPGN_CAMPVAR3 AND SLBRDEF_ROOM_NUMBER = SZARPGN_CAMPVAR4 AND SLBRDEF_RMST_CODE = 'AC' AND SLBRDEF_ROOM_TYPE = 'C' AND '" + dia + "' IS NOT NULL AND SZARPGN_CAMPVAR7 = '" + hora_INICIO + "' AND SZARPGN_CAMPVAR8 = '" + hora_FIN + "' ";
    List<HorarioPlaVo> horarioPlan = horarioPla.getHorarioPla(wi);
    
    System.out.println(wi);
    return new ResponseEntity(horarioPlan, HttpStatus.OK);
}
}



