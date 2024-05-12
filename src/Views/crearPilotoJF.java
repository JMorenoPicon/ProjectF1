package Views;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import lib.*;
import Controller.*;
import javax.swing.JTextPane;

public class crearPilotoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDorsal;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					crearPiloto frame = new crearPiloto();
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
	public crearPilotoJF() {
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
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenAlonso.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				crearPilotoJF.this.dispose();
			}
		});
		btnNewButton_1.setBounds(526, 50, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombrePiloto = txtNombre.getText();
				String dorsal = txtDorsal.getText();
				Integer dorsalNumero = null;
				
				CrearPilotoController CrearPiloto = new CrearPilotoController();
				boolean res = CrearPiloto.checkDorsal(dorsal);
				if(res == true) {
					dorsalNumero = Integer.parseInt(dorsal);
					lib.Piloto piloto = new Piloto(nombrePiloto, dorsalNumero);
					if(CrearPiloto.checkRegistro(piloto)) {
						JOptionPane.showMessageDialog(null, "Piloto creado");
					}
				}
				
				
//				try {
//					dorsalNumero = Integer.parseInt(dorsal);
					
					
					
//				}catch(Exception ex) {
//					JOptionPane.showMessageDialog(null, "Por favor, introduzca un dorsal válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
//				}
			}
		});
		btnNewButton.setBounds(394, 50, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 11, 221, 28);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDorsal = new JTextField();
		txtDorsal.setText("Dorsal");
		panel.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
}
