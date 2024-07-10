package com.carlosribeiro.apirestful.service;

import com.carlosribeiro.apirestful.exception.EntidadeNaoEncontradaException;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void adicionarProduto(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario, Long idProduto){
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        if(carrinhoUsuario != null){
            if(carrinhoUsuario.get(idProduto) == null){
                carrinhoUsuario.put(idProduto, 1);
            }
            else {
                Integer quantidade = carrinhoUsuario.get(idProduto);
                carrinhoUsuario.put(idProduto, quantidade+1);
            }
        }
        System.out.println(carrinho);
    }

    public void removerProduto(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario, Long idProduto){
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        if(carrinhoUsuario != null){
            carrinhoUsuario.remove(idProduto);
            carrinho.put(idUsuario, carrinhoUsuario);

        }
        System.out.println(carrinho);
    }

    public void subtrairProduto(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario, Long idProduto){
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        if(carrinhoUsuario != null){
            if(carrinhoUsuario.get(idProduto) != null){
                if(carrinhoUsuario.get(idProduto) == 1){
                    removerProduto(carrinho, idUsuario, idProduto);
                }
                else {
                    Integer quantidade = carrinhoUsuario.get(idProduto);
                    carrinhoUsuario.put(idProduto, quantidade-1);
                }
            }
        }
        System.out.println(carrinho);
    }

    public List<Produto> recuperarProdutosCarrinho(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario){
        System.out.println(carrinho);
        System.out.println(idUsuario);
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        List<Long> idProdutos = null;
        List<Produto> produtosCarrinho = new ArrayList<>();
        if(carrinhoUsuario != null){
            idProdutos = new ArrayList<>(carrinhoUsuario.keySet());
            Iterator<Long> idProdutosIterator = idProdutos.iterator();
            while (idProdutosIterator.hasNext()){
                Long id = idProdutosIterator.next();
                Produto produto = produtoRepository.recuperarProdutoPorId(id)
                        .orElseThrow(() -> new EntidadeNaoEncontradaException(
                                "Produto número " + id + " não encontrado."));
                produtosCarrinho.add(produto);
        }}
        System.out.println(carrinho);
        return produtosCarrinho;
    }

    public List<Integer> recuperarQuantidadeCarrinho(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario){
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        List<Integer> quantidadeProdutos = null;
        if(carrinhoUsuario != null){
            quantidadeProdutos = new ArrayList<>(carrinhoUsuario.values());
        }
        System.out.println(carrinho);
        return quantidadeProdutos;

    }

    public BigDecimal calcularTotal(HashMap<Long, HashMap<Long, Integer>> carrinho, Long idUsuario){
        HashMap<Long, Integer> carrinhoUsuario = carrinho.get(idUsuario);
        if(carrinhoUsuario != null){
            BigDecimal valorTotal = new BigDecimal(0);
            List<Produto> produtosCarrinho = recuperarProdutosCarrinho(carrinho, idUsuario);
            List<Integer> quantidadeCarrinho = recuperarQuantidadeCarrinho(carrinho, idUsuario);
            Iterator<Produto> iteratorProdutos = produtosCarrinho.iterator();
            Iterator<Integer> iteratorQuantidade = quantidadeCarrinho.iterator();
            while(iteratorProdutos.hasNext()){
                BigDecimal valorproduto = iteratorProdutos.next().getPreco();
                BigDecimal quantidadeProduto = BigDecimal.valueOf(iteratorQuantidade.next());
                valorTotal = valorTotal.add(valorproduto.multiply(quantidadeProduto));
                }
            System.out.println(carrinho);
            return valorTotal;
        }
            return (new BigDecimal(0));

    }

}
