package Views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CrearCircuitoController;
import lib.Circuito;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crearCircuitoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPas;
	private JTextField txtNVueltas;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					crearCircuitoJF frame = new crearCircuitoJF();
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
	public crearCircuitoJF() {
		setTitle("Editor de circuitos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String pais = txtPas.getText();
				String vueltasString = txtNVueltas.getText();
				
				CrearCircuitoController crearCircuito = new CrearCircuitoController();
					if(crearCircuito.checkVueltas(vueltasString)) {
						int vueltas = Integer.parseInt(txtNVueltas.getText());
						Circuito circuito = new Circuito(nombre, pais, vueltas);
						if(crearCircuito.checkRegistro(circuito)) {
							JOptionPane.showMessageDialog(null, "Circuito creado");
							new pantallaInicioJF().setVisible(true);
							crearCircuitoJF.this.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Vuelva a intentarlo", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Añada un número de vueltas válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
				
		});
		btnNewButton.setBounds(230, 51, 104, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				crearCircuitoJF.this.dispose();
			}
		});
		btnCancelar.setBounds(344, 51, 104, 23);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(126, 11, 417, 28);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setText("");
			}
		});
		txtNombre.setText("Nombre");
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() >= 50){
					e.consume();//Limitar caracteres
				}
			}
		});
		txtNombre.setToolTipText("Nombre Circuito");
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		txtPas = new JTextField();
		txtPas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPas.setText("");
			}
		});
		txtPas.setText("Pais");
		txtPas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPas.getText().length() >= 20){
					e.consume();//Limitar caracteres
				}
			}
		});
		txtPas.setToolTipText("Pais");
		txtPas.setColumns(10);
		panel.add(txtPas);
		
		txtNVueltas = new JTextField();
		txtNVueltas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNVueltas.setText("");
			}
		});
		txtNVueltas.setText("Vueltas");
		txtNVueltas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNVueltas.getText().length() >= 2){
					e.consume();//Limitar caracteres
				}
			}
		});
		txtNVueltas.setToolTipText("Nº Vueltas");
		panel.add(txtNVueltas);
		txtNVueltas.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCircuitoIfema.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}
}
