package ec.edu.espe.Tutorias.controller;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.Tutorias.Vo.ConfirmacionAsistenciaVo;
import ec.edu.espe.Tutorias.Vo.EnvioCorreoVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;
import ec.edu.espe.Tutorias.constants.DominiosConstantes;

//@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)

@CrossOrigin(origins = { DominiosConstantes.DOMAIN_1, DominiosConstantes.DOMAIN_2, DominiosConstantes.DOMAIN_3})

@RestController
@RequestMapping(DominiosConstantes.context)
public class Correo {
private static final String Cod = null;
private static final String Actividad = null;
private static final String Carrera = null;
private static final String Razon = null;
private static final String Campus = null;

private SolicitudVo confirmacionAsi;

@PersistenceContext
EntityManager em;

	String par_mensaje = " el formulario " + Cod + " " + Actividad + " fue llenado";
    String par_emailp = "auditoria_sis@espe.edu.ec";
    String par_mensajeprincipal = " espere por favor una hora y podr� realizar su matricula";
    String par_notificacion1 = " del Campus " + Campus + " y Carrera " + Carrera + ", por la siguiente Razon: " + Razon;
    String par_notificacion2 = " la solicitud ser� procesada ";

//    @RequestMapping(value = "/llamadaCorreo/{Cedula}/{Nombres}/{Email}", method = RequestMethod.POST)
//    public ResponseEntity getConfirmar(@PathVariable String Cedula, @PathVariable String Nombres, @PathVariable String Email) throws SQLException {
//        String wi = "  \"CALL wfobjects.wzwkreport.P_Envio_Emails('" + par_mensaje + "'" + ",'" + Cedula + "'" + ",'" + Nombres + "'\"\r\n" + 
//        		"            + \",'" + Email + "'" + ",'" + par_emailp + "'" + ",'" + par_mensajeprincipal + "'" + ",'" + par_notificacion1 + "'" + ",'" + par_notificacion2 + "'\"\r\n" + 
//        		"            + \")";
//        return new ResponseEntity(HttpStatus.OK);
//    }

	
    @RequestMapping(value = "/llamadaCorreo", method = RequestMethod.POST)
	public boolean delete(@RequestBody EnvioCorreoVo usuario) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("proceso1");
		query.setParameter("Cedula", usuario.getCedula());
		query.setParameter("Nombres",usuario.getNombres());
		query.setParameter("Email",usuario.getEmail());

		query.execute();
		System.out.println(query.execute());
		return query.execute();
	}

}
