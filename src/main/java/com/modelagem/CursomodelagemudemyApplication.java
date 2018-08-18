package com.modelagem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.modelagem.domain.Categoria;
import com.modelagem.domain.Cidade;
import com.modelagem.domain.Cliente;
import com.modelagem.domain.Endereco;
import com.modelagem.domain.Estado;
import com.modelagem.domain.Produto;
import com.modelagem.domain.enums.TipoCliente;
import com.modelagem.repositories.CategoriaRepository;
import com.modelagem.repositories.CidadeRepository;
import com.modelagem.repositories.ClienteRepository;
import com.modelagem.repositories.EnderecoRepository;
import com.modelagem.repositories.EstadoRepository;
import com.modelagem.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomodelagemudemyApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomodelagemudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// ----------------- PARTE 01 ------------------------------------
		
		// instancia categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// instancia produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 35.00);
		
		// informa às categorias quais são seus produtos associados
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// informa aos produtos quais são suas categorias associadas
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// as classes CategoriaRepository e ProdutoRepository são quem conversam com o banco
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		// ----------------- PARTE 02 ------------------------------------
		
		// instancia estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		// instancia cidades
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		// informa aos estados quem são suas cidades
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		// salvar os estados e cidades no banco
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		// ----------------- PARTE 03 ------------------------------------
		
		// instancia clientes
		Cliente cli1 = new Cliente(null, "Maria da Silva", "mariasilva@email.com", "123.456.789-10", TipoCliente.PESSOAFISICA);
		
		// adiciona telefones
		cli1.getTelefones().addAll(Arrays.asList("(12) 99876-5432", "(12) 3456-7890"));
		
		// instancia endereço
		Endereco e1 = new Endereco(null, "Rua Teste", "300", "Casa", "Cidade Jardim", "38.220-000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38.777-012", cli1, c2);
		
		// o cliente precisa saber seus endereços
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// salvar no banco
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}
}
