package com.ufg.inf.cs.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIOS")
@SequenceGenerator(name = "SEQ_USUARIOS", sequenceName = "SEQ_USUARIOS", allocationSize = 1, initialValue = 1)
public class UsuarioModel {
    
    @Id
    @GeneratedValue(generator = "SEQ_USUARIOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private Boolean salvarInfosCloud = Boolean.FALSE;

    @Column(nullable = false)
    private char tipoConta; //R -> residente G -> gerente
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;

    private char sexo;

    @Column(nullable = false)
    private String cpf;

    private String curso;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @ManyToOne(targetEntity = RepublicaModel.class)
    @JoinColumn(
            name = "REPUBLICA_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_USUARIOS_REPUBLICA_ID")
    )
    private RepublicaModel republica;

    @ManyToOne(targetEntity = AcomodacaoModel.class)
    @JoinColumn(
            name = "ACOMODACAO_ID", 
            nullable = true, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_USUARIOS_ACOMODACAO_ID")
    )
    private AcomodacaoModel acomodacao;

    @OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "USUARIOS_TAREFAS", 
		uniqueConstraints = @UniqueConstraint (columnNames = {"USUARIO_ID", "TAREFA_ID"}, name = "UNI_USUARIO_TAREFA" ), 
		joinColumns = @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", table = "USUARIOS", foreignKey = @ForeignKey(name = "FK_USUARIOS_TAREFAS_USUARIO_ID", value = ConstraintMode.CONSTRAINT)),
		inverseJoinColumns = @JoinColumn(name = "TAREFA_ID", referencedColumnName = "ID", table = "TAREFAS", foreignKey = @ForeignKey(name = "FK_USUARIOS_TAREFAS_TAREFA_ID", value = ConstraintMode.CONSTRAINT))
	)
	private List<TarefaModel> tarefas;

    @OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "USUARIOS_AGENDAMENTOS", 
		uniqueConstraints = @UniqueConstraint (columnNames = {"USUARIO_ID", "AGENDAMENTO_ID"}, name = "UNI_USUARIO_AGENDAMENTO" ), 
		joinColumns = @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", table = "USUARIOS", foreignKey = @ForeignKey(name = "FK_USUARIOS_TAREFAS_USUARIO_ID", value = ConstraintMode.CONSTRAINT)),
		inverseJoinColumns = @JoinColumn(name = "AGENDAMENTO_ID", referencedColumnName = "ID", table = "AGENDAMENTOS", foreignKey = @ForeignKey(name = "FK_USUARIOS_TAREFAS_TAREFA_ID", value = ConstraintMode.CONSTRAINT))
	)
	private List<AgendamentoModel> agendamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getSalvarInfosCloud() {
        return salvarInfosCloud;
    }

    public void setSalvarInfosCloud(Boolean salvarInfosCloud) {
        this.salvarInfosCloud = salvarInfosCloud;
    }

    public char getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(char tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public RepublicaModel getRepublica() {
        return republica;
    }

    public void setRepublica(RepublicaModel republica) {
        this.republica = republica;
    }

    public AcomodacaoModel getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(AcomodacaoModel acomodacao) {
        this.acomodacao = acomodacao;
    }

    public List<TarefaModel> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaModel> tarefas) {
        this.tarefas = tarefas;
    }

    public List<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
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
        UsuarioModel other = (UsuarioModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
