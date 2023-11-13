package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Coordenador;
import models.Pesquisador;
import models.Professor;
import models.ProjetoDePesquisa;

import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ProjetoDePesquisa pp;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

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
		this.pp = new ProjetoDePesquisa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNomeDoPesquisador = new JLabel("Nome do Pesquisador:");
		lblNomeDoPesquisador.setBounds(12, 23, 166, 15);
		panel_1.add(lblNomeDoPesquisador);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(136, 70, 42, 15);
		panel_1.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 65, 166, 24);
		panel_1.add(comboBox);
		comboBox.addItem("Professor");
		comboBox.addItem("Coordenador");
		
		textField = new JTextField();
		textField.setBounds(196, 21, 166, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCoordenador = new JLabel("Coordenador:");
		lblCoordenador.setBounds(80, 115, 98, 15);
		panel_1.add(lblCoordenador);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(196, 110, 166, 24);
		panel_1.add(comboBox_1);
		
		atualizarCoordenadores(comboBox_1);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Consulta", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNomeDoPesquisador_1 = new JLabel("Nome do Pesquisador:");
		lblNomeDoPesquisador_1.setBounds(12, 12, 170, 15);
		panel.add(lblNomeDoPesquisador_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(180, 7, 233, 24);
		panel.add(comboBox_2);
		atualizarPesquisadores(comboBox_2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				Coordenador coo = (Coordenador) comboBox_1.getSelectedItem();
				if(coo != null) {
					if(comboBox.getSelectedItem().equals("Professor")) {
						Pesquisador pessoa = new Professor(nome, coo);
						coo.addSupervisionado(pessoa);	
						pp.addPesquisador(pessoa);
					}else {
						Coordenador pessoa = new Coordenador(nome, coo);
						coo.addSupervisionado(pessoa);	
						pp.addPesquisador(pessoa);
						atualizarCoordenadores(comboBox_1);
					}
					atualizarPesquisadores(comboBox_2);
					JOptionPane.showMessageDialog(btnCadastrar, "Tudo Certo!");
				}else {
					JOptionPane.showMessageDialog(btnCadastrar, "Sla");
				}
				
			}
		});
		btnCadastrar.setBounds(61, 183, 117, 25);
		panel_1.add(btnCadastrar);

		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 154, 100, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 202, 100, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = comboBox_2.getSelectedItem().toString();
				Pesquisador pessoa = pp.findPesquisador(nome);
				textField_2.setText(""+pessoa.getQtdPesquisadores());
				textField_3.setText(pessoa.getValorPago()+"");							
			}
		});
		btnBuscar.setBounds(29, 53, 117, 25);
		panel.add(btnBuscar);
		
		JLabel lblQtdPesquisadores = new JLabel("Qtd Pesquisadores:");
		lblQtdPesquisadores.setBounds(12, 127, 153, 15);
		panel.add(lblQtdPesquisadores);
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(12, 185, 100, 15);
		panel.add(lblValorPago);
		
	
	}

	private void atualizarCoordenadores(JComboBox comboBox_1) {
		comboBox_1.removeAllItems();
		pp.getAllCoordenadores().stream().forEach(nome -> {
			comboBox_1.addItem(nome);			
		});
	}

	private void atualizarPesquisadores(JComboBox comboBox_1) {
		comboBox_1.removeAllItems();
		pp.getListaPesquisadores().stream().forEach(nome -> {
			comboBox_1.addItem(nome);			
		});
	}
}
