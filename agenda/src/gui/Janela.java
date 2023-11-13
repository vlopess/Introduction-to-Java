package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoAgenda;
import dao.DaoAgendaPostgres;
import model.Pessoa;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DaoAgenda dao;

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
		this.dao = new DaoAgendaPostgres();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastrar", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 48, 45, 15);
		panel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(98, 46, 126, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 90, 70, 15);
		panel.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 88, 126, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consultar", null, panel_1, null);
		panel_1.setLayout(null);
		JList list = new JList();
		list.setBounds(0, 105, 339, 116);
		panel_1.add(list);

		atualizarLista(list);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					String tel = textField_1.getText();
					Pessoa pessoa = new Pessoa(nome, tel);
					dao.addPessoa(pessoa);
					JOptionPane.showMessageDialog(btnCadastrar, "Pessoa cadastrada com sucesso!");
					atualizarLista(list);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(btnCadastrar, "Digite algo!!");
				}
			}
		});
		btnCadastrar.setBounds(63, 155, 117, 25);
		panel.add(btnCadastrar);
		
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(42, 12, 50, 21);
		panel_1.add(lblNome_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 13, 114, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField_2.getText();
					Pessoa pessoa = dao.getPessoa(nome);
					if(pessoa == null) {
						JOptionPane.showMessageDialog(btnCadastrar, "Pessoa não encontrada!");						
					}else {
						JOptionPane.showMessageDialog(btnCadastrar, pessoa);						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(btnCadastrar, "Digite algo!!");
				}
			}			
		});
		
		btnBuscar.setBounds(68, 51, 117, 25);
		panel_1.add(btnBuscar);
		
		
		
		JLabel lblTodosOsContatos = new JLabel("Todos os Contatos:");
		lblTodosOsContatos.setBounds(48, 88, 176, 15);
		panel_1.add(lblTodosOsContatos);
	}

	private void atualizarLista(JList list) {
		list.removeAll();
		DefaultListModel<String> model= new DefaultListModel<String>();
		try {
			dao.getPessoas().stream().forEach(p -> {
				model.addElement(p.toString());		
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.setModel(model);
	}
}
