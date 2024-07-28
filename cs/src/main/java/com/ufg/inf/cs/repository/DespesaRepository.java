package com.ufg.inf.cs.repository;

import com.ufg.inf.cs.models.DespesaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {
}
