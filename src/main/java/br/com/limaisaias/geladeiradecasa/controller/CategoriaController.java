package br.com.limaisaias.geladeiradecasa.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.limaisaias.geladeiradecasa.model.Categoria;
import br.com.limaisaias.geladeiradecasa.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController{
	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> entity = service.findAll();
		return null != entity && !entity.isEmpty() ? ResponseEntity.ok(entity) : ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria produto, HttpServletResponse response) {
		Categoria produtoSalva = service.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria entity) {
		return ResponseEntity.ok(service.update(id, entity));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id) {
		Optional<Categoria> entity = service.findOne(id);
		return entity.isPresent() ? ResponseEntity.ok(entity.get()) : ResponseEntity.notFound().build();
	}
}
