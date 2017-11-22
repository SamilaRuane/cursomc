package com.samilaruane.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samilaruane.cursomc.domain.Categoria;
import com.samilaruane.cursomc.repositories.CategoriaRepository;
import com.samilaruane.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar (Integer id) {
		Categoria obj = repo.findOne(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado id = " + id
					+ ", Tipo = " + Categoria.class.getName());
		}
		
		return obj;
	}
}
