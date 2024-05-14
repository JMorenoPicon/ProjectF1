package Views;

//import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.TemporadaController;
import Controller.VerCircuitosController;
import Controller.VerEscuderiasController;
import Controller.VerPilotosController;
import lib.Circuito;
import lib.Escuderia;
import lib.Piloto;
import lib.Temporada;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		mensajeAviso.setText("Va a iniciar una nueva temporada de la Formula 1");
		mensajeAviso.setBounds(10, 25, 634, 20);
		mensajeAviso.setColumns(10);
		contentPane.add(mensajeAviso);
		
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
				ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
				ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
				ArrayList<Escuderia> escuderias = new ArrayList<Escuderia>();
				
				VerCircuitosController verCircuitos = new VerCircuitosController();
				circuitos = verCircuitos.verAllCircuitos();
				
				VerPilotosController verPilotos = new VerPilotosController();
				pilotos = verPilotos.verAllPilotos();
				
				VerEscuderiasController verEscuderias = new VerEscuderiasController();
				escuderias = verEscuderias.verAllEscuderias();
				
				
				Temporada temporada = new Temporada(circuitos, escuderias, pilotos);
				
				TemporadaController temporadaController = new TemporadaController();//Aqui me quedo, tengo que editar temporadaController
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
