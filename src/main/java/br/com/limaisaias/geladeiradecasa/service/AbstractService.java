package br.com.limaisaias.geladeiradecasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.limaisaias.geladeiradecasa.model.AbstractEntity;

public abstract class AbstractService <T extends AbstractEntity> {

	@Autowired
	private JpaRepository<T,Long> repository;

	public List<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findOne(Long id) {
		return repository.findById(id);
	}

	public T save(T entity) {
		return repository.save(entity);
	}

	public T update(Long id, T entity) {
		entity.setId(id);
		return save(entity);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}