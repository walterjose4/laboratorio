package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Libreria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Libreria frame = new Libreria();
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
	public Libreria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(22, 9, 74, 14);
		contentPane.add(lblNewLabel);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Standford", "Alpha", "Justus", "Lore"}));
		cboMarca.setBounds(106, 5, 148, 22);
		contentPane.add(cboMarca);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(301, 5, 89, 23);
		contentPane.add(btnProcesar);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(22, 37, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(106, 34, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(301, 33, 89, 23);
		contentPane.add(btnBorrar);
		
		txtS = new JTextArea();
		txtS.setBounds(5, 61, 424, 195);
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
		//Declaración de variables
		int marca,cantidad,lapiceros;
		double precio,impDescuento,impCompra,impPagar;
		//Entrada de datos
		marca=cboMarca.getSelectedIndex();
		cantidad=Integer.parseInt(txtCantidad.getText());
		//Proceso de cálculo
			//Cálculo de precio
			switch(marca)
			{	case 0: precio=4.85;break;
				case 1: precio=4.35;break;
				case 2: precio=3.5;break;
				default: precio=4.55;break;
			}
			//Cálculo del importe de compra
			impCompra=cantidad*precio;
			//Cálculo de importe de descuento
			if(cantidad<4) impDescuento=0.075*impCompra;
			else if(cantidad<6) impDescuento=0.095*impCompra;
			else if(cantidad<8) impDescuento=0.115*impCompra;
			else				impDescuento=0.135*impCompra;
			//Cálculo del importe a pagar
			impPagar=impCompra-impDescuento;
			//Cálculo de lapiceros de regalo
			switch(marca)
			{	case 0: lapiceros=5; break;
				case 1: lapiceros=4; break;
				case 2: lapiceros=3*cantidad; break;
				default: lapiceros=2*cantidad; break;
				
			}
		//Salida de resultados
		//imprimir impCompra,impDescuento,impPagar,lapiceros
		txtS.setText("Importe de compra:\t S/"+impCompra);
		txtS.append("\nImporte de descuento:\t S/"+impDescuento);
		txtS.append("\nImporte a pagar:\t S/"+impPagar);
		txtS.append("\nLapiceros:\t\t"+lapiceros);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("Importe de compra:");
	}
}
