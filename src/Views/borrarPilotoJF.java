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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import javax.swing.SwingConstants;

public class borrarPilotoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElPiloto;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					borrarPilotoJF frame = new borrarPilotoJF();
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
		btnNewButton_1.setBounds(332, 44, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(222, 44, 100, 23);
		contentPane.add(btnNewButton);
		
		Choice choice = new Choice();
		choice.setBounds(87, 47, 129, 20);
		contentPane.add(choice);
		
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