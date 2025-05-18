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

public class Problema4 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextField txtObservaciones;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea txtS;
	private JTextField txtTardanza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema4 frame = new Problema4();
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
	public Problema4() {
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
		btnBorrar.setBounds(345, 24, 89, 23);
		contentPane.add(btnBorrar);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(151, 25, 86, 20);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		lblNewLabel = new JLabel("Minutos de tardanza");
		lblNewLabel.setBounds(0, 4, 112, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("N\u00FAmero de observaciones");
		lblNewLabel_1.setBounds(0, 28, 141, 14);
		contentPane.add(lblNewLabel_1);
		
		txtS = new JTextArea();
		txtS.setBounds(0, 53, 434, 208);
		contentPane.add(txtS);
		
		txtTardanza = new JTextField();
		txtTardanza.setBounds(151, 1, 86, 20);
		contentPane.add(txtTardanza);
		txtTardanza.setColumns(10);
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
		txtObservaciones.setText("");
		txtTardanza.setText("");
		txtS.setText("");
		txtTardanza.requestFocus();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaración de variables
		int tardanza,observaciones,puntajePuntualidad,puntajeRendimiento,puntajeTotal;
		double bonificacion;
		//Entrada de datos
		tardanza=obtenerTardanza();
		observaciones=obtenerObservaciones();
		//Proceso de cálculo
		puntajePuntualidad=obtenerPuntajePuntualidad(tardanza);
		puntajeRendimiento=obtenerPuntajeRendimiento(observaciones);
		puntajeTotal=obtenerPuntajeTotal(puntajePuntualidad,puntajeRendimiento);
		bonificacion=obtenerBonificacion(puntajeTotal);
		//Salida de resultados
		imprimir(puntajePuntualidad,puntajeRendimiento,puntajeTotal,bonificacion);
	}
	int obtenerTardanza() {
		int calculo;
		calculo=Integer.parseInt(txtTardanza.getText());
		return calculo;
	}
	int obtenerObservaciones() {
		int calculo;
		calculo=Integer.parseInt(txtObservaciones.getText());
		return calculo;
	}
	int obtenerPuntajePuntualidad(int tardanza) {
		int puntaje;
		if (tardanza==0) puntaje=10;
		else if(tardanza<3) puntaje=8;
		else if(tardanza<6) puntaje=6;
		else if(tardanza<10) puntaje=4;
		else                 puntaje=0;
		return puntaje;
	}
	int obtenerPuntajeRendimiento(int observaciones) {
		int puntaje;
		switch (observaciones) {
		case 0: puntaje=10; break;
		case 1: puntaje=8; break;
		case 2: puntaje=5; break;
		case 3: puntaje=1; break;
		default: puntaje=0;
		}
		return puntaje;
	}
	int obtenerPuntajeTotal(int puntajePuntualidad, int puntajeRendimiento) {
		return puntajePuntualidad + puntajeRendimiento;
	}
	double obtenerBonificacion(int puntajeTotal) {
		if (puntajeTotal<11) return 2.5*puntajeTotal;
		else if (puntajeTotal<14) return 5*puntajeTotal;
		else if (puntajeTotal<17) return 7.5*puntajeTotal;
		else if (puntajeTotal<20) return 10*puntajeTotal;
		else					  return 12.5*puntajeTotal;
	}
	void imprimir(int puntualidad, int rendimiento, int puntaje, double bonificacion) {
		txtS.setText("Puntaje por  puntualidad: "+puntualidad);
		txtS.append("\nPuntaje por rendimiento: "+rendimiento);
		txtS.append("\nPuntaje total\t: "+puntaje);
		txtS.append("\nBonificación\t: S/. "+bonificacion);
	}
}
