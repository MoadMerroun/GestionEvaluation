import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tableau_bord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setBounds(100, 100, 1052, 517);
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
				setVisible(false);
				Tableau_bord tab = new Tableau_bord();
				tab.setVisible(true);
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
							setVisible(false);
							Voir_affectation voir_aff = new Voir_affectation();
							voir_aff.setVisible(true);
						} else if (selected.toString().equals("Ajouter une affectation")) {
							setVisible(false);
							Ajouter_affectation aj_aff = new Ajouter_affectation();
							aj_aff.setVisible(true);
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
				setVisible(false);
				Demande_consultation_copie demande = new Demande_consultation_copie();
				demande.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.setBounds(824, 141, 100, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Messagerie mssg = new Messagerie();
				mssg.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.setBounds(919, 141, 111, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Pv_annuel pv = new Pv_annuel();
				pv.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Voir prevention examens", "Planifier examens" };
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
							setVisible(false);
							Voir_prevention_examens voir_prev = new Voir_prevention_examens();
							voir_prev.setVisible(true);
						} else if (selected.toString().equals("Planifier examens")) {
							setVisible(false);
							Planifier_examens plan_exam = new Planifier_examens();
							plan_exam.setVisible(true);
						}
					}
				});
			}
		});
		contentPane.add(btnNewButton_6);
		btnNewButton_6.setBounds(668, 141, 159, 23);

		JLabel lblNewLabel = new JLabel("Tableau de bord");
		lblNewLabel.setBounds(22, 191, 132, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Taux de pr\u00E9sence des \u00E9tudiants au niveau de l\u2019examen:");
		lblNewLabel_1.setBounds(33, 346, 341, 35);
		contentPane.add(lblNewLabel_1);

		String[] Filieres = { "2AP1", "2AP2", "GI1", "GC1", "SCM1", "GM1", "GSTR1", "GI2", "GC2", "SCM2", "GM2",
				"GSTR2", "GI3", "GC3", "SCM3", "GM3", "GSTR3" };
		JComboBox comboBox = new JComboBox(Filieres);
		comboBox.setBounds(219, 408, 70, 23);
		contentPane.add(comboBox);

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
		JComboBox comboBox_1 = new JComboBox(modules);
		comboBox_1.setBounds(435, 407, 111, 25);
		contentPane.add(comboBox_1);

		String[] salles = { "Salle 001", "Salle 002", "Salle 003", "Salle 004", "Salle 005", "Salle 006", "Salle 101",
				"Salle 102", "Salle 103", "Salle 104", "Salle 105", "Salle 106", "Salle 201", "Salle 202", "Salle 203",
				"Salle 204", "Salle 205", "Salle 206",
		};
		JComboBox comboBox_2 = new JComboBox(salles);
		comboBox_2.setBounds(699, 408, 126, 22);
		contentPane.add(comboBox_2);

		JLabel lblNewLabel_4 = new JLabel("Modules");
		lblNewLabel_4.setBounds(320, 223, 140, 72);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cadres p\u00E9dagogiques");
		lblNewLabel_5.setBounds(531, 225, 190, 68);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Nombre des salles");
		lblNewLabel_6.setBounds(824, 228, 190, 63);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("Nombre des examens");
		lblNewLabel_2.setBounds(64, 225, 140, 68);
		contentPane.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 333, 1050, 2);
		contentPane.add(separator);

		textField = new JTextField();
		textField.setBounds(98, 283, 31, 23);
		textField.setText("3");
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(331, 283, 31, 23);
		textField_1.setText("8");
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(563, 283, 42, 22);
		textField_2.setText("3");
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(864, 283, 31, 22);
		textField_3.setText("7");
		contentPane.add(textField_3);
		textField_3.setColumns(10);

	}
}
