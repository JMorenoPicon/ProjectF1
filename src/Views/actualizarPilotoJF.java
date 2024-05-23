package Views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ActualizarPilotoController;
import Controller.CrearPilotoController;
import Controller.VerEscuderiasController;
import Controller.VerPilotosController;
import lib.Escuderia;
import lib.Piloto;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class actualizarPilotoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElPiloto;
	private JTextField txtEditeLosCampos;
	private JTextField txtNombre;
	private JTextField txtDorsal;
	VerPilotosController verPilotos = new VerPilotosController();
	VerEscuderiasController verEscuderias = new VerEscuderiasController();
	CrearPilotoController actualizarPiloto = new CrearPilotoController();

	/**
	 * Create the frame.
	 */
	public actualizarPilotoJF() {
		setTitle("Editor de pilotos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				actualizarPilotoJF.this.dispose();
			}
		});
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		ArrayList<String> arrayPilotosLista = verPilotos.verNombrePilotos();
		if(arrayPilotosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay pilotos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayPilotosLista.toArray()));
		}
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		ArrayList<String> arrayEscuderiasLista = verEscuderias.verNombreEscuderias();
		if(arrayEscuderiasLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay escuderias, cree al menos una escuderia", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox_1.setModel(new DefaultComboBoxModel(arrayEscuderiasLista.toArray()));
		}
		comboBox_1.setBounds(416, 37, 228, 22);
		contentPane.add(comboBox_1);
		
		txtDorsal = new JTextField();
		txtDorsal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtDorsal.getText().length() >= 2) {
					e.consume();
				}
			}
		});
		txtDorsal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDorsal.setText("");
			}
		});
		txtDorsal.setToolTipText("Dorsal");
		txtDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDorsal.setBounds(320, 79, 86, 20);
		contentPane.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setText("");
			}
		});
		txtNombre.setToolTipText("Nombre");
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(320, 38, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEditeLosCampos = new JTextField();
		txtEditeLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditeLosCampos.setEditable(false);
		txtEditeLosCampos.setText("Edite los campos necesarios");
		txtEditeLosCampos.setBounds(310, 11, 215, 20);
		contentPane.add(txtEditeLosCampos);
		txtEditeLosCampos.setColumns(10);
		
		comboBox.setBounds(51, 37, 239, 22);
		contentPane.add(comboBox);
		
		btnNewButton_1.setBounds(409, 343, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemPiloto;
				String itemEscuderia;
				itemPiloto = comboBox.getSelectedItem().toString();
				itemEscuderia = comboBox_1.getSelectedItem().toString();
				
				//Aqui tengo que coger los datos de los pilotos que pongo en los textbox y en el desplegable de la escuderia, guardarlos en variables y pasarselo al constructor de abajo
				String nombreNuevoPiloto = txtNombre.getText();
				String dorsal = txtDorsal.getText();
				Integer dorsalNumero = null;
				
				boolean res = actualizarPiloto.checkDorsal(dorsal); //LLamo a otro controlador porque la funcion que quiero comprobar es la misma
				if(res) {
					dorsalNumero = Integer.parseInt(dorsal);
					Piloto piloto = new Piloto(nombreNuevoPiloto, dorsalNumero);
					Escuderia escuderia = new Escuderia(itemEscuderia);
					new ActualizarPilotoController().actualizarPiloto(piloto, escuderia, itemPiloto);
					new pantallaInicioJF().setVisible(true);
					actualizarPilotoJF.this.dispose();
				}
				
				//Me falta por controlar el que no se introduzca un nombre en el cuadro de texto y se deje vacio. En crear piloto creo que tambien me pasa
			}
		});
		btnNewButton.setBounds(151, 343, 100, 23);
		contentPane.add(btnNewButton);
		
		txtSeleccioneElPiloto = new JTextField();
		txtSeleccioneElPiloto.setEditable(false);
		txtSeleccioneElPiloto.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneElPiloto.setText("Seleccione el piloto que desea actualizar");
		txtSeleccioneElPiloto.setBounds(51, 11, 243, 20);
		contentPane.add(txtSeleccioneElPiloto);
		txtSeleccioneElPiloto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenVerstappen.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);	
	}
}
