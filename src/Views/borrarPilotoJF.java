package Views;

import java.awt.EventQueue;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Controller.BorrarPilotoController;
import Controller.VerPilotosController;
import lib.Piloto;

import java.util.ArrayList;
import java.util.Arrays;

public class borrarPilotoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElPiloto;
	VerPilotosController verPilotos = new VerPilotosController();

	/**
	 * Create the frame.
	 */
	public borrarPilotoJF() {
		setTitle("Editor de pilotos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(0, 0, 654, 405);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCrash.jpeg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				borrarPilotoJF.this.dispose();
			}
		});
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		ArrayList<String> arrayPilotosLista = verPilotos.verNombrePilotos();
		if(arrayPilotosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay pilotos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayPilotosLista.toArray()));
		}
		comboBox.setBounds(87, 44, 129, 22);
		contentPane.add(comboBox);
		
		btnNewButton_1.setBounds(332, 44, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item;
				item = comboBox.getSelectedItem().toString();
				Piloto piloto = new Piloto(item);
				new BorrarPilotoController().checkDelete(piloto);
				
				new pantallaInicioJF().setVisible(true);
				borrarPilotoJF.this.dispose();
			}
		});
		btnNewButton.setBounds(222, 44, 100, 23);
		contentPane.add(btnNewButton);
		
		txtSeleccioneElPiloto = new JTextField();
		txtSeleccioneElPiloto.setEditable(false);
		txtSeleccioneElPiloto.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneElPiloto.setText("Seleccione el piloto que desea eliminar");
		txtSeleccioneElPiloto.setBounds(26, 21, 257, 20);
		contentPane.add(txtSeleccioneElPiloto);
		txtSeleccioneElPiloto.setColumns(10);
		
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
}