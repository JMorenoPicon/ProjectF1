package Views;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Controller.VerEscuderiasController;
import lib.Escuderia;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class verEscuderiasJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	VerEscuderiasController verEscuderias = new VerEscuderiasController();

	/**
	 * Create the frame.
	 */
	public verEscuderiasJF() {
		setTitle("Escuderias");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPilotoJF.class.getResource("/Views/Images/logoF1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pantallaInicioJF().setVisible(true);
				verEscuderiasJF.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Ver Escuderias");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Escuderia> listaEscuderias = new ArrayList<Escuderia>();
				listaEscuderias = verEscuderias.verAllEscuderias();
				
				table = new JTable();
				table.setBounds(10, 11, 644, 349);
				contentPane.add(table);
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Nombre");
				modelo.addColumn("Motor");
				
				for(var escuderia:listaEscuderias)
				{
					Object[] fila = {escuderia.getNombreEscuderia(),  escuderia.getNombreMotor()};
					modelo.addRow(fila);
				}
				table.setModel(modelo);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 11, 634, 349);
				contentPane.add(scrollPane);
				
			}
		});
		btnNewButton_1.setBounds(102, 371, 132, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.setBounds(409, 371, 132, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 654, 405);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("images//imagenEscuderias.jpg")); //Creamos el objeto imagen dandole la url relativa de la imagen 
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
	}
}
