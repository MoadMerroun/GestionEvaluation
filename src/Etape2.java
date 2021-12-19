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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.toedter.components.JSpinField;

public class Etape2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etape2 frame = new Etape2();
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
	public Etape2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));

		lblNewLabel_0.setBounds(10, 24, 300, 75);
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(330, 47, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(714, 87, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));

		lblNewLabel_9.setBounds(704, 11, 100, 75);
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
				comboBox2.setBounds(127, 113, 139, 23);
				contentPane.add(comboBox2);
				comboBox2.setPopupVisible(true);
			}
		});

		btnNewButton_1.setBounds(127, 113, 139, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gestion des surveillances");

		JComboBox comboBox3;
		String[] affectations = { "Voir affectation", "Ajouter une affectation" };
		comboBox3 = new JComboBox(affectations);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox3.setBounds(255, 113, 190, 23);
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
		btnNewButton_2.setBounds(255, 113, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Demande_consultation_copie demande = new Demande_consultation_copie();
				demande.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 113, 249, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Messagerie mssg = new Messagerie();
				mssg.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(838, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Pv_annuel pv = new Pv_annuel();
				pv.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(937, 113, 111, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton1 = new JButton("Suivant");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Etape2 etape = new Etape2();
				etape.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("Nombre des salles");
		lblNewLabel.setBounds(144, 229, 207, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Choisir les salles");
		lblNewLabel_1.setBounds(523, 225, 111, 28);
		contentPane.add(lblNewLabel_1);

		String[] salles = { "Salle 001", "Salle 002", "Salle 003", "Salle 004", "Salle 005", "Salle 006", "Salle 101",
				"Salle 102", "Salle 103", "Salle 104", "Salle 105", "Salle 106", "Salle 201", "Salle 202", "Salle 203",
				"Salle 204", "Salle 205", "Salle 206",
		};

		JList list = new JList(salles);
		list.setBounds(159, 285, 70, 42);
		contentPane.add(list);

		JScrollPane jsp = new JScrollPane(list);
		jsp.setBounds(693, 176, 111, 164);
		contentPane.add(jsp);

		JSpinField spinField = new JSpinField();
		spinField.setValue(1);
		spinField.setMinimum(1);
		spinField.setBounds(291, 229, 30, 20);
		contentPane.add(spinField);

		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JButton btnNewButton_6 = new JButton("Enregistrer");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Voir_affectation voir_aff = new Voir_affectation();
				voir_aff.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(439, 370, 129, 43);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Voir prevention examens", "Planifier examens" };
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
		contentPane.add(btnNewButton_7);
		btnNewButton_7.setBounds(680, 113, 163, 23);

	}
}
