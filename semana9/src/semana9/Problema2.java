package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboTipo;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema2 frame = new Problema2();
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
	public Problema2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(313, 0, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(313, 27, 89, 23);
		contentPane.add(btnBorrar);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Primor", "Dulzura", "Tentaci\u00F3n", "Explosi\u00F3n"}));
		cboTipo.setBounds(100, 0, 113, 22);
		contentPane.add(cboTipo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 28, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 67, 394, 183);
		contentPane.add(txtS);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(10, 4, 66, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 31, 80, 14);
		contentPane.add(lblNewLabel_1);
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
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaración de variables
		int tipo,cantidad,caramelos;
		double impDescuento,impPagar,impCompra;
		//Entrada de datos
		tipo=leerTipo();
		cantidad=leerCantidad();
		//Proceso de cálculo
		impCompra=calculoImpCompra(tipo,cantidad);
		impDescuento=calculoImpDescuento(cantidad,impCompra);
		impPagar=calculoImpPagar(impCompra,impDescuento);
		caramelos=calculoCaramelos(impPagar,cantidad);
		//Salida de resultados
		imprimir(impCompra,impDescuento,impPagar,caramelos);
	}
	int leerTipo() {
		int calculo;
		calculo=cboTipo.getSelectedIndex();
		return calculo;
	}
	int leerCantidad() {
		int calculo;
		calculo=Integer.parseInt(txtCantidad.getText());
		return calculo;
	}
	double calculoImpCompra(int tipo,int cantidad) {
		double calculo;
		switch(tipo) {
		case 0: calculo=8.5*cantidad;break;
		case 1: calculo=10*cantidad;break;
		case 2: calculo=7*cantidad;break;
		default: calculo=12.5*cantidad;break;
		}
		return calculo;
	}
	double calculoImpDescuento(int cantidad, double impCompra) {
		double descuento;
		if (cantidad<5) descuento=0.04*impCompra;
		else if (cantidad<10) descuento=0.065*impCompra;
		else if (cantidad<15) descuento=0.09*impCompra;
		else                  descuento=0.115*impCompra;
		return descuento;
	}
	double calculoImpPagar(double impCompra, double impDescuento) {
		double impPagar;
		impPagar=impCompra-impDescuento;
		return impPagar;
	}
	int calculoCaramelos(double impPagar, int cantidad) {
		int calculo;
		if (impPagar>=250) calculo=3*cantidad;
		else               calculo=2*cantidad;
		return calculo;
	}
	void imprimir(double impCompra, double impDescuento, double impPagar, int caramelos) {
		txtS.setText("Importe de compra: S/"+impCompra);
		txtS.append("\nImporte de descuento: S/"+impDescuento);
		txtS.append("\nImporte de pago: S/"+impPagar);
		txtS.append("\nCaramelos: "+caramelos);
	}
}
