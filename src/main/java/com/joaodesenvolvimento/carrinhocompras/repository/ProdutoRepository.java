package com.joaodesenvolvimento.carrinhocompras.repository;

import com.joaodesenvolvimento.carrinhocompras.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
