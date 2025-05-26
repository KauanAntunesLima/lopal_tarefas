package br.dev.kauan.tarefas;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
import java.util.UUID;

import javax.swing.JLabel;

import br.dev.kauan.tarefas.dao.FuncionarioDAO;
import br.dev.kauan.tarefas.model.Funcionario;
import br.dev.kauan.tarefas.ui.FrameFuncionario;
import br.dev.kauan.tarefas.utils.Utils;

	public class Main {

		private static String path = "C:\\Users\\25132733\\tarefas.txt";

		public static void main(String[] args) {
			
			new FrameFuncionario();
			//Funcionario f = new Funcionario();
			 // f.setNome("Kauan Antunes");
			//f.setCargo("programador Junior");
			//f.setSalario(1989.73);
			
			//FuncionarioDAO dao = new FuncionarioDAO(f);
			//dao.gravar();
			
			
			UUID matriculaUUID = UUID.randomUUID();
			String matricula = matriculaUUID.toString();
			String matricula8 = matricula.substring(0, 8);
			System.out.println(Utils.gerarUUID8());
			System.out.println(matricula.toString());

			
		}

		private static void gravarArquivo() {
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(path, true);
				bw = new BufferedWriter(fw);

				String novaLinha = "Isso é uma nova linha!\n";
				String novaLinha1 = "Senai Jandira\n";
				String novaLinha2 = "Turma DS1TB\n";

				bw.write(novaLinha);
				bw.write(novaLinha1);
				bw.write(novaLinha2);
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
					System.out.println(" Nome:    " + registro[0]);
					System.out.println(" Tarefa:  " + registro[1]);


					
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



