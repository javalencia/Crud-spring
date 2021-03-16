package com.jav.app.usuarios.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jav.app.usuarios.models.UsuarioModel;
import com.jav.app.usuarios.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return usuarioService.guardarUsuario(usuario);
	}
	
	@GetMapping( path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPropiedad(@RequestParam("propiedad") Integer propiedad){
		return this.usuarioService.obtenerPorPropiedad(propiedad);
	}
	
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se elimino el usuario con id : "+id;
		}else {
			return "No se pudo eliminar el usuario con id : "+id;
		}
	}
}
