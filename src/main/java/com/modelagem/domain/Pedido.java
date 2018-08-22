package com.modelagem.domain;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date dataHora;
	
	// associação com pagamento
	private Pagamento pagamento;
	
	// associação com cliente
	private Cliente cliente;
	
	// associação com endereço
	private Endereco enderecoEntrega;

	// construtor vazio
	public Pedido() {
		super();
	}

	// construtor com argumentos
	public Pedido(Integer id, Date dataHora, Pagamento pagamento, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	// hashCode e equals
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}