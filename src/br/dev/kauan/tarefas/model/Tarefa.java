package br.dev.kauan.tarefas.model;

public class Tarefa {
	
	private String titulo;
	private String descricao;
	private String dataInicial;
	private String prazo;
	private String dataConclusao;
	private String status;
	private String responsavel;
	
	public Tarefa(String titulo, String descricao, String status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getDataInicial() {
		return dataInicial;
	}
	
	public String getPrazo() {
		return prazo;
	}
	
	public String getDataConclusao() {
		return dataConclusao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	
	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	
		
	

}
