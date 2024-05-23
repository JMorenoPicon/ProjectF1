package Views;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CrearEscuderiaController;
import lib.Escuderia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crearEscuderiaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMotor;
	CrearEscuderiaController crearEscuderia = new CrearEscuderiaController();

	/**
	 * Create the frame.
	 */
	public crearEscuderiaJF() {
		setTitle("Editor de escuderías");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				crearEscuderiaJF.this.dispose();
			}
		});
		btnCancelar.setBounds(446, 58, 104, 23);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreEscuderia = txtNombre.getText();
				String motor = txtMotor.getText();
				Escuderia escuderia = new Escuderia(nombreEscuderia, motor);
				if(crearEscuderia.checkRegistro(escuderia)) {
					JOptionPane.showMessageDialog(null, "Escudería creada");
					new pantallaInicioJF().setVisible(true);
					crearEscuderiaJF.this.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
				}
		});
		btnNewButton.setBounds(332, 58, 104, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(329, 11, 221, 28);
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
				if(txtNombre.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtNombre.setToolTipText("Nombre Escuderia");
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		txtMotor = new JTextField();
		txtMotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMotor.setText("");
			}
		});
		txtMotor.setText("Motor");
		txtMotor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtMotor.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtMotor.setToolTipText("Motor");
		txtMotor.setColumns(10);
		panel.add(txtMotor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenAudi.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}

}
