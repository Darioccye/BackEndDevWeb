package com.carlosribeiro.apirestful.repository;

import com.carlosribeiro.apirestful.model.Produto;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long idCategoria);

    Produto findById(int id);

    @Query("select p from Produto p " +
           "left outer join fetch p.categoria " +
           "order by p.id")
    List<Produto> recuperarProdutosComCategoria();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Produto p where p.id = :id")
    Optional<Produto> recuperarPorIdComLock(Long id);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.id",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoId(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.categoria.nome",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoCategoria(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.nome",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoNome(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.dataCadastro",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoDataDeCadastro(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.qtdEstoque",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoQuantidade(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.preco",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoPreco(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.id desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoIdDecrescente(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.categoria.nome desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoCategoriaDecrescente(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.nome desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoNomeDecrescente(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.dataCadastro desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoDataDeCadastroDecrescente(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.qtdEstoque desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoQuantidadeDecrescente(String nome, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome% " +
                    "order by p.preco desc",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacaoPrecoDecrescente(String nome, Pageable pageable);


    @Query("select p from Produto p " +
            "left outer join fetch p.categoria " +
            "where p.id = :id")
    Optional<Produto> recuperarProdutoPorId(Long id);

    @Query("select p from Produto p left outer join fetch p.categoria c where c.slug = :slug")
    List<Produto> findByCategoriaSlug(String slug);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria c " +
                    "where c.slug = :slug " +
                    "order by p.nome",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "left outer join p.categoria c " +
                    "where c.slug = :slug  "
    )
    Page<Produto> recuperarProdutosPaginadosPorSlugDaCategoria(String slug, Pageable pageable);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria c " +
                    "order by p.nome",
            countQuery = "select count(p) from Produto p "
    )
    Page<Produto> recuperarProdutosPaginados(Pageable pageable);
}
