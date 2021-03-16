package com.jav.app.usuarios.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jav.app.usuarios.models.UsuarioModel;
import com.jav.app.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> obtenerPorId (Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPropiedad (Integer propiedad){
		return usuarioRepository.findByPropiedad(propiedad);
	}
	
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
