package br.com.limaisaias.geladeiradecasa.service;

import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Estoque;
import br.com.limaisaias.geladeiradecasa.repository.EstoqueRepository;

@Service
public class EstoqueService extends AbstractService<Estoque, Long>{

	public EstoqueService(EstoqueRepository repository) {
		super(repository);
	}

}
