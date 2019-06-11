package br.com.limaisaias.geladeiradecasa.service;

import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Categoria;
import br.com.limaisaias.geladeiradecasa.repository.CategoriaRepository;

@Service
public class CategoriaService extends AbstractService<Categoria, Long> {

	public CategoriaService(CategoriaRepository repository) {
		super(repository);
	}
	
}