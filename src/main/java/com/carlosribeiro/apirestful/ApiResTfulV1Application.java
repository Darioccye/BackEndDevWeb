package com.carlosribeiro.apirestful;

import com.carlosribeiro.apirestful.model.Categoria;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.model.Usuario;
import com.carlosribeiro.apirestful.repository.CategoriaRepository;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import com.carlosribeiro.apirestful.repository.UsuarioRepository;
import com.carlosribeiro.apirestful.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@CrossOrigin
@SpringBootApplication
public class ApiResTfulV1Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CarrinhoService carrinhoService;

	public static void main(String[] args) {
		SpringApplication.run(ApiResTfulV1Application.class, args);
	}

		HashMap<Long, HashMap<Long, Integer>> carrinho = new HashMap<>();

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario("a", "a");
		usuarioRepository.save(usuario);
		carrinho.put(usuario.getId(), new HashMap<>());

		usuario = new Usuario("admin", "12345");
		usuarioRepository.save(usuario);
		carrinho.put(usuario.getId(), new HashMap<>());

		Categoria fruta = new Categoria("Frutas", "frutas");
		categoriaRepository.save(fruta);

		Categoria legume = new Categoria("Legumes", "legumes");
		categoriaRepository.save(legume);

		Categoria verdura = new Categoria("Verduras", "verduras");
		categoriaRepository.save(verdura);

		Categoria calca = new Categoria("Calças", "calcas");
		categoriaRepository.save(calca);

		Categoria roupa = new Categoria("Roupas", "roupas");
		categoriaRepository.save(roupa);

		Categoria acessorio = new Categoria("Acessórios", "acessorios");
		categoriaRepository.save(acessorio);

		Produto produto = new Produto(
				"roupa-verde.jpg",
				"Roupa Verde",
				"Descrição",
				"M",
				true,
				7,
				BigDecimal.valueOf(30.99),
				LocalDate.of(2022, 3, 9),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-vermelha.jpg",
				"Roupa Vermelha",
				"Descrição",
				"G",
				true,
				7,
				BigDecimal.valueOf(38.99),
				LocalDate.of(2022, 3, 9),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-roxa.jpg",
				"Roupa Roxa",
				"Descrição",
				"P",
				true,
				7,
				BigDecimal.valueOf(25.99),
				LocalDate.of(2021, 3, 23),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-marrom.jpg",
				"Roupa Marrom",
				"Descrição",
				"GG",
				true,
				7,
				BigDecimal.valueOf(22.99),
				LocalDate.of(2024, 11, 9),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-branca.jpg",
				"Roupa Branca",
				"Descrição",
				"PP",
				true,
				7,
				BigDecimal.valueOf(40.99),
				LocalDate.of(2023, 8, 9),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-azul.jpg",
				"Roupa Azul",
				"Descrição",
				"M",
				true,
				7,
				BigDecimal.valueOf(50.99),
				LocalDate.of(2022, 6, 9),
				roupa);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa-amarela.jpg",
				"Roupa Amarela",
				"Descrição",
				"G",
				true,
				7,
				BigDecimal.valueOf(47.99),
				LocalDate.of(2022, 5, 9),
				roupa);
		produtoRepository.save(produto);


		produto = new Produto(
				"anel-rosa.jpg",
				"Anel de Quartzo Rosa",
				"Anel de ouro",
				"19",
				true,
				5,
				BigDecimal.valueOf(300.99),
				LocalDate.of(2024, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-branco.jpg",
				"Anel de Diamante",
				"Anel de ouro",
				"19",
				true,
				15,
				BigDecimal.valueOf(499.99),
				LocalDate.of(2024, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-azul.jpg",
				"Anel de Safira",
				"Anel de prata",
				"21",
				true,
				15,
				BigDecimal.valueOf(349.99),
				LocalDate.of(2022, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-laranja.jpg",
				"Anel de Topázio",
				"Anel de prata",
				"17",
				true,
				4,
				BigDecimal.valueOf(279.99),
				LocalDate.of(2023, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-roxo.jpg",
				"Anel de Quartzo Roxo",
				"Anel de ouro",
				"19",
				true,
				5,
				BigDecimal.valueOf(349.99),
				LocalDate.of(2024, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-verde.jpg",
				"Anel de Esmeralda",
				"Anel de ouro",
				"19",
				true,
				4,
				BigDecimal.valueOf(379.99),
				LocalDate.of(2024, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"anel-vermelho.jpg",
				"Anel de Rubi",
				"Anel de ouro",
				"18",
				true,
				3,
				BigDecimal.valueOf(369.99),
				LocalDate.of(2024, 6, 11),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-amarela.jpg",
				"Calça Amarela",
				"Descrição",
				"M",
				true,
				12,
				BigDecimal.valueOf(55.99),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-azul.jpg",
				"Calça Azul",
				"Descrição",
				"M",
				true,
				12,
				BigDecimal.valueOf(35.99),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-marrom.jpg",
				"Calça Marrom",
				"Descrição",
				"M",
				true,
				12,
				BigDecimal.valueOf(55.99),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-verde.jpg",
				"Calça Verde",
				"Descrição",
				"M",
				true,
				12,
				BigDecimal.valueOf(59.99),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-vermelha.jpg",
				"Calça Vermelha",
				"Descrição",
				"P",
				true,
				12,
				BigDecimal.valueOf(34.99),
				LocalDate.of(2023, 2, 13),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"calca-vinho.jpg",
				"Calça Vinho",
				"Descrição",
				"M",
				true,
				12,
				BigDecimal.valueOf(80.99),
				LocalDate.of(2024, 5, 22),
				calca);
		produtoRepository.save(produto);



		carrinho.get((long)1).put((long) 1, 1);

		carrinho.get((long)1).put((long) 10, 1);


		carrinhoService.adicionarProduto(carrinho, (long) 1, (long) 17);

//		System.out.println(carrinho);
//
//		System.out.println(carrinho);
//
//		System.out.println(carrinhoService.calcularTotal(carrinho, (long) 1));

	}

	@Bean
	public HashMap<Long, HashMap<Long, Integer>> carrinho() {
		return carrinho;
	}
}
