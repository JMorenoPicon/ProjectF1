package Views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ActualizarEscuderiaController;
import Controller.CrearEscuderiaController;
import Controller.VerEscuderiasController;
import lib.Escuderia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class actualizarEscuderiaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneLaEscudera;
	private JTextField txtNombre;
	private JTextField txtMotor;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					actualizarEscuderiaJF frame = new actualizarEscuderiaJF();
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
	public actualizarEscuderiaJF() {
		setTitle("Editor de escuderías");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		VerEscuderiasController verEscuderias = new VerEscuderiasController();
		ArrayList<String> arrayEscuderiasLista = verEscuderias.verNombreEscuderias();
		if(arrayEscuderiasLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay escuderias", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayEscuderiasLista.toArray()));
		}
		
		txtMotor = new JTextField();
		txtMotor.setHorizontalAlignment(SwingConstants.CENTER);
		txtMotor.setText("Motor");
		txtMotor.setBounds(208, 102, 86, 20);
		contentPane.add(txtMotor);
		txtMotor.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(51, 102, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		
		comboBox.setBounds(51, 37, 243, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemEscuderia;
				itemEscuderia = comboBox.getSelectedItem().toString();
				
				String nombreNuevoEscuderia = txtNombre.getText();
				String motorNuevo = txtMotor.getText();
				
//				CrearEscuderiaController actualizarEscuderia = new CrearEscuderiaController();//LLamo a otro controlador porque la funcion que quiero comprobar es la misma
				Escuderia escuderia = new Escuderia(nombreNuevoEscuderia, motorNuevo);
				new ActualizarEscuderiaController().actualizarEscuderia(escuderia, itemEscuderia);
				new pantallaInicioJF().setVisible(true);
				actualizarEscuderiaJF.this.dispose();
			}
		});
		btnNewButton.setBounds(300, 37, 100, 23);
		contentPane.add(btnNewButton);
		
		txtSeleccioneLaEscudera = new JTextField();
		txtSeleccioneLaEscudera.setText("Seleccione la escudería que desee actualizar");
		txtSeleccioneLaEscudera.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneLaEscudera.setEditable(false);
		txtSeleccioneLaEscudera.setColumns(10);
		txtSeleccioneLaEscudera.setBounds(51, 11, 243, 20);
		contentPane.add(txtSeleccioneLaEscudera);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				actualizarEscuderiaJF.this.dispose();
			}
		});
		btnNewButton_1.setBounds(410, 37, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenKick.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}
}
