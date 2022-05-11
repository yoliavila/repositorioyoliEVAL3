package gui;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.EventQueue;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import gui.Lugar;
import gui.Patrocinador;
import gui.Prueba;
import utils.ConexBD;
import utils.Utilidades;
import validaciones.Validaciones;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;public class NuevaPersona extends JFrame { private long id;
private String nombre;
private String telefono;
private LocalDate fechaNac;
private Documentacion nifnie;
private JTextField textField;
private JTextField txttelefono;
private JTextField txtnifnie;
private JTextField txtNombre;
private final ButtonGroup buttonGroupTipo = new ButtonGroup(); public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
NuevaPersona frame = new NuevaPersona();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
} public NuevaPersona() {
setTitle("Datos Personales");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
JPanel contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null); // parte nombre
JLabel lblNombre = new JLabel("Nombre *:");
lblNombre.setBounds(39, 30, 77, 14);
contentPane.add(lblNombre); txtNombre = new JTextField();
txtNombre.setBounds(102, 27, 261, 20);
contentPane.add(txtNombre);
txtNombre.setColumns(10); JLabel docu = new JLabel("introduzca el valor:");
docu.setBounds(39, 102, 108, 20);
contentPane.add(docu); txtnifnie = new JTextField();
txtnifnie.setBounds(143, 102, 123, 20);
contentPane.add(txtnifnie);
txtnifnie.setColumns(10); // telefono JLabel lbltelefono = new JLabel("telefono:");
lbltelefono.setBounds(43, 150, 55, 30);
contentPane.add(lbltelefono); txttelefono = new JTextField();
txttelefono.setBounds(108, 155, 123, 20);
contentPane.add(txttelefono);
txttelefono.setColumns(10); // fecha nacimiento JLabel lblFecha = new JLabel("Fecha *:");
lblFecha.setBounds(39, 63, 46, 14);
contentPane.add(lblFecha); JSpinner spinnerFecha = new JSpinner();
java.util.Date fechautil = new Date(2022 - 1900, 0, 1);
spinnerFecha.setModel(new SpinnerDateModel(fechautil, fechautil, null, Calendar.DAY_OF_YEAR));
spinnerFecha.setBounds(102, 58, 123, 20);
contentPane.add(spinnerFecha); JRadioButton nie = new JRadioButton("NIE");
nie.setBounds(129, 129, 43, 23);
contentPane.add(nie);
buttonGroupTipo.add(nie); JRadioButton nif = new JRadioButton("NIF");
nif.setBounds(69, 124, 43, 23);
contentPane.add(nif);
buttonGroupTipo.add(nif); JButton btnaceptar = new JButton("ACEPTAR");
btnaceptar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
DatosPersona nueva = new DatosPersona();
boolean valido = false;
String errores = "";
String nombre = txtNombre.getText();
valido = Validaciones.validarNombre(nombre);
if (!valido)
errores += "\nEl nombre no es valido."; String telefono = txttelefono.getText();
valido = Validaciones.validarTelefono(telefono);
if (!valido)
errores += "\nEl telefono no es valido."; java.util.Date fechaelegida = (Date) spinnerFecha.getValue();
LocalDate fechaLD = LocalDate.of(fechaelegida.getYear() + 1900, fechaelegida.getMonth() + 1,fechaelegida.getDate());
nueva.setFechaNac(fechaLD);
if(nif.isSelected() && nie.isSelected())
errores +="\n Solo se puede marcar uno de los 2:NIF o NIE";
else
if(!nif.isSelected() && !nie.isSelected())
errores +="\n Hay que marcar uno de los 2:NIF o NIE"; Documentacion doc;
if(nif.isSelected()) {
doc= new NIF(txtnifnie.getText());
valido = Validaciones.validarNIF(doc.mostrar());
}
else {
doc= new NIE(txtnifnie.getText());
valido = Validaciones.validarNIE(doc.mostrar());
}
}
});//
btnaceptar.setBounds(228, 227, 89, 23);
contentPane.add(btnaceptar); JButton btncancelar = new JButton("CANCELAR");
btncancelar.setBounds(327, 227, 89, 23);
contentPane.add(btncancelar); }
}

