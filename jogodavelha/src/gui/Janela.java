package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Tabuleiro;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnResetar;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<JComboBox> lista = new ArrayList<JComboBox>(); 
		
		JComboBox comboBox = new JComboBox();		
		comboBox.setBounds(40, 24, 48, 24);
		contentPane.add(comboBox);
		lista.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(122, 24, 48, 24);
		contentPane.add(comboBox_1);
		lista.add(comboBox_1);

		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(204, 24, 48, 24);
		contentPane.add(comboBox_2);
		lista.add(comboBox_2);

		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(40, 91, 48, 24);
		contentPane.add(comboBox_3);
		lista.add(comboBox_3);

		
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(122, 91, 48, 24);
		contentPane.add(comboBox_4);
		lista.add(comboBox_4);

		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(204, 91, 48, 24);
		contentPane.add(comboBox_5);
		lista.add(comboBox_5);

		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(40, 154, 48, 24);
		contentPane.add(comboBox_6);
		lista.add(comboBox_6);

		
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(122, 154, 48, 24);
		contentPane.add(comboBox_7);
		lista.add(comboBox_7);
		
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(204, 154, 48, 24);
		contentPane.add(comboBox_8);
		lista.add(comboBox_8);		
		init(lista);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox.disable();
				
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_1.disable();
			}
		});
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_2.disable();
			}
		});
		
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_3.disable();
			}
		});
		
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_4.disable();
			}
		});
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_5.disable();
			}
		});
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);				
				comboBox_6.disable();
			}
		});
		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_7.disable();
			}
		});
		comboBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar(lista);
				comboBox_8.disable();
			}
		});
		
		JLabel lblVencedor = new JLabel("Vencedor : ");
		lblVencedor.setBounds(12, 205, 85, 15);
		contentPane.add(lblVencedor);
		
		textField = new JTextField();
		textField.setBounds(115, 203, 134, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetar(lista);
			}
		});
		btnResetar.setBounds(83, 237, 117, 25);
		contentPane.add(btnResetar);
		btnResetar.setVisible(false);
	}
	private void resetar(ArrayList<JComboBox> lista) {
		for(JComboBox cb : lista) {
			cb.setSelectedItem("");
			cb.setEnabled(true);
		}
		textField.setText("");
		btnResetar.setVisible(false);
	}
	private void init(ArrayList<JComboBox> lista) {
		for(JComboBox cb : lista) {
			cb.addItem("");
			cb.addItem("X");
			cb.addItem("O");
		}
	}
	
	private void verificar(ArrayList<JComboBox> lista) {
		Tabuleiro tabuleiro = new Tabuleiro();
		
		ArrayList<String> position = new ArrayList<String>();
		
		for(int i = 0 ; i < 9 ; i++) {
 			position.add((String) lista.get(i).getSelectedItem());
 		}
		tabuleiro.verificarGanhador(position);
		if(tabuleiro.getWinner() != null) {
			textField.setText("O " +  tabuleiro.getWinner() +" venceu");	
			btnResetar.setVisible(true);			
		}
		
			
 		if(tabuleiro.partidaEncerrada()) {
 			textField.setText("Empate!");	
 			btnResetar.setVisible(true);
 		}
//		
	}
}
