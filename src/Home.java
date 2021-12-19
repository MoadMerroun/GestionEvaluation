import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Home {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Tableau_bord tableau = new Tableau_bord();
				tableau.setVisible(true);
			}
		});
		btnNewButton.setBounds(215, 307, 129, 23);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setBounds(127, 189, 117, 28);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(127, 250, 134, 28);
		frame.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(286, 254, 162, 20);
		frame.getContentPane().add(passwordField);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(286, 191, 162, 22);
		frame.getContentPane().add(textArea);

		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(scaleImage));

		lblNewLabel_2.setBounds(33, 27, 300, 75);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_3.setBounds(382, 50, 139, 28);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Administration");
		lblNewLabel_4.setBounds(232, 139, 129, 25);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
