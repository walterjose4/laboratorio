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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Licencias2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cboLicencia;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scp;
	private JTextArea txtS;

	//Declaración variables globales
	double importeTotalRecaudado0,importeTotalRecaudado1,importeTotalRecaudado2,importeTotalRecaudado3;
	int cantidadLicenciasVendidas0,cantidadLicenciasVendidas1,cantidadLicenciasVendidas2,cantidadLicenciasVendidas3;
	int cantidadVentasEfectuadas0,cantidadVentasEfectuadas1,cantidadVentasEfectuadas2,cantidadVentasEfectuadas3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Licencias2 frame = new Licencias2();
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
	public Licencias2() {
		setTitle("Licencias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 36, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		cboLicencia = new JComboBox();
		cboLicencia.setModel(new DefaultComboBoxModel(new String[] {"Cobre", "Bronze", "Silver", "Gold"}));
		cboLicencia.setBounds(66, 7, 109, 22);
		contentPane.add(cboLicencia);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(66, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(317, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(317, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		scp = new JScrollPane();
		scp.setBounds(10, 73, 414, 188);
		contentPane.add(scp);
		
		txtS = new JTextArea();
		scp.setViewportView(txtS);
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
		int tipo,cantidad;
		double importePagar;
		//Entrada de datos
		tipo=getTipo();
		cantidad=getCantidad();
		importePagar=getImportePagar(tipo,cantidad);
		getIncrementos(tipo,importePagar,cantidad);
		mostrarResultados(importePagar);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboLicencia.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
	int getTipo() {
		return cboLicencia.getSelectedIndex();
	}
	int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	double getImportePagar(int tipo,int cantidad) {
		switch(tipo) {
		case 0: return 510*cantidad;
		case 1: return 1500*cantidad;
		case 2: return 3100*cantidad;
		default : return 4500*cantidad;
		}
	}
	void getIncrementos(int tipo, double importePagar, int cantidad) {
		switch(tipo) {
		case 0:
			importeTotalRecaudado0 += importePagar;
			cantidadLicenciasVendidas0 += cantidad;
			cantidadVentasEfectuadas0 ++;
			break;
		case 1:
			importeTotalRecaudado1 += importePagar;
			cantidadLicenciasVendidas1 += cantidad;
			cantidadVentasEfectuadas1 ++;
			break;
		case 2:
			importeTotalRecaudado2 += importePagar;
			cantidadLicenciasVendidas2 += cantidad;
			cantidadVentasEfectuadas2 ++;
			break;
		default:
			importeTotalRecaudado3 += importePagar;
			cantidadLicenciasVendidas3 += cantidad;
			cantidadVentasEfectuadas3 ++;
			break;
		}
	}
	void mostrarResultados(double importePagar) {
		txtS.setText("");
		imprimir("Importe a pagar:\t: S/"+importePagar);
		imprimir("");
		imprimir("Importe total recaudado");
		imprimir("-Por licencias Cobre\t:"+importeTotalRecaudado0);
		imprimir("-Por licencias Bronze\t:"+importeTotalRecaudado1);
		imprimir("-Por licencias Silver\t:"+importeTotalRecaudado2);
		imprimir("-Por licencias Gold\t:"+importeTotalRecaudado3);
		imprimir("");
		imprimir("Cantidad de licencias vendidas");
		imprimir("-Por licencias Cobre\t:"+cantidadLicenciasVendidas0);
		imprimir("-Por licencias Bronze\t:"+cantidadLicenciasVendidas1);
		imprimir("-Por licencias Silver\t:"+cantidadLicenciasVendidas2);
		imprimir("-Por licencias Gold\t:"+cantidadLicenciasVendidas3);
		imprimir("");
		imprimir("Cantidad de ventas efectuadas");
		imprimir("-Por licencias Cobre\t:"+cantidadVentasEfectuadas0);
		imprimir("Por licencias Bronze\t:"+cantidadVentasEfectuadas1);
		imprimir("Por licencias Silver\t:"+cantidadVentasEfectuadas2);
		imprimir("Por licencias Gold\t:"+cantidadVentasEfectuadas3);
	}
	void imprimir(String texto) {
		txtS.append(texto+"\n");
	}
}
