package br.dev.kauan.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.kauan.tarefas.factory.FileFactory;
import br.dev.kauan.tarefas.model.Funcionario;

public class FuncionarioDAO {

    private Funcionario funcionario;

    public FuncionarioDAO() {
    }

    public FuncionarioDAO(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void gravar() {
        BufferedWriter bw = null;
        try {
            FileFactory ff = new FileFactory();
            bw = ff.getBufferWriterFuncionarios();
            bw.write(funcionario.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        BufferedReader br = null;

        try {
            FileFactory ff = new FileFactory();
            br = ff.getBufferedReaderFuncionarios();

            // Pula cabeçalho se existir
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] dados = linha.split(",", -1); // -1 mantém campos vazios
                    
                    // Verifica se tem todos os campos necessários
                    if (dados.length >= 4) {
                        Funcionario f = new Funcionario();
                        f.setMatricula(dados[0]);
                        f.setNome(dados[1]);
                        f.setCargo(dados[2]);
                        
                        try {
                            f.setSalario(Double.parseDouble(dados[3]));
                        } catch (NumberFormatException e) {
                            f.setSalario(0.0); // Valor padrão se salário for inválido
                        }
                        
                        funcionarios.add(f);
                    }
                }
            }
            return funcionarios;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}