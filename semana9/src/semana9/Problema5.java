package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema5 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtMontoPrestamo;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema5 frame = new Problema5();
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
	public Problema5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Monto del pr\u00E9stamo");
		lblNewLabel.setBounds(10, 11, 105, 14);
		contentPane.add(lblNewLabel);
		
		txtMontoPrestamo = new JTextField();
		txtMontoPrestamo.setBounds(109, 8, 86, 20);
		contentPane.add(txtMontoPrestamo);
		txtMontoPrestamo.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(207, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(305, 7, 89, 23);
		contentPane.add(btnBorrar);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 35, 414, 215);
		contentPane.add(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//declaración de variables
		double montoPrestamo,tasaInteres,cuotaMensual,interesTotal;
		int cuotas;
		//entrada de datos
		montoPrestamo=obtenerMontoPrestamo();
		//proceso de cálculo
		cuotas=calculoCuotas(montoPrestamo);
		tasaInteres=calculoTasaInteres(montoPrestamo);
		interesTotal=calculoInteresTotal(montoPrestamo,tasaInteres,cuotas);
		cuotaMensual=calculoCuotaMensual(montoPrestamo,cuotas,tasaInteres);
		
		//salida de resultados
		imprimir(cuotas,tasaInteres,cuotaMensual,interesTotal);
	}
	double obtenerMontoPrestamo() {
		double montoPrestamo=Double.parseDouble(txtMontoPrestamo.getText());
		return montoPrestamo;
	}
	int calculoCuotas(double montoPrestamo) {
		int cuotas;
		if (montoPrestamo<5001) cuotas=2;
		else if (montoPrestamo<10001) cuotas=4;
		else if (montoPrestamo<15001) cuotas=6;
		else cuotas=10;
		return cuotas;
	}
	double calculoTasaInteres(double montoPrestamo) {
		double interes;
		if (montoPrestamo>10000) interes=0.03;
		else interes=0.05;
		return interes;
	}
	double calculoCuotaMensual(double montoPrestado, int cuotas, double tasaInteres) {
		double cuotaMensual;
		cuotaMensual=(montoPrestado+(montoPrestado*tasaInteres*cuotas));
		return cuotaMensual;
	}
	double calculoInteresTotal(double montoPrestado, double tasaInteres, int cuotas) {
		double interesTotal;
		interesTotal=montoPrestado*tasaInteres*cuotas;
		return interesTotal;
	}
	void imprimir(int cuotas, double tasaInteres, double cuotaMensual, double interesTotal) {
		txtS.setText("Número de cuotas\t: "+cuotas);
		txtS.append("\nTasa de interés\t: "+tasaInteres);
		txtS.append("\nCuota mensual\t: S/. "+cuotaMensual);
		txtS.append("\nInterés total\t: S/. "+interesTotal);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtMontoPrestamo.setText("");
		txtS.setText("");
		txtMontoPrestamo.requestFocus();
	}
}
