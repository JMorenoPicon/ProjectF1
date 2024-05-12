package Views;

//import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class pantallaInicioJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					pantallaInicioJF frame = new pantallaInicioJF();
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
	public pantallaInicioJF() {
		setTitle("F1 Simulator");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaInicioJF.class.getResource("/Views/Images/logoF1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.info);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenu OpcionesPilotos = new JMenu("Opciones de Piloto");
		mnNewMenu.add(OpcionesPilotos);
		
		JMenuItem CrearPiloto = new JMenuItem("Crear piloto");
		CrearPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new crearPilotoJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesPilotos.add(CrearPiloto);
		
		JMenuItem BorrarPiloto = new JMenuItem("Borrar piloto");
		BorrarPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new borrarPilotoJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesPilotos.add(BorrarPiloto);
		
		JMenuItem ActualizarPiloto = new JMenuItem("Actualizar piloto");
		ActualizarPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new actualizarPilotoJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesPilotos.add(ActualizarPiloto);
		
		JMenuItem VerPilotos = new JMenuItem("Ver pilotos");
		VerPilotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new verPilotosJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesPilotos.add(VerPilotos);
		
		JMenu OpcionesEscuderias = new JMenu("Opciones de Escuderia");
		mnNewMenu.add(OpcionesEscuderias);
		
		JMenuItem CrearEscuderia = new JMenuItem("Crear escudería");
		CrearEscuderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new crearEscuderiaJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesEscuderias.add(CrearEscuderia);
		
		JMenuItem BorrarEscuderia = new JMenuItem("Borrar escudería");
		BorrarEscuderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new borrarEscuderiaJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesEscuderias.add(BorrarEscuderia);
		
		JMenuItem ActualizarEscuderia = new JMenuItem("Actualizar escudería");
		ActualizarEscuderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new actualizarEscuderiaJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesEscuderias.add(ActualizarEscuderia);
		
		JMenuItem VerEscuderias = new JMenuItem("Ver escuderías");
		VerEscuderias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new verEscuderiasJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesEscuderias.add(VerEscuderias);
		
		JMenu OpcionesCircuitos = new JMenu("Opciones de Circuito");
		mnNewMenu.add(OpcionesCircuitos);
		
		JMenuItem CrearCircuito = new JMenuItem("Crear circuito");
		CrearCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new crearCircuitoJF().setVisible(true); //crear vista crearCircuitoJF
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesCircuitos.add(CrearCircuito);
		
		JMenuItem BorrarCircuito = new JMenuItem("Borrar circuito");
		BorrarCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new borrarCircuitoJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesCircuitos.add(BorrarCircuito);
		
		JMenuItem ActualizarCircuito = new JMenuItem("Actualizar circuito");
		ActualizarCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new actualizarCircuitoJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesCircuitos.add(ActualizarCircuito);
		
		JMenuItem VerCircuitos = new JMenuItem("Ver circuitos");
		VerCircuitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new verCircuitosJF().setVisible(true); //crear vista verCircuitosJF
				pantallaInicioJF.this.dispose();
			}
		});
		OpcionesCircuitos.add(VerCircuitos);
		
		JMenu TemporadaMenu = new JMenu("Temporada");
		menuBar.add(TemporadaMenu);
		
		JMenuItem ComenzarTemporada = new JMenuItem("Nueva temporada");
		ComenzarTemporada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new temporadaJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		TemporadaMenu.add(ComenzarTemporada);
		
		JMenuItem ContinuarTemporada = new JMenuItem("Continuar temporada");
		ContinuarTemporada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new continuarTemporadaJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		TemporadaMenu.add(ContinuarTemporada);
		
		JMenuItem CarreraSimple = new JMenuItem("Carrera simple");
		CarreraSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new carreraSimpleJF().setVisible(true);
				pantallaInicioJF.this.dispose();
			}
		});
		TemporadaMenu.add(CarreraSimple);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ImagenFondolbl = new JLabel("");
		ImagenFondolbl.setBounds(0, 0, 654, 383);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//logoF1.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(ImagenFondolbl.getWidth(), ImagenFondolbl.getHeight(), Image.SCALE_SMOOTH));
		
		ImagenFondolbl.setIcon(img);
		contentPane.add(ImagenFondolbl);
		
		
	}
}
