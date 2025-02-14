package Views;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ActualizarEscuderiaController;
import Controller.VerEscuderiasController;
import lib.Escuderia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Cursor;

public class actualizarEscuderiaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneLaEscudera;
	private JTextField txtNombre;
	private JTextField txtMotor;
	VerEscuderiasController verEscuderias = new VerEscuderiasController();


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
		
		ArrayList<String> arrayEscuderiasLista = verEscuderias.verNombreEscuderias();
		if(arrayEscuderiasLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay escuderias", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayEscuderiasLista.toArray()));
		}
		
		txtMotor = new JTextField();
		txtMotor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtMotor.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtMotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMotor.setText("");
			}
		});
		txtMotor.setToolTipText("Motor");
		txtMotor.setHorizontalAlignment(SwingConstants.CENTER);
		txtMotor.setBounds(208, 102, 86, 20);
		contentPane.add(txtMotor);
		txtMotor.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() >= 50) {
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
		txtNombre.setBounds(51, 102, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		
		comboBox.setBounds(51, 37, 243, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(240, 240, 240));
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemEscuderia;
				itemEscuderia = comboBox.getSelectedItem().toString();
				
				String nombreNuevoEscuderia = txtNombre.getText();
				String motorNuevo = txtMotor.getText();
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(240, 240, 240));
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
