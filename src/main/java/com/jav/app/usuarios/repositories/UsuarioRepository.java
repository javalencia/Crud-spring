package com.jav.app.usuarios.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jav.app.usuarios.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	
	public abstract ArrayList<UsuarioModel> findByPropiedad(Integer prioridad);

}
