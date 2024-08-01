package com.ufg.inf.cs.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOLICITACOES")
@SequenceGenerator(name = "SEQ_SOLICITACOES", sequenceName = "SEQ_SOLICITACOES", allocationSize = 1, initialValue = 1)
public class SolicitacaoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITACOES")
    private long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String local;

    @OneToOne(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private DespesaModel despesa;

    @ManyToOne(targetEntity = RepublicaModel.class)
    @JoinColumn(
            name = "REPUBLICA_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_SOLICITACOES_REPUBLICA_ID")
    )
    private RepublicaModel republica;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public RepublicaModel getRepublica() {
        return republica;
    }

    public void setRepublica(RepublicaModel republica) {
        this.republica = republica;
    }

    public DespesaModel getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesaModel despesa) {
        this.despesa = despesa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        SolicitacaoModel other = (SolicitacaoModel) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
