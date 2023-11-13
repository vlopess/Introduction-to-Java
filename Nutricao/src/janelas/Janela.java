package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.ValorNaoPodeSerNegativoException;
import model.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frmCalculaImc;
	private JTextField textPeso;
	private JTextField textAltura;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frmCalculaImc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		initialize();
	}

	private void initialize() {
		frmCalculaImc = new JFrame();
		frmCalculaImc.setTitle("Calcula IMC");
		frmCalculaImc.setBounds(100, 100, 336, 235);
		frmCalculaImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculaImc.getContentPane().setLayout(null);
		
		JLabel lblDigiteOPeso = new JLabel("Digite o peso:");
		lblDigiteOPeso.setBounds(12, 29, 120, 15);
		frmCalculaImc.getContentPane().add(lblDigiteOPeso);
		
		textPeso = new JTextField();
		textPeso.setBounds(177, 27, 114, 19);
		frmCalculaImc.getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblDigiteAAltura = new JLabel("Digite a altura:");
		lblDigiteAAltura.setBounds(12, 72, 120, 15);
		frmCalculaImc.getContentPane().add(lblDigiteAAltura);
		
		textAltura = new JTextField();
		textAltura.setBounds(177, 70, 114, 19);
		frmCalculaImc.getContentPane().add(textAltura);
		textAltura.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				Pessoa pessoa;
				try {
					double peso = Double.parseDouble(textPeso.getText());
					double altura = Double.parseDouble(textAltura.getText());
					pessoa = new Pessoa(peso, altura);
					JOptionPane.showMessageDialog(btnCalcular, pessoa.getIMC());

				} catch (ValorNaoPodeSerNegativoException e) {
					JOptionPane.showMessageDialog(btnCalcular, "Não pode ser valor negativo");
					
				} catch (NumberFormatException nb) {
					JOptionPane.showMessageDialog(btnCalcular, "Digite os valores de peso e altura");
				}	
			}
		});
		btnCalcular.setBounds(102, 124, 117, 25);
		frmCalculaImc.getContentPane().add(btnCalcular);
	}
}
