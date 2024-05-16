package Views;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ActualizarCircuitoController;
import Controller.CrearCircuitoController;
import Controller.VerCircuitosController;
import lib.Circuito;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class actualizarCircuitoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElCircuito;
	private JTextField txtEditeLosCampos;
	private JTextField txtNombre;
	private JTextField txtPais;
	private JTextField txtNVueltas;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					actualizarCircuitoJF frame = new actualizarCircuitoJF();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public actualizarCircuitoJF() {
		setTitle("Editor de circuitos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNVueltas = new JTextField();
		txtNVueltas.setToolTipText("Nº Vueltas");
		txtNVueltas.setBounds(512, 42, 86, 20);
		contentPane.add(txtNVueltas);
		txtNVueltas.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setToolTipText("Pais");
		txtPais.setBounds(416, 42, 86, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Nombre");
		txtNombre.setBounds(320, 42, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEditeLosCampos = new JTextField();
		txtEditeLosCampos.setEditable(false);
		txtEditeLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditeLosCampos.setText("Edite los campos necesarios");
		txtEditeLosCampos.setBounds(320, 11, 278, 20);
		contentPane.add(txtEditeLosCampos);
		txtEditeLosCampos.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		VerCircuitosController verCircuitos = new VerCircuitosController();
		ArrayList<String> arrayCircuitosLista = verCircuitos.verNombreCircuitos();
		if(arrayCircuitosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay circuitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayCircuitosLista.toArray()));
		}
		
		comboBox.setBounds(51, 37, 243, 22);
		contentPane.add(comboBox);
		
		txtSeleccioneElCircuito = new JTextField();
		txtSeleccioneElCircuito.setEditable(false);
		txtSeleccioneElCircuito.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneElCircuito.setText("Seleccione el circuito que desea actualizar");
		txtSeleccioneElCircuito.setBounds(51, 11, 243, 20);
		contentPane.add(txtSeleccioneElCircuito);
		txtSeleccioneElCircuito.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				actualizarCircuitoJF.this.dispose();
			}
		});
		btnNewButton_1.setBounds(409, 343, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemCircuito;
				itemCircuito = comboBox.getSelectedItem().toString();
				
				//Aqui tengo que coger los datos de los circuitos que pongo en los textbox y en el desplegable de la escuderia, guardarlos en variables y pasarselo al constructor de abajo
				String nombreNuevoCircuito = txtNombre.getText();
				String paisNuevoCircuito = txtPais.getText();
				String vueltas = txtNVueltas.getText();
				Integer numeroVueltas = null;
				
				CrearCircuitoController actualizarPiloto = new CrearCircuitoController();
				boolean res = actualizarPiloto.checkVueltas(vueltas); //LLamo a otro controlador porque la funcion que quiero comprobar es la misma
				if(res) {
					numeroVueltas = Integer.parseInt(vueltas);
					Circuito circuito = new Circuito(nombreNuevoCircuito, paisNuevoCircuito, numeroVueltas);
					if(new ActualizarCircuitoController().actualizarCircuito(circuito, itemCircuito)) {
						JOptionPane.showMessageDialog(null, "Circuito actualizado");
					new pantallaInicioJF().setVisible(true);
					actualizarCircuitoJF.this.dispose();
				}
				
				//Me falta por controlar el que no se introduzca un nombre en el cuadro de texto y se deje vacio. En crear circuito creo que tambien me pasa
				}else {
					JOptionPane.showMessageDialog(null, "Introduzca un numero de vueltas válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(151, 343, 100, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenEmiliaRomagna.png")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}

}
