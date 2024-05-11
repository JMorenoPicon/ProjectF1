package Views;

//import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

public class temporadaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField mensajeAviso;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					temporadaJF frame = new temporadaJF();
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
	public temporadaJF() {
		setTitle("Temporada");
		setIconImage(Toolkit.getDefaultToolkit().getImage(temporadaJF.class.getResource("/Views/Images/logoF1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagenFondoLbl = new JLabel("");
		imagenFondoLbl.setBounds(0, 0, 654, 405);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//logoF1.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(imagenFondoLbl.getWidth(), imagenFondoLbl.getHeight(), Image.SCALE_SMOOTH));
		imagenFondoLbl.setIcon(img);
		
		mensajeAviso = new JTextField();
		mensajeAviso.setEditable(false);
		mensajeAviso.setBackground(new Color(255, 255, 255));
		mensajeAviso.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeAviso.setText("Va a iniciar una nueva temporada de la Formula 1 con los siguientes datos.");
		mensajeAviso.setBounds(10, 25, 634, 20);
		mensajeAviso.setColumns(10);
		contentPane.add(mensajeAviso);
		
		JList list = new JList();
		list.setBackground(new Color(255, 255, 240));
		list.setBorder(new CompoundBorder());
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Piloto 1", "Piloto 2", "Piloto3 ", "Piloto 1", "Piloto 2", "Piloto3 ", "Piloto 1", "Piloto 2", "Piloto3 ", "Piloto 1", "Piloto 2", "Piloto3 ", "Piloto 1", "Piloto 2", "Piloto3 "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(74, 110, 86, 232);
		contentPane.add(list);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("Pilotos");
		textField_2.setBounds(74, 80, 86, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setText("Escuderias");
		textField_1.setBounds(279, 80, 86, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "5", "5", "45", "4", "2", "4", "24", "2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setToolTipText("");
		list_1.setBackground(new Color(255, 255, 240));
		list_1.setBounds(279, 111, 86, 231);
		contentPane.add(list_1);
		
		JList list_2 = new JList();
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "1", "2", "32", "", "1", "431", "", "41"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBackground(new Color(255, 255, 240));
		list_2.setBounds(475, 111, 86, 231);
		contentPane.add(list_2);
		
		textField = new JTextField();
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setText("Circuitos");
		textField.setBounds(475, 80, 86, 20);
		textField.setColumns(10);
		
		JButton BotonContinuar = new JButton("Continuar");
		BotonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonContinuar.setBackground(SystemColor.activeCaption);
		BotonContinuar.setBounds(181, 350, 89, 23);
		contentPane.add(BotonContinuar);
		
		JButton BotonAtras = new JButton("Atras");
		BotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				temporadaJF.this.dispose();	
			}
		});
		BotonAtras.setBackground(SystemColor.activeCaption);
		BotonAtras.setBounds(380, 350, 89, 23);
		contentPane.add(BotonAtras);
		
		contentPane.add(imagenFondoLbl);
	}

}
