package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=5, message="{tarefa.descricao.pequena}")
	@NotBlank(message="{tarefa.descricao.vazia}")
	private String descricao;
	private int finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="data_finalizacao")
	private Calendar dataFinalizacao;
	
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
	
	public int getFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(int finalizado) {
		this.finalizado = finalizado;
	}
	
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}
