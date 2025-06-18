package br.dev.kauan.tarefas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.kauan.tarefas.dao.TarefasDAO;
import br.dev.kauan.tarefas.model.Tarefas;

public class FrameTarefasList {

    private JTable tabelaTarefas;
    private DefaultTableModel modelTarefas;
    private JScrollPane scrollTarefas;
    private JButton btnNovaTarefa;
    private JButton btnSair;
    private String[] colunas = {"CÓDIGO", "NOME", "RESPONSÁVEL"};

    private JDialog tela;

    public FrameTarefasList(JFrame frame) {
        criarTela(frame);
    }

    public void criarTela(JFrame frame) {

        tela = new JDialog(frame, true);
        tela.setSize(new Dimension(500, 420));
        tela.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        tela.setTitle("Lista de Tarefas");
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);

        modelTarefas = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaTarefas = new JTable(modelTarefas);
        tabelaTarefas.getTableHeader().setReorderingAllowed(false);
        scrollTarefas = new JScrollPane(tabelaTarefas);
        scrollTarefas.setBounds(10, 20, 460, 300);

        btnNovaTarefa = new JButton("Nova Tarefa");
        btnNovaTarefa.setBounds(10, 330, 180, 40);

        btnNovaTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de nova tarefa
                FrameTarefas novaTarefa = new FrameTarefas(tela);
                
                // Depois de fechar a tela de nova tarefa, recarrega a lista
                carregarTarefas();
            }
        });

        btnSair = new JButton("Sair");
        btnSair.setBounds(200, 330, 180, 40);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
            }
        });

        Container painel = tela.getContentPane();
        painel.add(scrollTarefas);
        painel.add(btnNovaTarefa);
        painel.add(btnSair);

        // Carregar tarefas quando abrir a tela
        carregarTarefas();

        tela.setVisible(true);
    }

    private void carregarTarefas() {
        // Limpar tabela
        modelTarefas.setRowCount(0);

        // Consultar tarefas no DAO
        TarefasDAO dao = new TarefasDAO();
        List<Tarefas> lista = dao.listar();

        // Adicionar tarefas na tabela
        for (Tarefas t : lista) {
            modelTarefas.addRow(new Object[] {
                t.getCodigo(),
                t.getTitulo(),
                t.getResponsavel()
            });
        }
    }
}
