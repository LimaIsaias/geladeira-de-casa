package br.com.limaisaias.geladeiradecasa.service;

import org.springframework.stereotype.Service;

import br.com.limaisaias.geladeiradecasa.model.Produto;
import br.com.limaisaias.geladeiradecasa.repository.ProdutoRepository;

@Service
public class ProdutoService extends AbstractService<Produto, Long>{

	public ProdutoService(ProdutoRepository produtoRepository) {
		super(produtoRepository);
	}

}