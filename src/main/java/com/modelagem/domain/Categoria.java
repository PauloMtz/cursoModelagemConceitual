package com.modelagem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// import com.fasterxml.jackson.annotation.JsonManagedReference;

// implementar Serializable
// adicionar anotação da JPA para transformar essa classe em entidade no banco de dados
@Entity
public class Categoria implements Serializable {
	
	// versão default (versão 1, ou primeira versão)
	private static final long serialVersionUID = 1L;
	
	// declaração dos atributos
	// transformar atributos em valores na tabela no banco de dados
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // IDENTIY para geração de chave primária
	private Integer id;
	private String nome;
	
	// associação com a classe Produto --> sendo o papel produtos o mesmo da modelagem de dados
	// @JsonManagedReference
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	// construtor vazio
	public Categoria() {
	}
	
	// construtor com parâmetros
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// adicionado posteriormente
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	// hashCode and equals - para comparar os objetos por valor (id)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}	