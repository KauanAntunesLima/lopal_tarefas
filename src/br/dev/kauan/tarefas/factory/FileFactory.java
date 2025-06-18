package br.dev.kauan.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileFactory {
    private final String caminhoTarefas = Paths.get("ArquivosGerenciador", "tarefas.csv").toString();
    private final String caminhoFuncionarios = Paths.get("ArquivosGerenciador", "funcionarios.csv").toString();

    public FileFactory() throws IOException {
        // Cria a pasta se não existir
        File diretorio = new File("ArquivosGerenciador");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        // Cria os arquivos se não existirem
        criarArquivoSeNaoExistir(caminhoTarefas);
        criarArquivoSeNaoExistir(caminhoFuncionarios);
    }

    private void criarArquivoSeNaoExistir(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public BufferedWriter getBufferWriterTarefas() throws IOException {
        return new BufferedWriter(new FileWriter(caminhoTarefas, true));
    }

    public BufferedReader getBufferedReaderTarefas() throws IOException {
        return new BufferedReader(new FileReader(caminhoTarefas));
    }

    public BufferedWriter getBufferWriterFuncionarios() throws IOException {
        return new BufferedWriter(new FileWriter(caminhoFuncionarios, true));
    }

    public BufferedReader getBufferedReaderFuncionarios() throws IOException {
        return new BufferedReader(new FileReader(caminhoFuncionarios));
    }
}