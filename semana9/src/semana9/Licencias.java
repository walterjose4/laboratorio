package semana9; 
import java.awt.EventQueue; 
import java.awt.Font; 
import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.UIManager; 
import javax.swing.JLabel; 
import javax.swing.JTextField; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; 
import javax.swing.JComboBox; 
import javax.swing.DefaultComboBoxModel; 
public class Licencias extends JFrame implements ActionListener { 
private static final long serialVersionUID = 1L; 
// Declaración de variables  
private JLabel lblTipo; 
private JLabel lblCantidad; 
private JComboBox<String> cboTipo; 
private JTextField txtCantidad; 
private JButton btnProcesar; 
private JButton btnBorrar; 
private JScrollPane scpScroll; 
private JTextArea txtS; 

 // Declaración de variables globales para el algoritmo 
 double imptot0, imptot1, imptot2, imptot3; 
 int canlic0, canlic1, canlic2, canlic3; 
 int canven0, canven1, canven2, canven3; 
 
 // Lanza la aplicación 
 public static void main(String[] args) { 
  try { 
 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
  } catch (Throwable e) { 
   e.printStackTrace(); 
  } 
   
  EventQueue.invokeLater(new Runnable() { 
   public void run() { 
    try { 
     Licencias frame = new Licencias(); 
     frame.setVisible(true); 
    } catch (Exception e) { 
     e.printStackTrace(); 
    } 
   } 
  }); 
 } 
 
 // Crea la GUI 
 public Licencias() { 
 
  setTitle("Licencias"); 
  setBounds(100, 100, 450, 449); 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  getContentPane().setLayout(null); 
 
  lblTipo = new JLabel("Tipo"); 
  lblTipo.setBounds(10, 13, 80, 14); 
  getContentPane().add(lblTipo); 
 
  lblCantidad = new JLabel("Cantidad"); 
  lblCantidad.setBounds(10, 38, 80, 14); 
  getContentPane().add(lblCantidad); 
 
  cboTipo = new JComboBox<String>(); 
  cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] { 
"Cobre", "Bronze", "Silver", "Gold" })); 
  cboTipo.setBounds(90, 10, 90, 20); 
  getContentPane().add(cboTipo); 
 
  txtCantidad = new JTextField(); 
  txtCantidad.setBounds(90, 35, 90, 20); 
  getContentPane().add(txtCantidad); 
  txtCantidad.setColumns(10); 
 
  btnProcesar = new JButton("Procesar"); 
  btnProcesar.addActionListener(this); 
  btnProcesar.setBounds(335, 9, 89, 23); 
  getContentPane().add(btnProcesar); 
 
  btnBorrar = new JButton("Borrar"); 
  btnBorrar.addActionListener(this); 
  btnBorrar.setBounds(335, 34, 89, 23); 
  getContentPane().add(btnBorrar); 
 
  scpScroll = new JScrollPane(); 
  scpScroll.setBounds(10, 69, 414, 331); 
  getContentPane().add(scpScroll); 
 
  txtS = new JTextArea(); 
  txtS.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
  scpScroll.setViewportView(txtS); 
 
 } 

 // Direcciona eventos de tipo ActionEvent 
 public void actionPerformed(ActionEvent arg0) { 
 
  if (arg0.getSource() == btnProcesar) { 
   actionPerformedBtnProcesar(arg0); 
  } 
   
  if (arg0.getSource() == btnBorrar) { 
   actionPerformedBtnBorrar(arg0); 
  } 
 } 
 
 // Procesa la pulsación del botón Procesar 
 protected void actionPerformedBtnProcesar(ActionEvent arg0) { 
 
  int tipo, cantidad; 
  double imppag; 
   
  tipo = getTipo(); 
  cantidad = getCantidad(); 
  imppag = calcularImportePagar(tipo, cantidad); 
   
  efectuarIncrementos(tipo, cantidad, imppag); 
  mostrarResultados(imppag); 
 
 } 
 
 // Procesa la pulsación del botón Borrar 
 protected void actionPerformedBtnBorrar(ActionEvent arg0) { 
  txtCantidad.setText(""); 
  txtS.setText(""); 
  txtCantidad.requestFocus(); 
 } 
 
 // Lee y retorna el tipo de licencia 
 int getTipo() { 
  return cboTipo.getSelectedIndex(); 
 } 
 
 // Lee y retorna la cantidad de licencias 
 int getCantidad() { 
  return Integer.parseInt(txtCantidad.getText()); 
 } 
 
 // Calcula y retorna el importe a pagar 
 double calcularImportePagar(int tip, int can) { 
  switch (tip) { 
  case 0: 
   return 510 * can; 
  case 1: 
   return 1500 * can; 
  case 2: 
   return 3100 * can; 
  default: 
   return 4500 * can; 
  } 
 } 
 
 // Efectúa los incrementos necesarios 
 void efectuarIncrementos(int tip, int can, double ip) { 
  switch (tip) { 
  case 0: 
   imptot0 += ip; 
   canlic0 += can; 
   canven0++; 
   break; 
  case 1: 
   imptot1 += ip; 
   canlic1 += can; 
   canven1++; 
   break; 

  case 2: 
   imptot2 += ip; 
   canlic2 += can; 
   canven2++; 
   break; 
  default: 
   imptot3 += ip; 
   canlic3 += can; 
   canven3++; 
  } 
 } 
 
 // Muestra el reporte solicitado 
 void mostrarResultados(double ip) { 
  txtS.setText(""); 
  imprimir("Importe a pagar...........: " + ip); 
  imprimir(""); 
  imprimir("Importe total recaudado"); 
  imprimir("- Por licencias Cobre....: " + imptot0); 
  imprimir("- Por licencias Bronze...: " + imptot1); 
  imprimir("- Por licencias Silver...: " + imptot2); 
  imprimir("- Por licencias Gold.....: " + imptot3); 
  imprimir(""); 
  imprimir("Cantidad de licencias vendidas"); 
  imprimir("- Por licencias Cobre....: " + canlic0); 
  imprimir("- Por licencias Bronze...: " + canlic1); 
  imprimir("- Por licencias Silver...: " + canlic2); 
  imprimir("- Por licencias Gold.....: " + canlic3); 
  imprimir(""); 
  imprimir("Cantidad de ventas efectuadas"); 
  imprimir("- Por licencias Cobre....: " + canven0); 
  imprimir("- Por licencias Bronze...: " + canven1); 
  imprimir("- Por licencias Silver...: " + canven2); 
  imprimir("- Por licencias Gold.....: " + canven3); 
 } 
 
 // Imprime una cadena con un salto de línea al final 
 void imprimir(String cad) { 
  txtS.append(cad + "\n"); 
 } 
}