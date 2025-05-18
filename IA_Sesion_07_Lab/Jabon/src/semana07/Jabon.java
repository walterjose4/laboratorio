package semana07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Jabon extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jabon frame = new Jabon();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Jabon() {
		setTitle("Jabon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 47, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 47, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Palmolive Tripack", "Nivea Tripack", "Rexona Tripack", "Neko Tripack"}));
		cboMarca.setBounds(67, 8, 125, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(67, 33, 125, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 123);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//Declaración de variables
		double precio,impCompra,impDescuento,impPagar;
		int marca,cantPaquetes,cantLapiceros;
		//Entrada de datos
		marca=cboMarca.getSelectedIndex();
		cantPaquetes=Integer.parseInt(txtCantidad.getText());
		//Proceso de cálculo
		//Calculando el precio de cada marca
		if(marca==0) precio=5.2;
		else if(marca==1) precio=8.2;
		else if(marca==2) precio=6.5;
		else precio=7.4;
		//Calculando el importe de compra
		impCompra=cantPaquetes*precio;
		//Calculando el importe de descuento
		if(cantPaquetes>=18) impDescuento=0.125*impCompra;
		else if(cantPaquetes>=12) impDescuento=0.1*impCompra;
		else if(cantPaquetes>=6) impDescuento=0.075*impCompra;
		else impDescuento=0;
		//Calculando el importe a pagar
		impPagar=impCompra-impDescuento;
		//Calculando el obsequio de lapiceros
		if(cantPaquetes<12) cantLapiceros=2;
		else if(cantPaquetes<24) cantLapiceros=4;
		else if(cantPaquetes<36) cantLapiceros=1*cantPaquetes;
		else cantLapiceros=1*cantPaquetes;
		//Salida de resultados
		//imprimir impCompra,impDescuento,impPagar,cantLapiceros
		txtS.setText("Importe de la compra\t: S/. "+impCompra);
		txtS.append("\nImporte del descuento\t: S/. "+impDescuento);
		txtS.append("\nImporte a pagar\t: S/. "+impPagar);
		txtS.append("\nCantidad de lapiceros\t: "+cantLapiceros);
	}
}