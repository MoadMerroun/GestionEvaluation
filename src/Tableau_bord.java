import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tableau_bord extends JFrame {
	Connection conn = DbConnection.connecterbd();
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	public void afficherNbExamens() {
		int c;
		String login = "SELECT count(Module) FROM ajouter_affectation";
		try {
			ps = conn.prepareStatement(login);
			rs = ps.executeQuery();
			if (rs.next()) {
				textField.setText(rs.getString("count(Module)"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void afficherNbModules() {
		int c;
		String login = "SELECT count(ID) FROM module";
		try {
			ps = conn.prepareStatement(login);
			rs = ps.executeQuery();
			if (rs.next()) {
				textField_1.setText(rs.getString("count(ID)"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void afficherNbProf() {
		int c;
		String login = "SELECT count(CIN) FROM enseignant";
		try {
			ps = conn.prepareStatement(login);
			rs = ps.executeQuery();
			if (rs.next()) {
				textField_2.setText(rs.getString("count(CIN)"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void afficherNbSalles() {
		int c;
		String login = "SELECT count(Id) FROM salles";
		try {
			ps = conn.prepareStatement(login);
			rs = ps.executeQuery();
			if (rs.next()) {
				textField_3.setText(rs.getString("count(Id)"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableau_bord frame = new Tableau_bord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tableau_bord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setBounds(10, 27, 300, 75);
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(320, 50, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(940, 88, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(930, 11, 100, 75);
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton = new JButton("Tableau de bord");
		btnNewButton.setBounds(0, 141, 129, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Tableau_bord().setVisible(true);
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Gestion ENSATE");
		btnNewButton_1.setBounds(120, 141, 139, 23);

		JComboBox comboBox2;
		String[] gestions = { "Gestion Module", "Gestion Salle", "Gestion Professeur", "Gestion Etudiant" };
		comboBox2 = new JComboBox(gestions);

		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox2.setBounds(129, 141, 139, 23);
				contentPane.add(comboBox2);
				comboBox2.setPopupVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gestion des surveillances");
		btnNewButton_2.setBounds(256, 141, 179, 23);

		JComboBox comboBox3;
		String[] affectations = { "Voir affectation", "Ajouter une affectation" };
		comboBox3 = new JComboBox(affectations);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox3.setBounds(256, 141, 179, 23);
				contentPane.add(comboBox3);
				comboBox3.setPopupVisible(true);
				comboBox3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox3.getSelectedItem();
						if (selected.toString().equals("Voir affectation")) {
							dispose();
							new Voir_affectation().setVisible(true);
						} else if (selected.toString().equals("Ajouter une affectation")) {
							dispose();
							new Ajouter_affectation().setVisible(true);
						}
					}
				});
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.setBounds(435, 141, 235, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Demande_consultation_copie().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.setBounds(824, 141, 100, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Messagerie().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.setBounds(919, 141, 111, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pv_annuel().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox4.setBounds(668, 141, 159, 23);
				contentPane.add(comboBox4);
				comboBox4.setPopupVisible(true);
				comboBox4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox4.getSelectedItem();
						if (selected.toString().equals("Voir prevention examens")) {
							dispose();
							new Voir_prevention_examens().setVisible(true);
						} else if (selected.toString().equals("Planifier examens")) {
							dispose();
							new Planifier_examens().setVisible(true);
						}
					}
				});
			}
		});
		contentPane.add(btnNewButton_6);
		btnNewButton_6.setBounds(668, 141, 159, 23);

		JLabel lblNewLabel = new JLabel("Tableau de bord");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 191, 237, 68);
		contentPane.add(lblNewLabel);

		String[] Filieres = { "2AP1", "2AP2", "GI1", "GC1", "SCM1", "GM1", "GSTR1", "GI2", "GC2", "SCM2", "GM2",
				"GSTR2", "GI3", "GC3", "SCM3", "GM3", "GSTR3" };

		String[] modules = { "Algèbre 1", " Analyse 1", " Physique 1", " Mécanique 1", " Informatique 1",
				" Langue et Communication 1", " Algèbre 2", " Analyse 2", " Physique 2", " Chimie",
				" Mathématiques Assistées par Ordinateur (MAO)", " Langue et Communication 2", " Algèbre 3",
				" Analyse 3", " Physique 3", " Mécanique 2", " Informatique 2", " Langue et Communication 3",
				" Analyse 4", " Mathématiques Appliquées", " Physique 4", " Electronique", " Management",
				" Langue et Communication 4", "Langues et Communication I", "Management I",
				"Probabilités, Statistiques et Calcul Stochastique", "Réseaux Informatiques I",
				"Systèmes d’Information et Bases de Données Relationnelles",
				"Théories des Graphes et Recherche Opérationnelle", "Électronique Numérique", "Programmation Web I",
				"Programmation C Avancé et Complexité", "Systèmes d’exploitation",
				"Théories des Langages et Compilation", "Architecture des Ordinateurs et Assembleur",
				"Modélisation et Programmation Objet", "Programmation Réseaux et Sécurité Informatique",
				"Réseaux informatique II", "Méthodologies et Génie Logiciel", "Langues et Communication II",
				"Management II", "Intelligence Artificielle", "Administration et Optimisation des BD",
				"Programmation web II", "Java Avancé", "Vision Artificielle",
				"Base de Données Relationnelle-Objet et Répartie", "Système d’Intégration et Progiciel",
				"Business Intelligence", "Urbanisation des Systèmes d’Information", "Programmation des Systèmes",
				"Technologies DotNet et JEE", "Langues et Communication III", "Management III" };

		String[] salles = { "Salle 001", "Salle 002", "Salle 003", "Salle 004", "Salle 005", "Salle 006", "Salle 101",
				"Salle 102", "Salle 103", "Salle 104", "Salle 105", "Salle 106", "Salle 201", "Salle 202", "Salle 203",
				"Salle 204", "Salle 205", "Salle 206",
		};

		JLabel lblNewLabel_4 = new JLabel("Modules");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(330, 277, 84, 72);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cadres p\u00E9dagogiques");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(517, 279, 202, 68);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Nombre des salles");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(797, 286, 190, 63);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("Nombre des examens");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 270, 208, 86);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(329, 360, 69, 51);
		textField_1.setText("8");
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(588, 360, 63, 51);
		textField_2.setText("3");
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(850, 360, 63, 51);
		textField_3.setText("7");
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(73, 360, 69, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		afficherNbExamens();
		afficherNbModules();
		afficherNbProf();
		afficherNbSalles();

	}
}
