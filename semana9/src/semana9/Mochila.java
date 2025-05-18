package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mochila extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboModelo;
	private JTextField txtCantidad;
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
					Mochila frame = new Mochila();
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
	public Mochila() {
		setTitle("Programa Mochila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Modelo");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Sherman", "Fague", "Aldo", "Suburban"}));
		GridBagConstraints gbc_cboModelo = new GridBagConstraints();
		gbc_cboModelo.insets = new Insets(0, 0, 5, 5);
		gbc_cboModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboModelo.gridx = 4;
		gbc_cboModelo.gridy = 1;
		contentPane.add(cboModelo, gbc_cboModelo);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		GridBagConstraints gbc_btnProcesar = new GridBagConstraints();
		gbc_btnProcesar.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcesar.gridx = 9;
		gbc_btnProcesar.gridy = 1;
		contentPane.add(btnProcesar, gbc_btnProcesar);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.gridx = 4;
		gbc_txtCantidad.gridy = 2;
		contentPane.add(txtCantidad, gbc_txtCantidad);
		txtCantidad.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar.gridx = 9;
		gbc_btnBorrar.gridy = 2;
		contentPane.add(btnBorrar, gbc_btnBorrar);
		
		txtS = new JTextArea();
		GridBagConstraints gbc_txtS = new GridBagConstraints();
		gbc_txtS.gridwidth = 10;
		gbc_txtS.insets = new Insets(0, 0, 0, 5);
		gbc_txtS.fill = GridBagConstraints.BOTH;
		gbc_txtS.gridx = 0;
		gbc_txtS.gridy = 3;
		contentPane.add(txtS, gbc_txtS);
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
		int chocolates,modelo,cantidad;
		double precio,impCompra,impDescuento,impPagar;
		//Entrada de datos
		modelo=cboModelo.getSelectedIndex();
		cantidad=Integer.parseInt(txtCantidad.getText());
		//Proceso de cálculo
			//Cálculo del importe de compra
			switch(modelo)
			{	case 0: precio=149.9;break;
				case 1: precio=89.9;break;
				case 2: precio=119.9;break;
				default: precio=174.9;break;
			}
			//Cálculo del importe de compra
			impCompra=precio*cantidad;
			//Cálculo del importe de descuento
				 if(cantidad<5) impDescuento=0*impCompra;
			else if(cantidad<7) impDescuento=0.05*impCompra;
			else if(cantidad<9) impDescuento=0.07*impCompra;
			else				impDescuento=0.09*impCompra;
			//Cálculo del importe a pagar
			impPagar=impCompra-impDescuento;
			//Cálculo del obsequio de chocolates
			if(impPagar<200) chocolates=0;
			else if(impPagar<500) chocolates=1*cantidad;
			else if(impPagar<700) chocolates=2*cantidad;
			else				  chocolates=3*cantidad;
		//Salida de resultados
		//imprimir impCompra,impDescuento,impPagar,chocolates
		txtS.setText("Importe de compra: S/"+impCompra);
		txtS.append("\nImporte de descuento: S/"+impDescuento);
		txtS.append("\nImporte a pagar: S/"+impPagar);
		txtS.append("\nChocolates de obsequio: "+chocolates);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("Presiona el botón procesar");
	}
}
