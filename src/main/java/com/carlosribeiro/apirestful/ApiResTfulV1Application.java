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
				"abacate.png",
				"Abacate",
				"1 unidade aprox. 750g",
				"P",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"acessorio",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(3),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(15),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(5),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(22),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(25),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(33),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"acessorio",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(3),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(15),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(5),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(22),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(25),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(33),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"acessorio",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(3),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(15),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(5),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(22),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(25),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(33),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);


		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				acessorio);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"acessorio",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(3),
				LocalDate.of(2023, 5, 22),
				calca);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(15),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(5),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(22),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(25),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		produto = new Produto(
				"roupa.jpg",
				"roupa",
				"1 unidade aprox. 250g",
				"M",
				false,
				50,
				BigDecimal.valueOf(33),
				LocalDate.of(2023, 5, 22),
				legume);
		produtoRepository.save(produto);

		carrinho.get((long)1).put((long) 1, 10);

		carrinho.get((long)2).put((long) 5, 10);

		System.out.println(carrinho);

		carrinhoService.adicionarProduto(carrinho, (long) 1, (long) 4);

		System.out.println(carrinho);

		System.out.println(carrinhoService.calcularTotal(carrinho, (long) 1));

	}

	@Bean
	public HashMap<Long, HashMap<Long, Integer>> carrinho() {
		return carrinho;
	}
}
