package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlt_admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Object e = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dlt_admin frame = new dlt_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn=null;
	static JTextField textField_1;
	public dlt_admin(){
		dlt_admin1();
		conn=connection.dbConnector();
	}
	/**
	 * Create the frame.
	 */
	public void dlt_admin1() {
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
		label_3.setBounds(367, 56, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(352, 87, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblNewLabel = new JLabel("DELETE MODERATOR");
		lblNewLabel.setForeground(new Color(0, 255, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(264, 112, 262, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(264, 164, 285, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(222, 167, 46, 14);
		contentPane.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 253, 605, 99);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query1="delete from moderator where  email=?";
					PreparedStatement pstt=conn.prepareStatement(query1);
					
					pstt.setString(1,textField.getText());
				
					 if(pstt.executeUpdate()!=0) {
					    	JOptionPane.showMessageDialog(null,"Deleted Successfully");
					    	dispose();
					    	adaccess adaccess=new adaccess();
							blood_bank.adaccess.textField.setText(dlt_admin.textField_1.getText());
							adaccess.setVisible(true);
					    }
					    else  {
					    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
					    	dispose();
							adaccess adaccess=new adaccess();
							blood_bank.adaccess.textField.setText(dlt_admin.textField_1.getText());
							adaccess.setVisible(true);
					    }
				}catch(Exception e1)
				{
				}
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(630, 371, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				adaccess adaccess=new adaccess();
				blood_bank.adaccess.textField.setText(dlt_admin.textField_1.getText());
				adaccess.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(512, 371, 89, 23);
		contentPane.add(btnBack);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(411, 195, 138, 32);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("SEARCH MODERATOR");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="select name,phone,email from moderator where email=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
	
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e);
					
				}
				
			}
	
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
