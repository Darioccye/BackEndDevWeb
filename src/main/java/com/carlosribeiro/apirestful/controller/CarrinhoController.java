package com.carlosribeiro.apirestful.controller;

import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("carrinho")
public class CarrinhoController {

    private HashMap<Long, HashMap<Long, Integer>> carrinho;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(HashMap<Long, HashMap<Long, Integer>> carrinho){
        this.carrinho = carrinho;
    }


    @GetMapping("{idUsuario}")
    public List<Produto> recuperarProdutosCarrinho(@PathVariable("idUsuario") Long idUsuario){
        return carrinhoService.recuperarProdutosCarrinho(carrinho, idUsuario);
    }

    @GetMapping("quantidade/{idUsuario}")
    public List<Integer> recuperarQuantidadeCarrinho(@PathVariable("idUsuario") Long idUsuario){
        return carrinhoService.recuperarQuantidadeCarrinho(carrinho, idUsuario);
    }

    @PutMapping("add/{idUsuario}/{idProduto}")
    public void adicionarProduto(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idProduto") Long idProduto){
        carrinhoService.adicionarProduto(carrinho, idUsuario, idProduto);
    }

    @PutMapping({"sub/{idUsuario}/{idProduto}"})
    public void subtrairProduto(@PathVariable("idUsuario") Long idUsuario,@PathVariable("idProduto") Long idProduto){
        carrinhoService.subtrairProduto(carrinho, idUsuario, idProduto);
    }

    @DeleteMapping("{idUsuario}/{idProduto}")
    public void removerProduto(@PathVariable("idUsuario") Long idUsuario,@PathVariable("idProduto") Long idProduto) {
        carrinhoService.removerProduto(carrinho, idUsuario, idProduto);
    }

    @GetMapping("total/{idUsuario}")
    public BigDecimal calcularTotal(@PathVariable("idUsuario") Long idUsuario){
        return carrinhoService.calcularTotal(carrinho, idUsuario);
    }

}
