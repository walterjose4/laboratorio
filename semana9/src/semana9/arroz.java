package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class arroz extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arroz frame = new arroz();
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
	public arroz() {
		setTitle("Arroz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 15, 60, 14);
		contentPane.add(lblMarca);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 47, 60, 14);
		contentPane.add(lblCantidad);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Coste\u00F1o", "Paisana del Norte", "Tropical Superior", "Norte\u00F1o Superior"}));
		cboMarca.setBounds(80, 11, 149, 22);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(80, 44, 60, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 78, 414, 172);
		contentPane.add(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(270, 11, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(270, 44, 89, 23);
		contentPane.add(btnBorrar);
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
		//Declaración de variables
		double impCompra,impDescuento,impPagar;
		int caramelos,gomitas,cantidad,marca;
		//Entrada de datos
		cantidad=Integer.parseInt(txtCantidad.getText());
		marca=cboMarca.getSelectedIndex();
		//Proceso de cálculo
			//Cálculo marca impCompra
			switch(marca)
			{	case 0:impCompra=14.5;break;
				case 1:impCompra=12.6;break;
				case 2:impCompra=10;break;
				default:impCompra=12.8;break;
			}
			//Cálculo importe de descuento
			if(cantidad>4) impDescuento=0.09*impCompra;
			else if(cantidad<7) impDescuento=0.11*impCompra;
			else if(cantidad<10) impDescuento=0.13*impCompra;
			else				impDescuento=0.15*impCompra;
			//Cálculo importe a pagar
			impPagar=impCompra-impDescuento;
			//Cálculo obsequio de caramelos
			switch(marca)
			{
				case 0: caramelos=3;break;
				case 1: caramelos=2;break;
				case 2: caramelos=2*cantidad;break;
				default: caramelos=1*cantidad;break;
			}
			//Cálculo obsequio de gomitas
			if (impPagar<50) gomitas=5;
			else if(impPagar<100) gomitas=10;
			else if(impPagar<150) gomitas=15;
			else				  gomitas=20;
		//Salida de resultados
		//imprimir impCompra,impDescuento,impPagar,caramelos,gomitas
			txtS.setText("Importe de compra: S/"+impCompra);
			txtS.append("\nImporte de descuento: S/"+impDescuento);
			txtS.append("\nImporte a pagar: S/"+impPagar);
			txtS.append("\nCantidad de caramelos de regalo: "+caramelos);
			txtS.append("\nCantidad de gomitas de regalo: "+gomitas);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
	}
}
