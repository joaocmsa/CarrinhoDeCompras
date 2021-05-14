package com.joaodesenvolvimento.carrinhocompras.repository;

import com.joaodesenvolvimento.carrinhocompras.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
