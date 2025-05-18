package semana9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmDialogoConsultarLibro;
	private JMenuItem mntmDialogoListar;
	private JMenuItem mntmDialogoConfigurarObsequio;
	private JMenuItem mntmDialogoAcercadeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		mntmDialogoConsultarLibro = new JMenuItem("Consultar");
		mntmDialogoConsultarLibro.addActionListener(this);
		mnNewMenu_1.add(mntmDialogoConsultarLibro);
		
		mntmDialogoListar = new JMenuItem("Listar");
		mntmDialogoListar.addActionListener(this);
		mnNewMenu_1.add(mntmDialogoListar);
		
		mnNewMenu_2 = new JMenu("Configurar");
		menuBar.add(mnNewMenu_2);
		
		mntmDialogoConfigurarObsequio = new JMenuItem("Configurar obsequio");
		mntmDialogoConfigurarObsequio.addActionListener(this);
		mnNewMenu_2.add(mntmDialogoConfigurarObsequio);
		
		mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		
		mntmDialogoAcercadeTienda = new JMenuItem("Acerca de tienda");
		mntmDialogoAcercadeTienda.addActionListener(this);
		mnNewMenu_3.add(mntmDialogoAcercadeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmDialogoAcercadeTienda) {
			actionPerformedMntmDialogoAcercadeTienda(e);
		}
		if (e.getSource() == mntmDialogoConfigurarObsequio) {
			actionPerformedMntmDialogoConfigurarObsequio(e);
		}
		if (e.getSource() == mntmDialogoListar) {
			actionPerformedMntmDialogoListar(e);
		}
		if (e.getSource() == mntmDialogoConsultarLibro) {
			actionPerformedMntmDialogoConsultarLibro(e);
		}
	}
	protected void actionPerformedMntmDialogoConsultarLibro(ActionEvent e) {
		DialogoConsultarLibro d=new DialogoConsultarLibro();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmDialogoListar(ActionEvent e) {
		DialogoListar d=new DialogoListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmDialogoConfigurarObsequio(ActionEvent e) {
		DialogoConfigurarObsequio d=new DialogoConfigurarObsequio();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmDialogoAcercadeTienda(ActionEvent e) {
		DialogoAcercadeTienda d=new DialogoAcercadeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		System.exit(0);
	}
}
