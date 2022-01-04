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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Voir_affectation extends JFrame {
	Connection conn = DbConnection.connecterbd();
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table = new JTable();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voir_affectation frame = new Voir_affectation();
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
	public Voir_affectation() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Module");
		model.addColumn("Prof");
		model.addColumn("Surveillant1");
		model.addColumn("Surveillant2");
		model.addColumn("Date_exam");
		model.addColumn("heure_debut");
		model.addColumn("heure_fin");
		model.addColumn("nb_salles");
		model.addColumn("Salles");

		String sql = "SELECT * FROM ajouter_affectation";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Module"),
						rs.getString("Prof"),
						rs.getString("Surveillant1"),
						rs.getString("Surveillant2"),
						rs.getString("Date_exam"),
						rs.getString("heure_debut"),
						rs.getString("heure_fin"),
						rs.getString("nb_salles"),
						rs.getString("Salles")
				});

				table.setModel(model);
				// table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0);
				table.getColumnModel().getColumn(1);
				table.getColumnModel().getColumn(2);
				table.getColumnModel().getColumn(3);
				table.getColumnModel().getColumn(4);
				table.getColumnModel().getColumn(5);
				table.getColumnModel().getColumn(6);
				table.getColumnModel().getColumn(7);
				table.getColumnModel().getColumn(8);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(10, 214, 1029, 152);
		contentPane.add(scrollPane1);

		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/logo_Ensate_1.png"));
		Image scaleImage = icon.getImage().getScaledInstance(300, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setIcon(new ImageIcon(scaleImage));

		lblNewLabel_0.setBounds(10, 27, 300, 75);
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_7 = new JLabel("ENSA de T\u00E9touan");
		lblNewLabel_7.setBounds(320, 50, 139, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Administration");
		lblNewLabel_8.setBounds(949, 97, 129, 25);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/admin.png"));
		Image scaleImage2 = icon2.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(scaleImage2));

		lblNewLabel_9.setBounds(939, 11, 100, 75);
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton = new JButton("Tableau de bord");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Tableau_bord().setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 141, 129, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Gestion ENSATE");

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

		btnNewButton_1.setBounds(129, 141, 139, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gestion des surveillances");

		JComboBox comboBox3;
		String[] affectations = { "Voir affectation", "Ajouter une affectation" };
		comboBox3 = new JComboBox(affectations);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox3.setBounds(256, 141, 190, 23);
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
		btnNewButton_2.setBounds(256, 141, 190, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Demande de consultation de copie");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Demande_consultation_copie().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(445, 141, 249, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Messagerie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Messagerie().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(832, 141, 100, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PV annuel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pv_annuel().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(928, 141, 111, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Gestion des examens");

		JComboBox comboBox4;
		String[] exams = { "Planifier examens" };
		comboBox4 = new JComboBox(exams);

		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox4.setBounds(680, 141, 159, 23);
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
		btnNewButton_6.setBounds(680, 141, 159, 23);

	}

}
