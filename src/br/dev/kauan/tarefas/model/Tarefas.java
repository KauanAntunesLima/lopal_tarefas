package br.dev.kauan.tarefas.model;

import java.time.LocalDate;
import java.util.List;
import br.dev.kauan.tarefas.utils.Utils;

public class Tarefas {

    private String titulo;
    private String codigo;
    private String descricao;
    private LocalDate data;
    private int prazo;
    private List<Status> status;
    private String responsavel;

    public Tarefas() {
        this.codigo = "TAR-" + Utils.gerarUUID8(); // Usa seu Utils para gerar o código
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public LocalDate conclusao() {
        return data.plusDays(prazo);
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        String statusStr = status != null && !status.isEmpty() ? status.get(0).name() : "NAO_INICIADO";
        return codigo + "," + titulo + "," + descricao + "," + data + "," + prazo + "," + conclusao() + "," + statusStr + "," + responsavel;
    }
}