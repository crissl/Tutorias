package ec.edu.espe.Tutorias.controller;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.Tutorias.Vo.ConfirmacionAsistenciaVo;
import ec.edu.espe.Tutorias.Vo.SolicitudVo;

@RestController
@RequestMapping("/tutoring")
public class Correo {
private static final String Cod = null;
private static final String Actividad = null;
private static final String Carrera = null;
private static final String Razon = null;
private static final String Campus = null;

private SolicitudVo confirmacionAsi;



	String par_mensaje = " el formulario " + Cod + " " + Actividad + " fue llenado";
    String par_emailp = "auditoria_sis@espe.edu.ec";
    String par_mensajeprincipal = " espere por favor una hora y podrá realizar su matricula";
    String par_notificacion1 = " del Campus " + Campus + " y Carrera " + Carrera + ", por la siguiente Razon: " + Razon;
    String par_notificacion2 = " la solicitud será procesada ";

    @RequestMapping(value = "/llamadaCorreo/{Cedula}/{Nombres}/{Email}", method = RequestMethod.GET)
    public ResponseEntity getConfirmar(@PathVariable String Cedula, @PathVariable String Nombres, @PathVariable String Email) throws SQLException {
        String wi = "  \"CALL wfobjects.wzwkreport.P_Envio_Emails('" + par_mensaje + "'" + ",'" + Cedula + "'" + ",'" + Nombres + "'\"\r\n" + 
        		"            + \",'" + Email + "'" + ",'" + par_emailp + "'" + ",'" + par_mensajeprincipal + "'" + ",'" + par_notificacion1 + "'" + ",'" + par_notificacion2 + "'\"\r\n" + 
        		"            + \")";
        return new ResponseEntity(HttpStatus.OK);
    }
//    coWF.prepareStatement("CALL wfobjects.wzwkreport.P_Envio_Emails('" + par_mensaje + "'" + ",'" + Cedula + "'" + ",'" + Nombres + "'"
//            + ",'" + Email + "'" + ",'" + par_emailp + "'" + ",'" + par_mensajeprincipal + "'" + ",'" + par_notificacion1 + "'" + ",'" + par_notificacion2 + "'"
//            + ")").executeQuery();
	


}
