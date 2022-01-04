import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Planifier_examens extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtTp;
	private JTextField txtTp_1;
	private JTextField txtTp_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planifier_examens frame = new Planifier_examens();
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
	public Planifier_examens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setBounds(10, 24, 300, 75);
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(330, 47, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(951, 82, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(941, 11, 100, 75);
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
				comboBox3.setBounds(255, 113, 190, 23);
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
		btnNewButton_2.setBounds(255, 113, 190, 23);
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
		btnNewButton_4.setBounds(852, 113, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pv_annuel().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(950, 113, 111, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_9 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox4.setBounds(680, 113, 177, 23);
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
		contentPane.add(btnNewButton_9);
		btnNewButton_9.setBounds(680, 113, 177, 23);

		JButton btnNewButton_6 = new JButton("Importer les Plannings");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser f = new JFileChooser();
				int reponse = f.showSaveDialog(null);
				if (reponse == JFileChooser.APPROVE_OPTION) {
				}
			}
		});
		btnNewButton_6.setBounds(863, 170, 139, 23);
		contentPane.add(btnNewButton_6);

		String[] Filieres = { "2AP1", "2AP2", "GI1", "GC1", "SCM1", "GM1", "GSTR1", "GI2", "GC2", "SCM2", "GM2",
				"GSTR2", "GI3", "GC3", "SCM3", "GM3", "GSTR3" };

		String column[] = { "Module", "Date", "Horaire", "Professeur", "Salles" };

		String data[][] = {
				{ "Modélisation UML et POO", "16/ 11 / 2021", "09:00", "Besri zineb",
						"salle 204/ salle 205/ salle 206" },
				{ "Genie logiciel", "22/ 12 / 2021", "09:00", "Chkouri Mohammed",
						"salle 104/ salle 105/ salle 106" }
		};

		table = new JTable(data, column);
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(114, 260, 799, 60);
		contentPane.add(scrollPane1);

		JLabel lblNewLabel_1 = new JLabel("A!ecter les \u00E9tudiants aux salles :");
		lblNewLabel_1.setBounds(124, 370, 300, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("De l'etudiant");
		lblNewLabel_2.setBounds(209, 440, 111, 28);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("De l'etudiant");
		lblNewLabel_3.setBounds(209, 489, 85, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("De l'etudiant");
		lblNewLabel_4.setBounds(209, 537, 85, 32);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u00E0 l\u2019\u00E9tudiant :");
		lblNewLabel_5.setBounds(479, 438, 161, 32);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u00E0 l\u2019\u00E9tudiant :");
		lblNewLabel_6.setBounds(479, 484, 121, 39);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_10 = new JLabel("\u00E0 l\u2019\u00E9tudiant :");
		lblNewLabel_10.setBounds(479, 542, 100, 23);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("la salle :");
		lblNewLabel_11.setBounds(714, 444, 72, 21);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("la salle :");
		lblNewLabel_12.setBounds(714, 489, 61, 28);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("la salle :");
		lblNewLabel_13.setBounds(714, 542, 72, 23);
		contentPane.add(lblNewLabel_13);

		textField = new JTextField();
		textField.setText("01");
		textField.setBounds(301, 444, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("11");
		textField_1.setBounds(304, 493, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("21");
		textField_2.setBounds(304, 543, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("10");
		textField_3.setBounds(563, 444, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("20");
		textField_4.setBounds(563, 493, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setText("30");
		textField_5.setBounds(563, 543, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		txtTp = new JTextField();
		txtTp.setText("TP4");
		txtTp.setBounds(801, 444, 96, 20);
		contentPane.add(txtTp);
		txtTp.setColumns(10);

		txtTp_1 = new JTextField();
		txtTp_1.setText("TP5");
		txtTp_1.setBounds(801, 493, 96, 20);
		contentPane.add(txtTp_1);
		txtTp_1.setColumns(10);

		txtTp_2 = new JTextField();
		txtTp_2.setText("TP6");
		txtTp_2.setBounds(801, 543, 96, 20);
		contentPane.add(txtTp_2);
		txtTp_2.setColumns(10);

	}
}
