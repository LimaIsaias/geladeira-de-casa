package br.com.limaisaias.geladeiradecasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Categoria;
import br.com.limaisaias.geladeiradecasa.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Optional<Categoria> findOne(Long id) {
		return repository.findById(id);
	}

	public Categoria save(Categoria produto) {
		return repository.save(produto);
	}

	public Categoria update(Long id, Categoria produto) {
		produto.setId(id);
		return save(produto);
	}

	public void delete(Categoria produto) {
		repository.delete(produto);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}