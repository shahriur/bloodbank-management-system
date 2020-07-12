package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	Connection conn=null;
	private JTextField textField;
	public search(){
		search1();
		conn=connection.dbConnector();
	}
	public void search1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel();
		Image img6=new ImageIcon(this.getClass().getResource("/iconn.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img6));
		label_3.setBounds(379, 22, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(364, 55, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBounds(345, 65, 148, 47);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectBloodGroup = new JLabel("SELECT BLOOD GROUP :");
		lblSelectBloodGroup.setBounds(61, 133, 148, 14);
		contentPane.add(lblSelectBloodGroup);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(666, 394, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});

		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 209, 508, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.CYAN);
		comboBox.addItem("AB+");
		comboBox.addItem("AB-");
		comboBox.addItem("A+");
		comboBox.addItem("A-");
		comboBox.addItem("B+");
		comboBox.addItem("B-");
		comboBox.addItem("O+");
		comboBox.addItem("O-");
		comboBox.setBounds(213, 130, 98, 20);
		contentPane.add(comboBox);
		
		JButton btnSearch_1 = new JButton("SEARCH BlOOD");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String value=(String)comboBox.getSelectedItem();
					String query="select * from stock where blood_group=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,value);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
			}
		});
		btnSearch_1.setForeground(Color.WHITE);
		btnSearch_1.setBackground(Color.GRAY);
		btnSearch_1.setBounds(645, 209, 135, 23);
		contentPane.add(btnSearch_1);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ADDRESS             :");
		lblNewLabel_1.setBounds(61, 173, 148, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setBounds(213, 170, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		
		JButton btnNewButton_1 = new JButton("SEARCH DONOR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query1="update availstatus set status='Available' where  available_time<=DATETIME('now')";
					PreparedStatement pstt=conn.prepareStatement(query1);
		
					 if(pstt.executeUpdate()!=0) {
				
				try {
					String value=(String)comboBox.getSelectedItem();
					String query="select d_registration.name,d_registration.blood,d_registration.mobile,d_registration.address,availstatus.available_time,availstatus.status from d_registration,availstatus where d_registration.address like '%"+textField.getText()+"%' and d_registration.blood=? and availstatus.email=d_registration.email ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,value);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}}
				else  {
					String value=(String)comboBox.getSelectedItem();
					String query="select d_registration.name,d_registration.blood,d_registration.mobile,d_registration.address,availstatus.available_time,availstatus.status from d_registration,availstatus where d_registration.address like '%"+textField.getText()+"%' and d_registration.blood=? and availstatus.email=d_registration.email ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,value);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
					 }catch(Exception e1) {
							
							JOptionPane.showMessageDialog(null, "Wrong 1 ");
						}
					 
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(645, 242, 135, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
	}
}
