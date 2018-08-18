package com.modelagem.domain.enums;

public enum TipoCliente {

	// declara os tipos com código e descrição
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	// cria os atributos para o código e a descrição
	private int cod;
	private String descricao;
	
	// construtor com parâmetros
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// gerar apenas os getters porque os valores do enum são estáticos
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	// método para varrer o código e retornar o tipo de cliente
	public static TipoCliente toEnum(Integer cod) {
		
		// testa se o valor é nulo
		if(cod == null) {
			return null;
		}
		
		// laço for para procurar os tipos
		for(TipoCliente x : TipoCliente.values()) {
			
			// testa se o código informado é igual a algum tipo de cliente
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		// se o código for inválido, lançar exceção
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
