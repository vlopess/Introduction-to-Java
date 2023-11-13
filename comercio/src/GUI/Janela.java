package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DAO.DAOProduto;
import DAO.DAOProdutoPostgres;
import DAO.DaoVenda;
import DAO.DaoVendaPostgres;
import model.Produto;
import model.Venda;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DAOProduto daoProduto;
	private DaoVenda daovenda;
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textFieldQtd;
	private JTable table;


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
		
		

		this.daoProduto= new DAOProdutoPostgres();
		this.daovenda = new DaoVendaPostgres();


		JComboBox comboBoxProduto = new JComboBox();
		comboBoxProduto.setBounds(191, 41, 211, 24);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);		
		
		JPanel produtos = new JPanel();
		tabbedPane.addTab("Cadastrar Produtos", null, produtos, null);
		produtos.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(202, 52, 114, 19);
		produtos.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome:");
		lblDigiteONome.setBounds(76, 54, 108, 15);
		produtos.add(lblDigiteONome);
		
		textPreco = new JTextField();
		textPreco.setBounds(202, 106, 114, 19);
		produtos.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblDigiteOPreo = new JLabel("Digite o preço:");
		lblDigiteOPreo.setBounds(76, 108, 114, 15);
		produtos.add(lblDigiteOPreo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textNome.getText();
					double preco = Double.parseDouble(textPreco.getText());
					Produto produto = new Produto(nome, preco);		
					daoProduto.insertProduto(produto);
					textNome.setText("");
					textPreco.setText("");
					atualizarComboBoxProdutos(comboBoxProduto);
					JOptionPane.showMessageDialog(btnCadastrar, "O produto " + produto.getNome() +" foi adicionado com sucesso!");					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(btnCadastrar, "Ocorreu algum erro ao adicionar o produto.");
					e.printStackTrace();
				}catch (NumberFormatException nb) {
					JOptionPane.showMessageDialog(btnCadastrar, "Digite os valores");
				}	
			}			
		});
		btnCadastrar.setBounds(128, 167, 117, 25);
		produtos.add(btnCadastrar);
		JPanel vender = new JPanel();
		tabbedPane.addTab("Vender Produtos", null, vender, null);
		vender.setLayout(null);
		
		JLabel lblEscolhaOProduto = new JLabel("Escolha o produto:");
		lblEscolhaOProduto.setBounds(40, 46, 133, 15);
		vender.add(lblEscolhaOProduto);
		
		vender.add(comboBoxProduto);
		atualizarComboBoxProdutos(comboBoxProduto);

		
		JLabel lblDigiteAQuantidade = new JLabel("Digite a quantidade:");
		lblDigiteAQuantidade.setBounds(40, 107, 154, 15);
		vender.add(lblDigiteAQuantidade);
		
		textFieldQtd = new JTextField();
		textFieldQtd.setBounds(191, 105, 114, 19);
		vender.add(textFieldQtd);
		textFieldQtd.setColumns(10);
		
		JPanel vendas = new JPanel();
		tabbedPane.addTab("Vendas", null, vendas, null);
		vendas.setLayout(null);

		JList listPessoas = new JList();
		listPessoas.setBounds(0, 34, 425, 187);
		vendas.getRootPane().add(listPessoas);
		vendas.add(listPessoas);
        atualizarPainelVendasProdutos(listPessoas);
        
        JLabel lblProduto = new JLabel("Produto");
        lblProduto.setBounds(0, 12, 70, 15);
        vendas.add(lblProduto);
        
        JLabel lblQuantidadeDeVendas = new JLabel("Quantidade de Vendas");
        lblQuantidadeDeVendas.setBounds(135, 12, 162, 15);
        vendas.add(lblQuantidadeDeVendas);
        
        JLabel lblValorTotal = new JLabel("Valor Total");
        lblValorTotal.setBounds(336, 12, 77, 15);
        vendas.add(lblValorTotal);

		
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Produto p = (Produto) comboBoxProduto.getSelectedItem();
					int qtd = Integer.parseInt(textFieldQtd.getText());
					Venda venda = new Venda(qtd, p);
					daovenda.vender(venda);
					textFieldQtd.setText("");
			        atualizarPainelVendasProdutos(listPessoas);
					JOptionPane.showMessageDialog(btnVender, "A venda foi feita com sucesso!");					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(btnVender, "Ocorreu algum erro ao vender o produto.");
				}catch (NumberFormatException nb) {
					JOptionPane.showMessageDialog(btnVender, "Digite os valores");
				}	
			}
		});
		btnVender.setBounds(151, 167, 117, 25);
		vender.add(btnVender);
								         
	}

	private void atualizarPainelVendasProdutos(JList listPessoas) {
		try {
			listPessoas.removeAll();
			DefaultListModel<String> model= new DefaultListModel<String>();
			daovenda.getAllVendas().stream().forEach(p -> {
				model.addElement(p.getNomeProduto()+" ------------------------ "+p.getQuantidade()+" --------------------------- "+ p.getValortotal());
			});
			listPessoas.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void atualizarComboBoxProdutos(JComboBox comboBoxProduto) {
		try {
			comboBoxProduto.removeAllItems();
			daoProduto.getAllProdutos().stream().forEach(p -> comboBoxProduto.addItem(p));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(comboBoxProduto, "Ocorreu algum erro ao atualizar o combo box.");
			e.printStackTrace();
		}
	}
}
