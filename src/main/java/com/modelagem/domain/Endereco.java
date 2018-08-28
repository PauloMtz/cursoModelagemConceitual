package com.modelagem.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// declara os atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_endereco;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	// associação com cliente --> um endereço pertence a um cliente
	// no entanto, um cliente pode ter mais de um endereço
	@JsonIgnore // endereço não serializa cliente
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	// associar endereço com cidade --> endereço tem apenas uma cidade
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	// construtor vazio
	public Endereco() {
		super();
	}

	// construtor com parâmetros
	public Endereco(Integer id_endereco, String logradouro, String numero, String complemento, String bairro,
			String cep, Cliente cliente, Cidade cidade) {
		super();
		this.id_endereco = id_endereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.setCidade(cidade);
	}

	// getters e setters
	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	// hashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}
}
