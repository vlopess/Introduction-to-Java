package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoAutor;
import dao.DaoAutorPostgres;
import model.Autor;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private DaoAutor dao;

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
		this.dao = new DaoAutorPostgres();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 356);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel cadastropanel = new JPanel();
		tabbedPane.addTab("Cadastro", null, cadastropanel, null);
		cadastropanel.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome:");
		lblDigiteONome.setBounds(12, 45, 109, 15);
		cadastropanel.add(lblDigiteONome);
		
		textField = new JTextField();
		textField.setBounds(122, 43, 176, 19);
		cadastropanel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		JRadioButton rdbtnFemenino = new JRadioButton("Feminino");

		rdbtnMasculino.setBounds(65, 81, 96, 23);
		cadastropanel.add(rdbtnMasculino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 85, 39, 15);
		cadastropanel.add(lblSexo);
		
		rdbtnFemenino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnMasculino.isSelected())
					rdbtnMasculino.setSelected(false);
			}
		});
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnFemenino.isSelected())
					rdbtnFemenino.setSelected(false);
			}
		});
		rdbtnFemenino.setBounds(180, 81, 101, 23);
		cadastropanel.add(rdbtnFemenino);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				String sexo = null;
				if(rdbtnMasculino.isSelected()) {
					sexo = rdbtnMasculino.getText();
				}
				if(rdbtnFemenino.isSelected())
					sexo = rdbtnFemenino.getText();
				
				try {
					if(sexo == null)
						throw new NumberFormatException();
					Autor autor = new Autor(nome, sexo);
					dao.insertAutor(autor);
					JOptionPane.showMessageDialog(btnCadastrar, "Autor Cadastrado com Sucesso!");
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (NumberFormatException nf) {
					JOptionPane.showMessageDialog(btnCadastrar, "Preencha Todos os Dados!");
				}
				
					
			}
		});
		btnCadastrar.setBounds(97, 245, 117, 25);
		cadastropanel.add(btnCadastrar);
		
		JPanel consultapanel = new JPanel();
		tabbedPane.addTab("Consulta", null, consultapanel, null);
		consultapanel.setLayout(null);
		
		JLabel lblDigiteONome_1 = new JLabel("Digite o nome para buscar:");
		lblDigiteONome_1.setBounds(59, 12, 215, 15);
		consultapanel.add(lblDigiteONome_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 39, 114, 19);
		consultapanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeAutor = textField_1.getText();
				try {
					Autor autor = dao.getAutor(nomeAutor);
					if(autor == null)
						JOptionPane.showMessageDialog(btnBuscar, "Autor Não Conhecido!");
					JOptionPane.showMessageDialog(btnBuscar, autor);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(btnBuscar, "Digite o nome!");
				}
			}
		});
		btnBuscar.setBounds(95, 85, 117, 25);
		consultapanel.add(btnBuscar);
		
		JButton btnAllAutores = new JButton("Mostrar Todos os Autores");
		btnAllAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dao.getAutores().stream().forEach(autor -> {
						JOptionPane.showMessageDialog(btnAllAutores, autor);
					});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAllAutores.setBounds(37, 165, 237, 25);
		consultapanel.add(btnAllAutores);
	}
}
