package com.ufg.inf.cs.repository;

import com.ufg.inf.cs.models.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {

    @Query("SELECT d FROM DespesaModel d JOIN d.solicitacao s WHERE s.republica.id = :republicaId")
    List<DespesaModel> findDespesasByRepublicaId(@Param("republicaId") Long republicaId);
}
