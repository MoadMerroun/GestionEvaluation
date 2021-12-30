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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Demande_consultation_copie extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demande_consultation_copie frame = new Demande_consultation_copie();
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
	public Demande_consultation_copie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);
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
		lblNewLabel_8.setBounds(963, 74, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(953, 0, 100, 75);
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton = new JButton("Tableau de bord");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Tableau_bord tab = new Tableau_bord();
				tab.setVisible(true);
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
				comboBox3.setBounds(251, 113, 190, 23);
				contentPane.add(comboBox3);
				comboBox3.setPopupVisible(true);
				comboBox3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox3.getSelectedItem();
						if (selected.toString().equals("Voir affectation")) {
							dispose();
							Voir_affectation voir_aff = new Voir_affectation();
							voir_aff.setVisible(true);
						} else if (selected.toString().equals("Ajouter une affectation")) {
							dispose();
							Ajouter_affectation aj_aff = new Ajouter_affectation();
							aj_aff.setVisible(true);
						}
					}
				});
			}
		});
		btnNewButton_2.setBounds(251, 113, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Demande_consultation_copie demande = new Demande_consultation_copie();
				demande.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 113, 249, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Messagerie mssg = new Messagerie();
				mssg.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(860, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pv_annuel pv = new Pv_annuel();
				pv.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(958, 113, 111, 23);
		contentPane.add(btnNewButton_5);

		JLabel lblNewLabel = new JLabel("Filiere :");
		lblNewLabel.setBounds(80, 187, 72, 36);
		contentPane.add(lblNewLabel);

		String[] Filieres = { "2AP1", "2AP2", "GI1", "GC1", "SCM1", "GM1", "GSTR1", "GI2", "GC2", "SCM2", "GM2",
				"GSTR2", "GI3", "GC3", "SCM3", "GM3", "GSTR3" };
		JComboBox comboBox = new JComboBox(Filieres);
		comboBox.setBounds(137, 194, 70, 23);
		contentPane.add(comboBox);

		String column[] = { "Module (ou �l�ment du module)", "Num�ro apog�e", "Message", "R�ponse du professeur" };

		String data[][] = {
				{ "Mod�lisation UML et POO", "18325860", "Demande de consultation de copie", "Acceptation" },
				{ "Alg�bre 1", "1856890", "Demande de consultation de copie", "Refus" }
		};

		table = new JTable(data, column);
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(0, 262, 1069, 57);
		contentPane.add(scrollPane1);

		JButton btnNewButton_7 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Voir prevention examens", "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox4.setBounds(680, 113, 182, 23);
				contentPane.add(comboBox4);
				comboBox4.setPopupVisible(true);
				comboBox4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selected = comboBox4.getSelectedItem();
						if (selected.toString().equals("Voir prevention examens")) {
							dispose();
							Voir_prevention_examens voir_prev = new Voir_prevention_examens();
							voir_prev.setVisible(true);
						} else if (selected.toString().equals("Planifier examens")) {
							dispose();
							Planifier_examens plan_exam = new Planifier_examens();
							plan_exam.setVisible(true);
						}
					}
				});
			}
		});
		contentPane.add(btnNewButton_7);
		btnNewButton_7.setBounds(680, 113, 182, 23);
	}

}
