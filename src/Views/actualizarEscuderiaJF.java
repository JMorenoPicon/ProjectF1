package Views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class actualizarEscuderiaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneLaEscudera;

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
		
		JButton btnNewButton = new JButton("Confirmar");
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
		
		Choice choice = new Choice();
		choice.setBounds(51, 37, 243, 20);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenKick.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}

}
