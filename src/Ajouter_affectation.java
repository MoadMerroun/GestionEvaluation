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
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class Ajouter_affectation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_affectation frame = new Ajouter_affectation();
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
	public Ajouter_affectation() {
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
				setVisible(false);
				Tableau_bord tab = new Tableau_bord();
				tab.setVisible(true);
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
		btnNewButton_2.setBounds(254, 113, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Demande_consultation_copie demande = new Demande_consultation_copie();
				demande.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 113, 242, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Messagerie mssg = new Messagerie();
				mssg.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(839, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Pv_annuel pv = new Pv_annuel();
				pv.setVisible(true);
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
				setVisible(false);
				Etape2 etape = new Etape2();
				etape.setVisible(true);
			}
		});
		btnNewButton1.setBounds(938, 413, 90, 28);
		contentPane.add(btnNewButton1);

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

		JComboBox comboBox_0 = new JComboBox(modules);
		comboBox_0.setBounds(333, 233, 111, 25);
		contentPane.add(comboBox_0);

		String[] profs = { "Besri zineb", "Noureddine OUKASS", "Mohamed CHKOURI" };
		JComboBox comboBox_1 = new JComboBox(profs);
		comboBox_1.setBounds(298, 303, 146, 31);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox(profs);
		comboBox_2.setBounds(298, 360, 146, 37);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox(profs);
		comboBox_3.setBounds(777, 227, 146, 37);
		contentPane.add(comboBox_3);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(853, 303, 70, 31);
		contentPane.add(dateChooser);

		JSpinField spinField_1 = new JSpinField(0, 23);
		spinField_1.setBounds(791, 374, 30, 20);
		contentPane.add(spinField_1);

		JSpinField spinField = new JSpinField(0, 23);
		spinField.setBounds(571, 374, 30, 20);
		contentPane.add(spinField);

		JButton btnNewButton_6 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Voir prevention examens", "Planifier examens" };
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
		btnNewButton_6.setBounds(680, 113, 163, 23);

	}
}
