package ec.edu.espe.Tutorias.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutoring")
public class Correo {
//
//	@Autowired
//	private JavaMailSender sender;
//	@RequestMapping("/mail")
//	@ResponseBody
//	String home() {
//		try {
//			enviarCorreo();
//			return "Email Sent!";
//		} catch (Exception ex) {
//			return "Error in sending email: " + ex;
//		}
//	}
//	private void enviarCorreo() throws Exception {
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		helper.setFrom("development@espe.edu.ec");
//		helper.setTo("saintkache@gmail.com");
//		helper.setText("<html \n"
//				+ "Espe.edu.ec><body>Enlace para recuperar contraseña: http://localhost:4200/confirmpassword/7 \r\n"
//				+ "contactos \r\n" + "direccion \r\n" + "<body></html>", true);
//		helper.setSubject("Hi");
//
//		sender.send(message);
//	}

}
