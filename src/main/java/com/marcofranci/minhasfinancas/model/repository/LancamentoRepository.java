package com.marcofranci.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcofranci.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
