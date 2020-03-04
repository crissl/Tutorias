package ec.edu.espe.Tutorias.util;

import com.google.gson.Gson;

import ec.edu.espe.Tutorias.model.mensajeApi;


public class Mensaje {

	private final Gson gson = new Gson();
	 private final mensajeApi mensaje = new mensajeApi();

	 public String add() {

	  String msj = "Se cre\u00f3 correctamente";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }

	 public String delete() {

	  String msj = "Se elimin\u00f3 correctamente";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }

	 public String update() {

	  String msj = "Se actualiz\u00f3 correctamente";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }

	 public String notfound() {

	  String msj = "No se encontraron resultados";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }

	 public String errorl() {

	  String msj = "El id o la clave no son las correctas";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }

	 public String ifexist() {

	  String msj = "Informacion ya Existente";
	  mensaje.setMensaje(msj);
	  return gson.toJson(mensaje);
	 }


	}

