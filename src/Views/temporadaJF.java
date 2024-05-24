package Views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Controller.TemporadaController;
import Controller.VerCircuitosController;
import Controller.VerEscuderiasController;
import Controller.VerPilotosController;
import lib.Circuito;
import lib.Escuderia;
import lib.Piloto;
import lib.ResultadoTemporada;
import lib.Temporada;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Cursor;

public class temporadaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	VerCircuitosController verCircuitos = new VerCircuitosController();
	TemporadaController temporadaController = new TemporadaController();
	VerPilotosController verPilotos = new VerPilotosController();
	VerEscuderiasController verEscuderias = new VerEscuderiasController();

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
		
		table = new JTable();
		table.setBounds(151, 123, 1, 1);
		table.setVisible(false);
		contentPane.add(table);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(259, 11, 211, 22);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		ArrayList<String> arrayCircuitosLista = verCircuitos.verNombreCircuitos();
		comboBox.setModel(new DefaultComboBoxModel(arrayCircuitosLista.toArray()));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 121, 634, 273);
		scrollPane.setVisible(false);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_2 = new JButton("Ver Carrera");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = comboBox.getSelectedItem().toString();
				
				ArrayList<Piloto> clasificacionCircuito = new ArrayList<Piloto>();
				clasificacionCircuito = temporadaController.leerCircuito(item);
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Posición");
				modelo.addColumn("Nombre");
				modelo.addColumn("Escuderia");
				modelo.addColumn("Puntos");
				int posicion = 0;
				for(var piloto : clasificacionCircuito){
					posicion += 1;
					Object[] fila = { posicion, piloto.getNombre(), piloto.getNombreEscuderia(), piloto.getPuntos()};
					modelo.addRow(fila);
				}
				table.setModel(modelo);
				
			}
		});
		btnNewButton_2.setBounds(480, 11, 152, 23);
		btnNewButton_2.setVisible(false);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Escuderias");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temporadaController.resetPuntosEscuderias();
				ArrayList<Escuderia> escuderias = new ArrayList<Escuderia>();
				escuderias = temporadaController.verResultadosEscuderias();
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Posición");
				modelo.addColumn("Nombre");
				modelo.addColumn("Motor");
				modelo.addColumn("Puntos");
				int posicion = 0;
				for(var escuderia : escuderias){
					posicion += 1;
					Object[] fila = { posicion, escuderia.getNombreEscuderia(), escuderia.getNombreMotor(), escuderia.getPuntos()};
					modelo.addRow(fila);
				}
				table.setModel(modelo);
				
			}
		});
		
		JButton btnNewButton = new JButton("Pilotos");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Piloto> clasificacionPilotos = new ArrayList<Piloto>();
				clasificacionPilotos = temporadaController.verClasificacionPilotos();
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Posición");
				modelo.addColumn("Nombre");
				modelo.addColumn("Escuderia");
				modelo.addColumn("Puntos");
				int posicion = 0;
				
				for(var piloto:clasificacionPilotos)
				{
					posicion += 1;
					Object[] fila = { posicion, piloto.getNombre(), piloto.getEscuderia().getNombreEscuderia(), piloto.getPuntos()};
					modelo.addRow(fila);
				}
				table.setModel(modelo);
			}
		});
		btnNewButton.setBounds(76, 97, 152, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		
		btnNewButton_1.setBounds(393, 97, 152, 23);
		btnNewButton_1.setVisible(false);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setText("Circuitos");
		textField.setBounds(475, 80, 86, 20);
		textField.setColumns(10);
		
		JButton BotonContinuar = new JButton("Continuar");
		BotonContinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BotonContinuar.setText("Nueva Temporada");
				btnNewButton.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				table.setVisible(true);
				scrollPane.setVisible(true);
				comboBox.setVisible(true);

				temporadaController.resetPuntosPilotos();
				temporadaController.resetPuntosEscuderias();
				
				ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
				ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
				ArrayList<Escuderia> escuderias = new ArrayList<Escuderia>();
				
				circuitos = verCircuitos.verAllCircuitos();
				
				pilotos = verPilotos.verAllPilotosTemporada();
				
				escuderias = verEscuderias.verAllEscuderias();
				
				Temporada temporada = new Temporada(circuitos, escuderias, pilotos);
				
				ResultadoTemporada resultado = temporadaController.simularTemporada(temporada);
				
				//resultado lo meto en la tabla y que aparezca en la vista
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Posición");
				modelo.addColumn("Nombre");
				modelo.addColumn("Escuderia");
				modelo.addColumn("Puntos");
				int posicion = 0;
				
				for(var piloto:resultado.getClasificacionFinalPilotos())
				{
					posicion += 1;
					Object[] fila = { posicion, piloto.getNombre(), piloto.getEscuderia().getNombreEscuderia(), piloto.getPuntos()};
					modelo.addRow(fila);
				}
				table.setModel(modelo);
			}
		});
		BotonContinuar.setBackground(SystemColor.activeCaption);
		BotonContinuar.setBounds(10, 11, 152, 23);
		contentPane.add(BotonContinuar);
		
		JButton BotonAtras = new JButton("Atras");
		BotonAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				temporadaJF.this.dispose();	
			}
		});
		BotonAtras.setBackground(SystemColor.activeCaption);
		BotonAtras.setBounds(10, 45, 152, 23);
		contentPane.add(BotonAtras);
		
		contentPane.add(imagenFondoLbl);
	}
}
