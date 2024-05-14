package Views;

//import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CarreraController;
import Controller.VerCircuitosController;
import lib.Carrera;
import lib.Circuito;
import lib.Piloto;
import lib.ResultadoCarrera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class carreraSimpleJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					carreraSimpleJF frame = new carreraSimpleJF();
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
	public carreraSimpleJF() {
		setTitle("Carrera Rápida");
		setIconImage(Toolkit.getDefaultToolkit().getImage(carreraSimpleJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		VerCircuitosController verCircuitos = new VerCircuitosController();
		ArrayList<String> arrayCircuitosLista = verCircuitos.verNombreCircuitos();
		if(arrayCircuitosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay circuitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayCircuitosLista.toArray()));
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 139, 634, 255);
		contentPane.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 78, 634, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		comboBox.setBounds(156, 10, 389, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("Seleccione el circuito");
		textField.setBounds(10, 11, 136, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CarreraController carreraSimple = new CarreraController();
				ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
				String itemCircuito = comboBox.getSelectedItem().toString();
				VerCircuitosController verCircuitoController = new VerCircuitosController();
				Circuito nombreCircuito = new Circuito(itemCircuito);
				int vueltas = verCircuitoController.verVueltasCircuito(nombreCircuito.getNombre());
				Circuito circuito = new Circuito(itemCircuito, vueltas);
				pilotos = carreraSimple.obtenerPilotos();
				if(pilotos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay pilotos para competir, cree al menos uno", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}else {
					Carrera carrera = new Carrera(pilotos, circuito);
					
					ResultadoCarrera resultado = carreraSimple.correr(pilotos, circuito);
					String clasificacion = resultado.getPilotos().toString();
					String nombrePilotoVueltaRapida = resultado.getPiloto().getNombre();
					int vueltaRapida = resultado.getVueltaRapida();
					
					textField_1.setText(circuito.getNombre() +"\n" +nombrePilotoVueltaRapida +" Vuelta rápida en: nº " +vueltaRapida);
					textArea.setText(clasificacion);
				}
			}
		});
		btnNewButton.setBounds(555, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				carreraSimpleJF.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(555, 44, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		lblNewLabel.setBackground(Color.WHITE);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCarrera.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
}
