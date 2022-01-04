import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class Ajouter_affectation extends JFrame {
	Connection conn = DbConnection.connecterbd();
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField textField;
	java.sql.Date DateExam;
	int heure_fin;
	int heure_debut;
	static String module1;
	String prof;
	String surve1;
	String surve2;
	JDateChooser dateChooser;
	java.util.Date d;
	JComboBox comboBox_0;
	JComboBox comboBox_2;
	JComboBox comboBox_3;
	JSpinField spinField_1;
	JSpinField spinField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Ajouter_affectation frame = new Ajouter_affectation();
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
	public Ajouter_affectation() {
		DbConnection.connecterbd();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));

		lblNewLabel_0.setBounds(10, 24, 300, 75);
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(330, 47, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(947, 85, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));

		lblNewLabel_9.setBounds(937, 11, 100, 75);
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

		JComboBox comboBox2;
		String[] gestions = { "Gestion Module", "Gestion Salle", "Gestion Professeur", "Gestion Etudiant" };
		comboBox2 = new JComboBox(gestions);

		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox2.setBounds(124, 113, 139, 23);
				contentPane.add(comboBox2);
				comboBox2.setPopupVisible(true);
			}
		});

		btnNewButton_1.setBounds(124, 113, 139, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gestion des surveillances");

		JComboBox comboBox3;
		String[] affectations = { "Voir affectation", "Ajouter une affectation" };
		comboBox3 = new JComboBox(affectations);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox3.setBounds(254, 113, 190, 23);
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
		btnNewButton_2.setBounds(254, 113, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Demande_consultation_copie().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 113, 242, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Messagerie().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(839, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pv_annuel().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(938, 113, 111, 23);
		contentPane.add(btnNewButton_5);

		JLabel lblNewLabel = new JLabel("Module (ou \u00E9l\u00E9ment du module)");
		lblNewLabel.setBounds(56, 235, 207, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Professeur charger de l\u2019examen");
		lblNewLabel_1.setBounds(56, 303, 180, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Examinateur ou surveillant N01");
		lblNewLabel_2.setBounds(56, 366, 207, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Examinateur ou surveillant N02");
		lblNewLabel_3.setBounds(524, 235, 190, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Date de l\u2019examen");
		lblNewLabel_4.setBounds(524, 308, 163, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Heure de d\u00E9but");
		lblNewLabel_5.setBounds(611, 369, 132, 25);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Heure de fin d\u2019examen");
		lblNewLabel_6.setBounds(839, 371, 198, 20);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton1 = new JButton("Suivant");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				d = dateChooser.getDate();
				DateExam = new java.sql.Date(d.getTime());
				module1 = comboBox_0.getSelectedItem().toString();
				prof = textField.getText();
				surve1 = comboBox_2.getSelectedItem().toString();
				surve2 = comboBox_3.getSelectedItem().toString();
				heure_fin = (Integer) spinField_1.getValue();
				heure_debut = (Integer) spinField.getValue();
				String moduleIns = "INSERT INTO ajouter_affectation(Module, Prof, Surveillant1, Surveillant2, Date_exam, heure_debut, heure_fin) VALUES ('"
						+ module1 + "','" + prof + "','" + surve1 + "','" + surve2 + "','" + DateExam + "','"
						+ heure_debut + "','" + heure_fin + "')";
				try {

					ps.executeUpdate(moduleIns);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				new Etape2().setVisible(true);
			}
		});
		btnNewButton1.setBounds(938, 413, 90, 28);
		contentPane.add(btnNewButton1);

		comboBox_0 = new JComboBox();
		comboBox_0.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				try {
					String prof = "SELECT * FROM module inner join enseignant on CIN=CIN_enseignant WHERE nom_module=?";
					ps = conn.prepareStatement(prof);
					ps.setString(1, comboBox_0.getSelectedItem().toString());
					rs = ps.executeQuery();
					if (rs.next()) {
						textField.setText(rs.getString("Identifiant"));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
		comboBox_0.setBounds(298, 233, 146, 37);
		contentPane.add(comboBox_0);

		String module = "SELECT nom_module FROM module";
		try {
			ps = conn.prepareStatement(module);
			rs = ps.executeQuery();
			while (rs.next()) {
				comboBox_0.addItem(rs.getString("nom_module"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		textField = new JTextField();
		textField.setBounds(298, 298, 146, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(298, 360, 146, 37);
		contentPane.add(comboBox_2);

		String surv1 = "SELECT Identifiant FROM enseignant";
		try {
			ps = conn.prepareStatement(surv1);
			rs = ps.executeQuery();
			while (rs.next()) {
				comboBox_2.addItem(rs.getString("Identifiant"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(777, 227, 146, 37);
		contentPane.add(comboBox_3);

		String surv2 = "SELECT Identifiant FROM enseignant";
		try {
			ps = conn.prepareStatement(surv2);
			rs = ps.executeQuery();
			while (rs.next()) {
				comboBox_3.addItem(rs.getString("Identifiant"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		dateChooser = new JDateChooser();
		dateChooser.setBounds(853, 303, 70, 31);
		contentPane.add(dateChooser);

		spinField_1 = new JSpinField(0, 23);
		spinField_1.setBounds(791, 374, 30, 20);
		contentPane.add(spinField_1);

		spinField = new JSpinField(0, 23);
		spinField.setBounds(571, 374, 30, 20);
		contentPane.add(spinField);

		JButton btnNewButton_6 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_6.addMouseListener(new MouseAdapter() {
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
		contentPane.add(btnNewButton_6);
		btnNewButton_6.setBounds(680, 113, 163, 23);

	}
}
