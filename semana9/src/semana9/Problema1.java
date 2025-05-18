package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
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
					Problema1 frame = new Problema1();
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
	public Problema1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBase = new JTextField();
		txtBase.setBounds(93, 11, 86, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(93, 35, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		lblNewLabel = new JLabel("Base");
		lblNewLabel.setBounds(10, 14, 57, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(10, 38, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(304, 10, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(304, 44, 89, 23);
		contentPane.add(btnBorrar);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 70, 398, 180);
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
		txtBase.setText("");
		txtAltura.setText("");
		txtBase.requestFocus();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaración de variables
		double base,altura,area;
		//Entrada de datos
		base=obtenerBase();
		altura=obtenerAltura();
		//Proceso de cálculo
		area=obtenerArea(base,altura);
		//Salida de resultados
		imprimirResultado(area);
		//Leer base
	}
	double obtenerBase() {
		double proceso;
		proceso = Double.parseDouble(txtBase.getText());
		return proceso;
	}
	double obtenerAltura() {
		double proceso;
		proceso=Double.parseDouble(txtAltura.getText());
		return proceso;
	}
	double obtenerArea(double base, double altura) {
		double proceso;
		proceso=base*altura;
		return proceso;
	}
	void imprimirResultado(double area) {
		txtS.setText("El área es: "+area);
	}
}
