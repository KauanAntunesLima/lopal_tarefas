package br.dev.kauan.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.kauan.tarefas.factory.FileFactory;
import br.dev.kauan.tarefas.model.Funcionario;
import br.dev.kauan.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;

	public TarefaDAO() {
	}

	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(tarefa.toString());
			ff.getBufferedWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
	public List<Tarefa> listar() {
		List<Tarefa> tarefas = new ArrayList<>();
		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReader();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// extraindo uma linha do arquivo
				linha = br.readLine();

			
		}
		
	}
	
}


