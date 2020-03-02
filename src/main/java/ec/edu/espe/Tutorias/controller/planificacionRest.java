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

import ec.edu.espe.Tutorias.dao.planificacionRepository;
import ec.edu.espe.Tutorias.model.Planificacion;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tut")
public class planificacionRest {

    @Autowired
    private planificacionRepository planificacionRep;

   

    // funcion para listar un formulario
    @RequestMapping(value = "/segu1", method = RequestMethod.GET)
    public ResponseEntity<Planificacion> listarPlanificacion() throws SQLException {
        List<Planificacion> tutorias = planificacionRep.findallPlanifica();
        if (tutorias.isEmpty()) {
            return new ResponseEntity("no encuentra", HttpStatus.OK);
        } else {
            return new ResponseEntity(tutorias, HttpStatus.OK);
        }
    }
    
     //metodo agregar
    @RequestMapping(value = "/segu", method = RequestMethod.POST)
    public ResponseEntity<Planificacion> crearPlanificacion(@Valid @RequestBody Planificacion usuario) {
        Planificacion planif = new Planificacion();
        int ultimo = planificacionRep.findTopByOrderByIdDesc().getId()+1;
        usuario.setId(ultimo);
        //planif.setId(ultimo);
        planificacionRep.save(usuario);
        return new ResponseEntity("planificacion creado", HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/ultimo", method = RequestMethod.GET)
    public ResponseEntity<Planificacion> ultimo(){
        int ultimo = planificacionRep.findTopByOrderByIdDesc().getId()+1;
        return new ResponseEntity(ultimo, HttpStatus.OK);
    
    }

}
