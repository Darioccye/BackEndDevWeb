package com.carlosribeiro.apirestful.service;

import com.carlosribeiro.apirestful.exception.EntidadeDestacadaException;
import com.carlosribeiro.apirestful.exception.EntidadeNaoEncontradaException;
import com.carlosribeiro.apirestful.exception.EntidadeTransienteException;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProdutoService {

    private HashMap<Long, HashMap<Long, Integer>> carrinho;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    public ProdutoService(HashMap<Long, HashMap<Long, Integer>> carrinho){
        this.carrinho = carrinho;
    }

    public List<Produto> recuperarProdutos() {
        return produtoRepository.recuperarProdutosComCategoria();
    }

    public Produto recuperaProdutoPorId(int id){
        return produtoRepository.findById(id);
    }

    public Produto cadastrarProduto(Produto produto) {
        if (produto.getId() == null) {
            return produtoRepository.save(produto);
        }
        else {
            throw new EntidadeDestacadaException(
                "Tentando cadastrar um objeto destacado.");
        }
    }

//    public Produto alterarProduto(Produto produto) {
//        if (produto.getId() == null) {
//            throw new EntidadeTransienteException("Tentando alterar um objeto transiente.");
//        }
//        else {
//            if (produtoRepository.findById(produto.getId()).isPresent()) {
//                return produtoRepository.save(produto);
//            }
//            else {
//                throw new EntidadeNaoEncontradaException(
//                        "Produto número " + produto.getId() + " não encontrado.");
//            }
//        }
//    }

    @Transactional
    public Produto alterarProduto(Produto produto) {
        if (produto.getId() == null) {
            throw new EntidadeTransienteException("Tentando alterar um objeto transiente.");
        }
        else {
            produtoRepository.recuperarPorIdComLock(produto.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                      "Produto número " + produto.getId() + " não encontrado."));
            return produtoRepository.save(produto);
        }
    }

    public Produto removerProduto(Long id) {
        Produto p = produtoRepository.recuperarProdutoPorId(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto número " + id + " não encontrado."));
        produtoRepository.delete(p);
        for(int i=0; i < 100 ;i++){
            carrinhoService.removerProduto(carrinho, (long) i, id);
        }
        return p;
    }

    public List<Produto> recuperarProdutosPorIdDaCategoria(Long idCategoria) {
        return produtoRepository.findByCategoriaId(idCategoria);
    }

    public List<Produto> recuperarProdutosComCategoria() {
        // return produtoRepository.findAll();
        return produtoRepository.recuperarProdutosComCategoria();
    }

    public Page<Produto> recuperarProdutosComPaginacao(String nome, Pageable pageable, int filtro) {
        switch(filtro) {
            case 0:
                return produtoRepository.recuperarProdutosComPaginacaoId(nome, pageable);
            case 1:
                return produtoRepository.recuperarProdutosComPaginacaoCategoria(nome, pageable);
            case 2:
                return produtoRepository.recuperarProdutosComPaginacaoNome(nome, pageable);
            case 3:
                return produtoRepository.recuperarProdutosComPaginacaoDataDeCadastro(nome, pageable);
            case 4:
                return produtoRepository.recuperarProdutosComPaginacaoQuantidade(nome, pageable);
            case 5:
                return produtoRepository.recuperarProdutosComPaginacaoPreco(nome, pageable);
            case 6:
                return produtoRepository.recuperarProdutosComPaginacaoIdDecrescente(nome, pageable);
            case 7:
                return produtoRepository.recuperarProdutosComPaginacaoCategoriaDecrescente(nome, pageable);
            case 8:
                return produtoRepository.recuperarProdutosComPaginacaoNomeDecrescente(nome, pageable);
            case 9:
                return produtoRepository.recuperarProdutosComPaginacaoDataDeCadastroDecrescente(nome, pageable);
            case 10:
                return produtoRepository.recuperarProdutosComPaginacaoQuantidadeDecrescente(nome, pageable);
            case 11:
                return produtoRepository.recuperarProdutosComPaginacaoPrecoDecrescente(nome, pageable);
        }
        return produtoRepository.recuperarProdutosComPaginacaoId(nome, pageable);
    }

    public List<Produto> recuperarProdutosPorSlugDaCategoria(String slug) {
        return produtoRepository.findByCategoriaSlug(slug);
    }

    public Page<Produto> recuperarProdutosPaginadosPorSlugDaCategoria(String slug, Pageable pageable) {
        if(!slug.isEmpty()) {
            return produtoRepository.recuperarProdutosPaginadosPorSlugDaCategoria(slug, pageable);
        }
        else {
            return produtoRepository.recuperarProdutosPaginados(pageable);
        }
    }
}
