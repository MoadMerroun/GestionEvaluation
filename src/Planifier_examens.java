import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Planifier_examens extends JFrame {
	Connection conn = DbConnection.connecterbd();
	PreparedStatement ps = null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Planifier_examens frame = new Planifier_examens();
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
		contentPane.add(btnNewButton_9);
		btnNewButton_9.setBounds(680, 113, 177, 23);

		JButton btnNewButton_6 = new JButton("Importer les Plannings");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ImportDataFromExcelModel = (DefaultTableModel) table.getModel();
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelImportWorkBook = null;
				JFileChooser f = new JFileChooser();
				int reponse = f.showOpenDialog(null);
				if (reponse == JFileChooser.APPROVE_OPTION) {
					File excelFile = f.getSelectedFile();
					try {
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelImportWorkBook = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);

						for (int i = 0; i <= excelSheet.getLastRowNum(); i++) {
							XSSFRow excelRow = excelSheet.getRow(i);
							XSSFCell cell0 = excelRow.getCell(0);
							XSSFCell cell1 = excelRow.getCell(1);
							XSSFCell cell2 = excelRow.getCell(2);
							XSSFCell cell3 = excelRow.getCell(3);
							XSSFCell cell4 = excelRow.getCell(4);
							XSSFCell cell5 = excelRow.getCell(5);
							XSSFCell cell6 = excelRow.getCell(6);
							XSSFCell cell7 = excelRow.getCell(7);
							XSSFCell cell8 = excelRow.getCell(8);
							XSSFCell cell9 = excelRow.getCell(9);
							XSSFCell cell10 = excelRow.getCell(10);
							ImportDataFromExcelModel
									.addRow(new Object[] { cell0, cell1, cell2, cell3, cell4, cell5,
											cell6, cell7,
											cell8, cell9, cell10 });
						}
						int j = table.getRowCount();
						for (int k = 0; k < j; k++) {
							String sql = "INSERT INTO Planning_GI2 values('"
									+ ImportDataFromExcelModel.getValueAt(k, 0).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 1).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 2).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 3).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 4).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 5).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 6).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 7).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 8).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 9).toString() + "','"
									+ ImportDataFromExcelModel.getValueAt(k, 10).toString() + "')";
							ps = conn.prepareStatement(sql);
							ps.executeUpdate();
						}

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnNewButton_6.setBounds(785, 172, 167, 42);
		contentPane.add(btnNewButton_6);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"COD_ETU", "CNE", "Nom", "Prenom", "Mod et POO", "Adm BD", "Magt Chai", "Meth Gén", "Vision ar",
						"Lg et Com2", "Salle contrôle"
				}));
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(45, 290, 977, 136);
		contentPane.add(scrollPane1);

	}
}
