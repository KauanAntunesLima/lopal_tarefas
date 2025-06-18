package br.dev.kauan.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.kauan.tarefas.dao.FuncionarioDAO;
import br.dev.kauan.tarefas.dao.TarefasDAO;
import br.dev.kauan.tarefas.model.Funcionario;
import br.dev.kauan.tarefas.model.Status;
import br.dev.kauan.tarefas.model.Tarefas;

public class FrameTarefas {

    private JLabel labelTitulo;
    private JTextField txtTitulo;
    private JLabel labelDescricao;
    private JTextField txtDescricao;
    private JLabel labelDataInicial;
    private JTextField txtDataIncial;
    private JLabel labelDataDeConclusao;
    private JTextField txtDataDeConclusao;
    private JLabel labelprazo;
    private JTextField txtprazo;
    private JLabel labelStatus;
    private JComboBox<Status> cmbStatus;
    private JLabel labelResponsavel;
    private JComboBox<String> cmbResponsavel;
    private JButton btnSalvar;
    private JButton btnSair;
    private JDialog tela;

    public FrameTarefas(JDialog dialog) {
        criarTela(dialog);
    }

    public void criarTela(JDialog dialog) {
        tela = new JDialog(dialog, true);
        tela.setTitle("Cadastro de Tarefas");
        tela.setSize(400, 600);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLayout(null);
        tela.setLocationRelativeTo(dialog);

        labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(10, 10, 200, 30);
        txtTitulo = new JTextField();
        txtTitulo.setBounds(10, 40, 365, 30);

        labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(10, 75, 200, 30);
        txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 105, 365, 30);

        labelDataInicial = new JLabel("Data Inicial:");
        labelDataInicial.setBounds(10, 140, 200, 30);
        txtDataIncial = new JTextField();
        txtDataIncial.setBounds(10, 170, 365, 30);

        labelprazo = new JLabel("Prazo:");
        labelprazo.setBounds(10, 205, 150, 30);
        txtprazo = new JTextField();
        txtprazo.setBounds(10, 235, 365, 30);

        labelDataDeConclusao = new JLabel("Data conclusão:");
        labelDataDeConclusao.setBounds(10, 265, 150, 30);
        txtDataDeConclusao = new JTextField();
        txtDataDeConclusao.setBounds(10, 295, 365, 30);

        labelStatus = new JLabel("Status:");
        labelStatus.setBounds(10, 325, 150, 30);
        this.cmbStatus = new JComboBox<>(Status.values());
        this.cmbStatus.setBounds(10, 355, 150, 30);
        this.cmbStatus.setSelectedItem(Status.NAO_INICIADO);

        labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(10, 385, 150, 30);
        this.cmbResponsavel = new JComboBox<>();
        this.cmbResponsavel.setBounds(10, 415, 150, 30);

        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> funcionarios = dao.listar();

        for (Funcionario f : funcionarios) {
            this.cmbResponsavel.addItem(f.getNome());
        }

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 465, 175, 40);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Tarefas tarefa = new Tarefas();
                    tarefa.setTitulo(txtTitulo.getText());
                    tarefa.setDescricao(txtDescricao.getText());
                    tarefa.setData(LocalDate.parse(txtDataIncial.getText()));
                    tarefa.setPrazo(Integer.parseInt(txtprazo.getText()));
                    tarefa.setResponsavel(cmbResponsavel.getSelectedItem().toString());
                    tarefa.setStatus(List.of((Status) cmbStatus.getSelectedItem()));
                    
                    new TarefasDAO(tarefa).gravar();
                    
                    limparFormulario();
                    JOptionPane.showMessageDialog(tela, "Tarefa salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar tarefa:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSair = new JButton("Sair");
        btnSair.setBounds(200, 465, 175, 40);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
            }
        });

        Container painel = tela.getContentPane();
        painel.add(labelTitulo);
        painel.add(txtTitulo);
        painel.add(labelDescricao);
        painel.add(txtDescricao);
        painel.add(labelDataInicial);
        painel.add(txtDataIncial);
        painel.add(labelprazo);
        painel.add(txtprazo);
        painel.add(labelDataDeConclusao);
        painel.add(txtDataDeConclusao);
        painel.add(labelStatus);
        painel.add(cmbStatus);
        painel.add(labelResponsavel);
        painel.add(cmbResponsavel);
        painel.add(btnSalvar);
        painel.add(btnSair);

        tela.setVisible(true);
    }

    private void limparFormulario() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtDataIncial.setText("");
        txtprazo.setText("");
        txtDataDeConclusao.setText("");
        txtTitulo.requestFocus();
    }
}