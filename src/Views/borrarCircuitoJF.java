package Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.BorrarCircuitoController;
import Controller.VerCircuitosController;
import lib.Circuito;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class borrarCircuitoJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeleccioneElCircuito;
	VerCircuitosController verCircuitos = new VerCircuitosController();

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
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_1.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_1.setBackground(new Color(240, 240, 240));
			}
		});
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				borrarCircuitoJF.this.dispose();
			}
		});
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		ArrayList<String> arrayCircuitosLista = verCircuitos.verNombreCircuitos();
		if(arrayCircuitosLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay circuitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			comboBox.setModel(new DefaultComboBoxModel(arrayCircuitosLista.toArray()));
		}
		comboBox.setBounds(62, 51, 298, 22);
		contentPane.add(comboBox);
		
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
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(240, 240, 240));
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item;
				item = comboBox.getSelectedItem().toString();
				Circuito circuito = new Circuito(item);
				if(new BorrarCircuitoController().checkDelete(circuito)) {
					JOptionPane.showMessageDialog(null, "Circuito eliminado");
					
					new pantallaInicioJF().setVisible(true);
					borrarCircuitoJF.this.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error, intentelo de nuevo", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(366, 51, 92, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenCircuitoValencia.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}
}
