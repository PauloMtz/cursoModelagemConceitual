package com.modelagem.domain;

import com.modelagem.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	
	// subclasse não precisa de implementar Serializable, mas precisa da versão
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;

	// construtor vazio
	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		
		// acrescentar
		this.numeroParcelas = numeroParcelas;
	}

	// getters e setters
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	// a subclasse não precisa de hashCode e equals porque a comparação já está na superclasse
	
}
