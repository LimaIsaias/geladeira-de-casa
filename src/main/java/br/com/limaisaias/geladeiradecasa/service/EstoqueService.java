package br.com.limaisaias.geladeiradecasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Estoque;
import br.com.limaisaias.geladeiradecasa.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	public List<Estoque> findAll() {
		return estoqueRepository.findAll();
	}

	public Optional<Estoque> findOne(Long id) {
		return estoqueRepository.findById(id);
	}

	public Estoque save(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}
	
	public Estoque update(Long id, Estoque estoque) {
		estoque.setId(id);
		return save(estoque);
	}
	

	public Estoque update(Estoque estoque) {
		return save(estoque);
	}

	public void delete(Estoque estoque) {
		estoqueRepository.delete(estoque);
	}

	public void deleteById(Long id) {
		estoqueRepository.deleteById(id);
	}
}
