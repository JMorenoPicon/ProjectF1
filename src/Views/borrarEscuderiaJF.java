package Views;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BorrarEscuderiaController;
import Controller.VerEscuderiasController;
import lib.Escuderia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class borrarEscuderiaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneLaEscudera;
	VerEscuderiasController verEscuderias = new VerEscuderiasController();

	/**
	 * Create the frame.
	 */
	public borrarEscuderiaJF() {
		setTitle("Editor de Escuderias");
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
				borrarEscuderiaJF.this.dispose();
			}
		});
		
		JComboBox<String> comboBox = new JComboBox<String>();

		ArrayList<String> arrayEscuderiasLista = verEscuderias.verNombreEscuderias();
		if(arrayEscuderiasLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay escuderias", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayEscuderiasLista.toArray()));
		}
		comboBox.setBounds(62, 51, 298, 20);
		contentPane.add(comboBox);
		button_1.setBounds(464, 51, 92, 22);
		contentPane.add(button_1);
		
		Button button = new Button("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item;
				item = comboBox.getSelectedItem().toString();
				Escuderia escuderia = new Escuderia(item);
				new BorrarEscuderiaController().checkDelete(escuderia);
				
				new pantallaInicioJF().setVisible(true);
				borrarEscuderiaJF.this.dispose();
			}
		});
		button.setBounds(366, 51, 92, 22);
		contentPane.add(button);
		
		txtSeleccioneLaEscudera = new JTextField();
		txtSeleccioneLaEscudera.setEditable(false);
		txtSeleccioneLaEscudera.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneLaEscudera.setText("Seleccione la escudería que desea borrar");
		txtSeleccioneLaEscudera.setBounds(62, 25, 298, 20);
		contentPane.add(txtSeleccioneLaEscudera);
		txtSeleccioneLaEscudera.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCras2.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}
}
