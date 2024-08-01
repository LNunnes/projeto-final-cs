package com.ufg.inf.cs.repository;

import com.ufg.inf.cs.models.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE TIPOCONTA = 'RESIDENTE' AND UPPER(republicaId) LIKE UPPER(CONCAT('%', :republicaId, '%'))", nativeQuery = true)
    ArrayList<EnderecoModel> listarResidentes(@Param("republicaId") String republicaId);

    @Query(value = "SELECT * FROM USUARIO WHERE TIPOCONTA = 'GERENTE' AND UPPER(republicaId) LIKE UPPER(CONCAT('%', :republicaId, '%'))", nativeQuery = true)
    ArrayList<EnderecoModel> listarGerentes(@Param("republicaId") String republicaId);
}
