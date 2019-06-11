package br.com.limaisaias.geladeiradecasa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService <T , ID extends Serializable> {

	private JpaRepository<T,ID> repository;

	public AbstractService(JpaRepository<T,ID> repository) {
		this.repository = repository;
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findOne(ID id) {
		return repository.findById(id);
	}

	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	//implementar update
	@Deprecated
	public void update(T entity) {
		save(entity);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}
}