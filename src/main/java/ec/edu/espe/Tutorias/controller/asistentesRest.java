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
import ec.edu.espe.Tutorias.Vo.HorarioVo;
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
public ResponseEntity getConfirmar(@PathVariable String campus, String dia) throws SQLException {
    String wi = "WHERE SZARPGN_IDREPORT = 'AULAS_'||'" + campus + "' AND SLBRDEF_BLDG_CODE = SZARPGN_CAMPVAR3 AND SLBRDEF_ROOM_NUMBER = SZARPGN_CAMPVAR4 AND SLBRDEF_RMST_CODE = 'AC' AND SLBRDEF_ROOM_TYPE = 'C' AND '" + dia + "' IS NOT NULL ORDER BY 3,4,1";
    List<HorarioVo> horario = horarioAsi.getHorario(wi);
    return new ResponseEntity(horario, HttpStatus.OK);
}

}



