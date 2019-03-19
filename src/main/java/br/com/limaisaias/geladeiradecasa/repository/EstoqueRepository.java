package br.com.limaisaias.geladeiradecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.limaisaias.geladeiradecasa.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
