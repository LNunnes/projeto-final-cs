package com.ufg.inf.cs.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "DESPESAS")
@SequenceGenerator(name = "SEQ_DESPESAS", sequenceName = "SEQ_DESPESAS", allocationSize = 1, initialValue = 1)
public class DespesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DESPESAS")
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column
    private Double valor;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @JsonIgnore
    @OneToOne(targetEntity = SolicitacaoModel.class)
	@JoinColumn(
            name = "SOLICITACAO_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_DESPESAS_SOLICITACAO_ID")
            
    )
    private SolicitacaoModel solicitacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public SolicitacaoModel getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(SolicitacaoModel solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DespesaModel other = (DespesaModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
