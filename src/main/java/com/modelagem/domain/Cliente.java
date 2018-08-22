package com.modelagem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.modelagem.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// declara os atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cliente;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	//private TipoCliente tipo;
	// alterar TipoCliente para inteiro
	private Integer tipo;
	
	// associação com endereço --> um cliente por ter mais de um endereço
	// e, um endereço pode ser de vários clientes
	// a anotação Json protege contra a serialização cíclica
	@JsonManagedReference // cliente serializa endereço, porém este não efetua o inverso
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	// como telefones é uma entidade fraca, ela pode ser instanciada aqui
	// foi usada coleção do tipo SET, que não aceita repetição
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	// cliente também pode ter vários pedidos
	private List<Pedido> pedidos = new ArrayList<>();

	// construtor vazio
	public Cliente() {
		super();
	}

	// construtor com parâmetros - não gerar o que for coleção
	public Cliente(Integer id_cliente, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
	}

	// getters e setters
	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	// aqui será utilizado aquele método toEnum do enum tipo de cliente
	public TipoCliente getTipo() {
		//return tipo;
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	// hashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		return true;
	}
}
