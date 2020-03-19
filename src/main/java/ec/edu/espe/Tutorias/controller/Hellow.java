package ec.edu.espe.Tutorias.controller;

import ec.edu.espe.Tutorias.Vo.NrcVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/hi")

public class Hellow {
   
    @Autowired
    private SolicitudVo libretaRep;

    public class Hi {

        @RequestMapping("/Hola")
        String hola() {
            return "Tutorias";
        }
    }

    //trae los cursos a los que da clases el profesor
    @RequestMapping(value = "/idp/{data}", method = RequestMethod.GET)
    public ResponseEntity libretap(@PathVariable int data) throws SQLException {
        String wi = " WHERE SIRASGN_PIDM  = " + data + ""
                + " AND SIRASGN_TERM_CODE = SSBSECT_TERM_CODE"
                + " AND SIRASGN_CRN = SSBSECT_CRN"
                + " AND SSBSECT_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE"
                + " AND SSBSECT_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB";
        List<NrcVo> libreta1 = libretaRep.getNrc(wi);
        return new ResponseEntity(libreta1, HttpStatus.OK);
    }

}
