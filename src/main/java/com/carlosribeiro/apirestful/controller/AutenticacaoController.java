package com.carlosribeiro.apirestful.controller;

import com.carlosribeiro.apirestful.exception.LoginException;
import com.carlosribeiro.apirestful.util.TokenResponse;
import com.carlosribeiro.apirestful.model.Usuario;
import com.carlosribeiro.apirestful.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("autenticacao")   // http://localhost:8080/autenticacao
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("login")  // http://localhost:8080/autenticacao/login
    public Long login(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = autenticacaoService.login(usuario);
        if (usuarioLogado != null) {
            System.out.println("Sucesso");
            return usuarioLogado.getId();
        } else {
            System.out.println("Falha");
            throw new LoginException("Ocorreu um erro de login.");
        }
        // 400 Bad Request - quando falta a conta ou a senha.
        // 401 Unauthorized - conta existente mas senha inválida.
        // 403 Forbidden - autenticado, mas falta permissão para acessar o recurso.
        // 422 Unprocessable Entity - conta informada, mas não existe no bd.
    }

//    @GetMapping("conta")
//    public Long idConta(@RequestBody Usuario usuario){
//        Usuario usuarioLogado = autenticacaoService.login(usuario);
//        if (usuarioLogado != null) {
//            return usuarioLogado.getId();
//        } else {
//            System.out.println("Falha");
//            throw new LoginException("Ocorreu um erro de login.");
//        }
//    }
}
