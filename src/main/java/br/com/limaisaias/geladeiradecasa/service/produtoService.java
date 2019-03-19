package br.com.limaisaias.geladeiradecasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Produto;
import br.com.limaisaias.geladeiradecasa.repository.ProdutoRepository;

@Service
public class produtoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> findOne(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Produto produto) {
		return save(produto);
	}

	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
}
