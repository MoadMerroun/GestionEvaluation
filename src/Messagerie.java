import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Messagerie extends JFrame {
	Connection conn = DbConnection.connecterbd();
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Messagerie frame = new Messagerie();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Messagerie() {
		DbConnection.connecterbd();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setBounds(10, 24, 300, 75);
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(330, 47, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(950, 86, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(940, 11, 100, 75);
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton = new JButton("Tableau de bord");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Tableau_bord().setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 113, 129, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Gestion ENSATE");
		btnNewButton_1.setBounds(127, 113, 139, 23);

		JComboBox comboBox2;
		String[] gestions = { "Gestion Module", "Gestion Salle", "Gestion Professeur", "Gestion Etudiant" };
		comboBox2 = new JComboBox(gestions);

		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox2.setBounds(127, 113, 139, 23);
				contentPane.add(comboBox2);
				comboBox2.setPopupVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gestion des surveillances");

		JComboBox comboBox3;
		String[] affectations = { "Voir affectation", "Ajouter une affectation" };
		comboBox3 = new JComboBox(affectations);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox3.setBounds(252, 113, 190, 23);
				contentPane.add(comboBox3);
				comboBox3.setPopupVisible(true);
				comboBox3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox3.getSelectedItem();
						dispose();
						if (selected.toString().equals("Voir affectation")) {
							new Voir_affectation().setVisible(true);
						} else if (selected.toString().equals("Ajouter une affectation")) {
							new Ajouter_affectation().setVisible(true);
						}
					}
				});
			}
		});
		btnNewButton_2.setBounds(252, 113, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Demande_consultation_copie().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 113, 249, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Messagerie().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(843, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pv_annuel().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(940, 113, 111, 23);
		contentPane.add(btnNewButton_5);

		JLabel lblNewLabel = new JLabel("A :");
		lblNewLabel.setBounds(88, 172, 54, 36);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 176, 72, 29);
		contentPane.add(comboBox);

		String filiere = "SELECT ID_filiere FROM filieres";
		try {
			ps = conn.prepareStatement(filiere);
			rs = ps.executeQuery();
			while (rs.next()) {
				comboBox.addItem(rs.getString("ID_filiere"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		JTextArea textArea = new JTextArea();
		textArea.setBounds(252, 235, 602, 142);
		contentPane.add(textArea);

		JButton btnNewButton_6 = new JButton("Envoyer");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filiere = comboBox.getSelectedItem().toString();

					String sql = "SELECT * FROM etudiant2 WHERE Filiere = '" + filiere + "'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						SendEmail.envoyerEmail(rs.getString("EmailInstitutionnel"),
								rs.getString("Prenom") + " " + rs.getString("Nom"), textArea.getText());
					}
					dispose();
					new Messagerie().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(507, 389, 89, 23);
		contentPane.add(btnNewButton_6);

		JLabel lblNewLabel_1 = new JLabel("Message ou notification :");
		lblNewLabel_1.setBounds(473, 206, 240, 28);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_7 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox4.setBounds(680, 113, 163, 23);
				contentPane.add(comboBox4);
				comboBox4.setPopupVisible(true);
				comboBox4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox4.getSelectedItem();
						dispose();
						if (selected.toString().equals("Voir prevention examens")) {
							new Voir_prevention_examens().setVisible(true);
						} else if (selected.toString().equals("Planifier examens")) {
							new Planifier_examens().setVisible(true);
						}
					}
				});
			}
		});
		contentPane.add(btnNewButton_7);
		btnNewButton_7.setBounds(680, 113, 163, 23);

	}
}
