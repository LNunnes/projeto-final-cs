package com.ufg.inf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufg.inf.cs.models.SolicitacaoModel;
import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoModel, Long> {
    List<SolicitacaoModel> findByRepublicaId(Long republicaId);
}