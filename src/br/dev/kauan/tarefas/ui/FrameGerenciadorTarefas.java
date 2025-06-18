package br.dev.kauan.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameGerenciadorTarefas {
    
    private JLabel labelTitulo;
    private JButton btnFuncionarios;
    private JButton btnTarefas;
    
    public FrameGerenciadorTarefas() {
        JFrame frame = new JFrame("Gerenciador de Tarefas");
        criarTela(frame);
    }

    private void criarTela(JFrame tela) {
        tela.setTitle("Gerenciador de Tarefas");
        tela.setSize(400, 200);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tela.setLayout(null);
        tela.setLocationRelativeTo(null); // Centraliza na tela
        
        Container painel = tela.getContentPane();
        
        labelTitulo = new JLabel("Gerenciador de Tarefas");
        labelTitulo.setBounds(100, 20, 200, 25);    
        
        btnFuncionarios = new JButton("Funcionarios");
        btnFuncionarios.setBounds(80, 70, 110, 30);
        
        btnTarefas = new JButton("Tarefas");
        btnTarefas.setBounds(210, 70, 110, 30);
        
        painel.add(labelTitulo);
        painel.add(btnFuncionarios);
        painel.add(btnTarefas);
        
        btnFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameFuncionarioList();
            }
        });
        
        btnTarefas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameTarefasList(null);
            }
        });
        
        tela.setVisible(true);
    }
}
