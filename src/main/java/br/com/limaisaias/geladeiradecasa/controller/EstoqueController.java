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

import br.com.limaisaias.geladeiradecasa.model.Estoque;
import br.com.limaisaias.geladeiradecasa.service.EstoqueService;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueController {

	@Autowired
	private EstoqueService service;

	@GetMapping
	public ResponseEntity<List<Estoque>> findAll() {
		List<Estoque> estoque = service.findAll();
		return null != estoque && !estoque.isEmpty() ? ResponseEntity.ok(estoque) : ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Estoque> save(@RequestBody Estoque estoque, HttpServletResponse response) {
		Estoque estoqueSalva = service.save(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estoque> update(@PathVariable Long id, @Valid @RequestBody Estoque estoque) {
		return ResponseEntity.ok(service.save(estoque));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estoque> buscarPeloId(@PathVariable Long id) {
		Optional<Estoque> estoque = service.findOne(id);
		return estoque.isPresent() ? ResponseEntity.ok(estoque.get()) : ResponseEntity.notFound().build();
	}

}
