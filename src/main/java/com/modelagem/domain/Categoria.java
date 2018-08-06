package com.modelagem.domain;

import java.io.Serializable;

// implementar Serializable
public class Categoria implements Serializable {
	
	// versão default (versão 1, ou primeira versão)
	private static final long serialVersionUID = 1L;
	
	// declaração dos atributos
	private Integer id;
	private String nome;
	
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