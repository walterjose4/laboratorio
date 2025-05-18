package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class problema3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboCategoria;
	private JTextField txtPromedio;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					problema3 frame = new problema3();
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
	public problema3() {
		setTitle("Universidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(345, 0, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(345, 21, 89, 23);
		contentPane.add(btnBorrar);
		
		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cboCategoria.setBounds(105, 0, 115, 22);
		contentPane.add(cboCategoria);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(105, 33, 44, 20);
		contentPane.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		lblNewLabel = new JLabel("Categor\u00EDa");
		lblNewLabel.setBounds(0, 0, 81, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Promedio");
		lblNewLabel_1.setBounds(0, 36, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		txtS = new JTextArea();
		txtS.setBounds(0, 61, 434, 200);
		contentPane.add(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		cboCategoria.setSelectedIndex(0);
		txtPromedio.setText("");
		txtPromedio.requestFocus();	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaración de variables
		int categoria,pensionActual;
		double promedio,descuento,nuevaPension;
		//Entrada de datos
		categoria=obtenerCategoria();
		promedio=obtenerPromedio();
		pensionActual=calculoPension(categoria);
		//Proceso de cálculo
		descuento=calculoDescuento(promedio,pensionActual);
		nuevaPension=calculoNuevaPension(pensionActual,descuento);
		//Salida de restultados
		//imprimir pensionActual,descuento,nuevaPension
		imprimir(pensionActual,descuento,nuevaPension);
	}
	int obtenerCategoria() {
		int calculo;
		calculo=cboCategoria.getSelectedIndex();
		return calculo;
	}
	double obtenerPromedio() {
		double calculo;
		calculo = Double.parseDouble(txtPromedio.getText());
		return calculo;
	}
	int calculoPension(int categoria) {
		int pension;
		switch(categoria) {
		case 0: pension=550; break;
		case 1: pension=500; break;
		case 2: pension=460; break;
		default: pension=400;
		}
		return pension;
	}
	double calculoDescuento(double promedio, int pensionActual) {
		double descuento;
		if (promedio<14) descuento=0;
		else if (promedio<16) descuento=0.1*pensionActual;
		else if (promedio<18) descuento=0.12*pensionActual;
		else                  descuento=0.15*pensionActual;
		return descuento;
	}
	double calculoNuevaPension(int pensionActual, double descuento) {
		double nuevaPension;
		nuevaPension=pensionActual-descuento;
		return nuevaPension;
	}
	void imprimir(int pensionActual,double descuento,double nuevaPension) {
		txtS.setText("Pensión actual: S/. "+pensionActual);
		txtS.append("\nDescuento\t: S/. "+descuento);
		txtS.append("\nNueva pensión\t: S/. "+nuevaPension);
	}
}
