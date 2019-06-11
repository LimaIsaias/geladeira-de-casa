package br.com.limaisaias.geladeiradecasa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Produto  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;

	private BigDecimal preco;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date validade;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date compra;

	@ManyToOne
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
}
