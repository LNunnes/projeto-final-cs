package com.ufg.inf.cs.repository;

import com.ufg.inf.cs.models.AgendamentoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

    @Query("SELECT a FROM AgendamentoModel a WHERE a.espacoComunitario.id = :espacoComunitarioId")
    List<AgendamentoModel> findByEspacoComunitarioId(@Param("espacoComunitarioId") Long espacoComunitarioId);
}
