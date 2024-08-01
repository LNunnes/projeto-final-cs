package com.ufg.inf.cs.models;

import java.sql.Date;

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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "AGENDAMENTOS")
@SequenceGenerator(name = "SEQ_AGENDAMENTOS", sequenceName = "SEQ_AGENDAMENTOS", allocationSize = 1, initialValue = 1)
public class AgendamentoModel {
    
    @Id
    @GeneratedValue(generator = "SEQ_AGENDAMENTOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataInicialAgendamento;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataFinalAgendamento;

    @Column(nullable = false)
    private char situacao = 'A';

    @ManyToOne(targetEntity = EspacoComunitarioModel.class, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "ESPACO_COMUNITARIO_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_AGENDAMENTOS_ESPACO_COMUNITARIO_ID")
    )
    private EspacoComunitarioModel espacoComunitario;

    @ManyToOne(targetEntity = UsuarioModel.class, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "USUARIO_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_AGENDAMENTOS_USUARIO_ID")
    )
    private UsuarioModel usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicialAgendamento() {
        return dataInicialAgendamento;
    }

    public void setDataInicialAgendamento(Date dataInicialAgendamento) {
        this.dataInicialAgendamento = dataInicialAgendamento;
    }

    public Date getDataFinalAgendamento() {
        return dataFinalAgendamento;
    }

    public void setDataFinalAgendamento(Date dataFinalAgendamento) {
        this.dataFinalAgendamento = dataFinalAgendamento;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public EspacoComunitarioModel getEspacoComunitario() {
        return espacoComunitario;
    }

    public void setEspacoComunitario(EspacoComunitarioModel espacoComunitario) {
        this.espacoComunitario = espacoComunitario;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
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
        AgendamentoModel other = (AgendamentoModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
