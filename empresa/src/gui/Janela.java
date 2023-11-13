package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Chefe;
import model.Empregado;
import model.Empresa;
import model.Pessoa;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Empresa empresa;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {

		this.empresa = new Empresa();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel cadastroPainel = new JPanel();
		tabbedPane.addTab("Cadastramento Funcionário", null, cadastroPainel, null);
		cadastroPainel.setLayout(null);

		JLabel lblNomeDoFuncionrio = new JLabel("Nome do Funcionário:");
		lblNomeDoFuncionrio.setBounds(12, 39, 154, 15);
		cadastroPainel.add(lblNomeDoFuncionrio);

		JLabel lblSuperior = new JLabel("Superior: ");
		lblSuperior.setBounds(12, 82, 70, 15);
		cadastroPainel.add(lblSuperior);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(94, 77, 234, 24);
		cadastroPainel.add(comboBox);

		atualizarChefes(comboBox);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 161, 70, 15);
		cadastroPainel.add(lblTipo);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(94, 156, 234, 24);
		cadastroPainel.add(comboBox_1);

		comboBox_1.addItem("Empregado");
		comboBox_1.addItem("Chefe");

		textField = new JTextField();
		textField.setBounds(171, 37, 157, 19);
		cadastroPainel.add(textField);
		textField.setColumns(10);

		JPanel consultaPainel = new JPanel();
		tabbedPane.addTab("Consultas", null, consultaPainel, null);
		consultaPainel.setLayout(null);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(148, 17, 189, 24);
		consultaPainel.add(comboBox_2);
		atualizarFuncionarios(comboBox_2);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				Chefe sup = (Chefe) comboBox.getSelectedItem();
				Pessoa pessoa;
				if (comboBox_1.getSelectedItem().equals("Empregado")) {
					pessoa = new Empregado(nome, sup);
				} else {
					pessoa = new Chefe(nome, sup);
				}
				sup.addSubordinado(pessoa);
				empresa.addFuncionarios(pessoa);
				atualizarChefes(comboBox);
				atualizarFuncionarios(comboBox_2);
				JOptionPane.showMessageDialog(btnCadastro, "Tudo Certo!");

			}
		});
		btnCadastro.setBounds(114, 245, 117, 25);
		cadastroPainel.add(btnCadastro);

		JLabel lblNewLabel = new JLabel("Nome Funionário:");
		lblNewLabel.setBounds(12, 22, 141, 15);
		consultaPainel.add(lblNewLabel);

		JLabel lblTipoDeConsulta = new JLabel("Tipo de Consulta:");
		lblTipoDeConsulta.setBounds(12, 65, 130, 15);
		consultaPainel.add(lblTipoDeConsulta);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(148, 60, 189, 24);
		consultaPainel.add(comboBox_3);

		comboBox_3.addItem("Superiores");
		comboBox_3.addItem("Subordinados");
		JLabel lblLista = new JLabel("Lista:");
		lblLista.setBounds(12, 92, 70, 15);
		consultaPainel.add(lblLista);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 119, 325, 142);
		consultaPainel.add(textPane);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = (Pessoa) comboBox_2.getSelectedItem();
				if (comboBox_3.getSelectedItem().equals("Superiores")) {
					p.getListaSuperiores().stream().forEach(item -> {
						System.out.println(item);
					});
				} else {
					p.getListaEmpregadosAssociados().stream().forEach(item -> {
						System.out.println(item);
					});
				}

				// System.out.println(p.getSuperior() == null ? "O funcinário não possue chefe"
				// : p.getSuperior());

			}
		});
		btnConsultar.setBounds(120, 271, 117, 25);
		consultaPainel.add(btnConsultar);
	}

	private void atualizarFuncionarios(JComboBox comboBox_2) {
		comboBox_2.removeAllItems();
		empresa.getFuncionarios().stream().forEach(item -> {
			comboBox_2.addItem(item);
		});
	}

	private void atualizarChefes(JComboBox comboBox) {
		comboBox.removeAllItems();
		empresa.getAllChefes().stream().forEach(item -> {
			comboBox.addItem(item);
		});
	}
}
