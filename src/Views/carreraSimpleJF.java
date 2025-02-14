package Views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.CarreraController;
import Controller.VerCircuitosController;
import lib.Circuito;
import lib.Piloto;
import lib.ResultadoCarrera;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Cursor;

public class carreraSimpleJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	VerCircuitosController verCircuitos = new VerCircuitosController();
	CarreraController carreraSimple = new CarreraController();
	VerCircuitosController verCircuitoController = new VerCircuitosController();

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
		ArrayList<String> arrayCircuitosLista = verCircuitos.verNombreCircuitos();
		if(arrayCircuitosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay circuitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayCircuitosLista.toArray()));
		}
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(240, 240, 240));
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
				String itemCircuito = comboBox.getSelectedItem().toString();
				Circuito nombreCircuito = new Circuito(itemCircuito);
				int vueltas = verCircuitoController.verVueltasCircuito(nombreCircuito.getNombre());
				Circuito circuito = new Circuito(itemCircuito, vueltas);
				pilotos = carreraSimple.obtenerPilotos();
				if(pilotos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay pilotos para competir, cree al menos uno", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}else {
					textField_1 = new JTextField();
					textField_1.setBounds(10, 78, 634, 37);
					textField_1.setEditable(false);
					contentPane.add(textField_1);
					textField_1.setColumns(10);

					
					table = new JTable();
					table.setBounds(10, 121, 634, 273);
					contentPane.add(table);
					
					
					ResultadoCarrera resultado = carreraSimple.correr(pilotos, circuito);
					String nombrePilotoVueltaRapida = resultado.getPiloto().getNombre();
					int vueltaRapida = resultado.getVueltaRapida();
					
					textField_1.setText(circuito.getNombre() +"\n" +nombrePilotoVueltaRapida +" Vuelta rápida en: nº " +vueltaRapida);
					
					DefaultTableModel modelo = new DefaultTableModel();
					modelo.addColumn("Posición");
					modelo.addColumn("Nombre");
					modelo.addColumn("Escuderia");
					modelo.addColumn("Puntos");
					int posicion = 0;
					
					for(var piloto:resultado.getPilotos())
					{
						posicion += 1;
						Object[] fila = { posicion, piloto.getNombre(), piloto.getEscuderia().getNombreEscuderia(), piloto.getPuntos()};
						modelo.addRow(fila);
					}
					table.setModel(modelo);
					
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(10, 121, 634, 273);
					contentPane.add(scrollPane);
				}
			}
		});
		btnNewButton.setBounds(555, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(240, 240, 240));
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
