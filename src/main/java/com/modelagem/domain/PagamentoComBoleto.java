package com.modelagem.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modelagem.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	
	// subclasse não precisa de implementar Serializable, mas precisa da versão
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	// construtor vazio
	public PagamentoComBoleto() {
		super();
	}

	// construtor com parâmetros - como é herança, gerar com herança da superclasse, e acrescentar atributos
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		
		// acrescentar
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	// getters e setters
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	// a subclasse não precisa de hashCode e equals porque a comparação já está na superclasse
	
}
