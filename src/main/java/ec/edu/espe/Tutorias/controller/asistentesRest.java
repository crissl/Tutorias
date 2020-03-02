package ec.edu.espe.Tutorias.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.Tutorias.dao.asistenciaRepository;
import ec.edu.espe.Tutorias.dao.planificacionRepository;
import ec.edu.espe.Tutorias.model.Asistencia;
import ec.edu.espe.Tutorias.model.Planificacion;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tut")
public class asistentesRest  {
	
    private asistenciaRepository asistenciaRep;

//  Funcion Actualizar un usuario
@RequestMapping(value = "/segu2", method = RequestMethod.PUT)
public ResponseEntity<Asistencia> actualizarAsistencia(@Valid @RequestBody  Asistencia asistencia) throws SQLException {
     asistenciaRep.save(asistencia);
return new ResponseEntity("actualizado asistencia", HttpStatus.OK);
}


}
