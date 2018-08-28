package com.modelagem;

import java.text.SimpleDateFormat;
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
import com.modelagem.domain.ItemPedido;
import com.modelagem.domain.Pagamento;
import com.modelagem.domain.PagamentoComBoleto;
import com.modelagem.domain.PagamentoComCartao;
import com.modelagem.domain.Pedido;
import com.modelagem.domain.Produto;
import com.modelagem.domain.enums.EstadoPagamento;
import com.modelagem.domain.enums.TipoCliente;
import com.modelagem.repositories.CategoriaRepository;
import com.modelagem.repositories.CidadeRepository;
import com.modelagem.repositories.ClienteRepository;
import com.modelagem.repositories.EnderecoRepository;
import com.modelagem.repositories.EstadoRepository;
import com.modelagem.repositories.ItemPedidoRepository;
import com.modelagem.repositories.PagamentoRepository;
import com.modelagem.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		// ----------------- PARTE 04 ------------------------------------
		
		// cria uma máscara para formatação de data e hora
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		// instancia pedidos
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		// instancia pagamentos
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		// associa cliente-pedido
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		// salva os pedidos e pagamentos no banco de dados
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		// ----------------- PARTE 05 ------------------------------------
		
		// instancia itemPedido
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 1800.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 1, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		// associa pedido e itemPedido
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		// associa produto e itemPedido
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		// para salvar --> criar repository
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
