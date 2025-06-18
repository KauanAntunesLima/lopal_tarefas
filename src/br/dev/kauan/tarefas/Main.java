package br.dev.kauan.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.dev.kauan.tarefas.dao.FuncionarioDAO;
import br.dev.kauan.tarefas.model.Funcionario;
import br.dev.kauan.tarefas.ui.FrameFuncionario;
import br.dev.kauan.tarefas.ui.FrameFuncionarioList;
import br.dev.kauan.tarefas.ui.FrameGerenciadorTarefas;
import br.dev.kauan.tarefas.utils.Utils;

	public class Main {

		private static String path = "C:\\Users\\25132733\\tarefas.txt";

		public static void main(String[] args) {
			new FrameGerenciadorTarefas();
			
//			List<String> frutas = new ArrayList<String>();
//			frutas.add("banana");
//			frutas.add("melancia");
//			frutas.add("maçã");
//			frutas.add("uva");
//			frutas.add("ameixa");
//			frutas.add("melão");
//			
//			System.out.println(frutas);
			
			//new FrameFuncionario();
			
//			FuncionarioDAO dao = new FuncionarioDAO();
//			List<Funcionario> funcionarios = dao.listar();
//			
//			for(Funcionario f : funcionarios) {
//				System.out.println(f.getNome());
//				System.out.println(f.getCargo());
//				System.out.println("-------------");
//			}
			
			
			//Funcionario f = new Funcionario();
			 // f.setNome("Kauan Antunes");
			//f.setCargo("programador Junior");
			//f.setSalario(1989.73);
			
			//FuncionarioDAO dao = new FuncionarioDAO(f);
			//dao.gravar();

			
		}

		private static void gravarArquivo() {
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				fw = new FileWriter(path, true);
				bw = new BufferedWriter(fw);
				
				String novaLinha = "Isso é uma nova linha!!\n";
				bw.write(novaLinha);
				bw.flush();
				
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
			}

		}
		
		private static void lerArquivo() {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				
				String linha = br.readLine();
				
				while (linha != null) {
					String registro[] = linha.split(";");
					System.out.println("Nome: " + registro[0]);
					System.out.println("Tarefa " + registro[1]);
					System.out.println("---------------------");
					linha = br.readLine();
				}
				
			} catch (FileNotFoundException erro) {
				System.out.println(erro.getMessage());
			} catch (IOException erro) {
				System.out.println(erro.getMessage());
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
			}
		}

	}


