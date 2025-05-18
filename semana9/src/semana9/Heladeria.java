package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Heladeria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cboHelado;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JLabel lblHelado;
	private JLabel lblCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Heladeria frame = new Heladeria();
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
	public Heladeria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboHelado = new JComboBox();
		cboHelado.setModel(new DefaultComboBoxModel(new String[] {"Sol", "Fresa", "Mar", "Rico"}));
		cboHelado.setBounds(87, 11, 136, 22);
		contentPane.add(cboHelado);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(87, 44, 43, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(302, 11, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(302, 43, 89, 23);
		contentPane.add(btnBorrar);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 85, 414, 165);
		contentPane.add(txtS);
		
		lblHelado = new JLabel("Helado");
		lblHelado.setBounds(10, 11, 67, 14);
		contentPane.add(lblHelado);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 47, 67, 14);
		contentPane.add(lblCantidad);
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
		int helado,cantidad,caramelos;
		double precio,impDescuento,impCompra,impPagar;
		//Entrada de datos
		helado=cboHelado.getSelectedIndex();
		cantidad=Integer.parseInt(txtCantidad.getText());
		//Proceso de cálculo
			//Cálculo del precio
			switch(helado)
			{	case 0: precio=2.5;break;
				case 1: precio=1.3;break;
				case 2: precio=2;break;
				default: precio=1.7;break;
			}
			//Cálculo importe de compra
			impCompra=precio*cantidad;
			//Cálculo del porcentaje de descuento
				 if(cantidad<10) impDescuento=0.05*impCompra;
			else if(cantidad<20) impDescuento=0.07*impCompra;
			else if(cantidad<30) impDescuento=0.09*impCompra;
			else				 impDescuento=0.11*impCompra;
			//Cálculo de importe a pagar
			impPagar=impCompra-impDescuento;
			//Cálculo del obsequio
			switch(helado)
			{	case 0: caramelos=1*cantidad;break;
				case 2: caramelos=2*cantidad;break;
				default: caramelos=6;break;
			}
		//Salida de resultados
		//imprimir impCompra,impDescuento,impPagar,caramelos
			txtS.setText("Importe de compra: S/"+impCompra);
			txtS.append("\nImporte de descuento: S/"+impDescuento);
			txtS.append("\nImporte a pagar: S/"+impPagar);
			txtS.append("\nCaramelos: "+caramelos);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboHelado.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
	}
}
