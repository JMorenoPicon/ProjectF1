package Views;

import java.awt.Button;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class borrarCircuitoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElCircuito;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					borrarCircuitoJF frame = new borrarCircuitoJF();
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
	public borrarCircuitoJF() {
		setTitle("Editor de Circuitos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button_1 = new Button("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				borrarCircuitoJF.this.dispose();
			}
		});
		
		txtSeleccioneElCircuito = new JTextField();
		txtSeleccioneElCircuito.setText("Seleccione el circuito que desea eliminar");
		txtSeleccioneElCircuito.setToolTipText("");
		txtSeleccioneElCircuito.setEditable(false);
		txtSeleccioneElCircuito.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneElCircuito.setBounds(62, 25, 298, 20);
		contentPane.add(txtSeleccioneElCircuito);
		txtSeleccioneElCircuito.setColumns(10);
		button_1.setBounds(464, 51, 92, 22);
		contentPane.add(button_1);
		
		Button button = new Button("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(366, 51, 92, 22);
		contentPane.add(button);
		
		Choice choice = new Choice();
		choice.setBounds(62, 51, 298, 20);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCircuitoValencia.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}

}
