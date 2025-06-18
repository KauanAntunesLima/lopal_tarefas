package br.dev.kauan.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.dev.kauan.tarefas.factory.FileFactory;
import br.dev.kauan.tarefas.model.Tarefas;
import br.dev.kauan.tarefas.model.Status;

public class TarefasDAO {

    private Tarefas tarefa;

    public TarefasDAO() {}

    public TarefasDAO(Tarefas tarefa) {
        this.tarefa = tarefa;
    }

    public void gravar() {
        BufferedWriter bw = null;
        try {
            FileFactory ff = new FileFactory();
            bw = ff.getBufferWriterTarefas();
            bw.write(tarefa.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Tarefas> listar() {
        List<Tarefas> tarefas = new ArrayList<>();
        BufferedReader br = null;

        try {
            FileFactory ff = new FileFactory();
            br = ff.getBufferedReaderTarefas();
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] dados = linha.split(",", -1);

                    if (dados.length >= 8) {
                        Tarefas tarefa = new Tarefas();
                        tarefa.setCodigo(dados[0]);
                        tarefa.setTitulo(dados[1]);
                        tarefa.setDescricao(dados[2]);
                        tarefa.setData(LocalDate.parse(dados[3]));
                        tarefa.setPrazo(Integer.parseInt(dados[4]));

                     
                        String statusStr = dados[6].trim()
                            .replaceAll("[^A-Z_]", "") 
                            .replace("INDEFINIDO", "NAO_INICIADO")
                            .replace("MAO_INICIADO", "NAO_INICIADO")
                            .replace("NAQ_INICIA00", "NAO_INICIADO");

                        if (!statusStr.matches("NAO_INICIADO|EM_ANDAMENTO|CONCLUIDO")) {
                            statusStr = "NAO_INICIADO";
                        }
                        tarefa.setStatus(List.of(Status.valueOf(statusStr)));

                        tarefa.setResponsavel(dados[7]);
                        tarefas.add(tarefa);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tarefas;
    }
}