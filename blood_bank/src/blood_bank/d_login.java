package blood_bank;

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class d_login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					d_login frame = new d_login();
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
	private JPasswordField passwordField;
	public d_login(){
		d_login1();
		conn=connection.dbConnector();
	}
	public void d_login1() {
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
		label_3.setBounds(372, 50, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(354, 82, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblAdminLogIn = new JLabel("DONOR  LOG  IN");
		lblAdminLogIn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminLogIn.setForeground(new Color(0, 255, 255));
		lblAdminLogIn.setBounds(302, 107, 199, 29);
		contentPane.add(lblAdminLogIn);
		
		JLabel lblId = new JLabel("Email      :");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblId.setBounds(279, 183, 93, 14);
		contentPane.add(lblId);
		
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(277, 233, 95, 14);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_2.setForeground(Color.BLUE);
		textField_2.setBounds(366, 181, 239, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancel = new JButton("BACK");
		btnCancel.setForeground(new Color(255, 255, 204));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(412, 285, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		contentPane.add(btnCancel);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from d_registration where email=? and pass=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField_2.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					if (count==1)
					{
						
						dispose();
						dnrlog dnrlog=new dnrlog();
						blood_bank.dnrlog.textField.setText(d_login.textField_2.getText());
						dnrlog.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "wrong.Try Again...");
						
					}
					rs.close();
					pst.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(Color.GRAY);
		btnLogIn.setBounds(516, 285, 89, 23);
		contentPane.add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setForeground(Color.BLUE);
		passwordField.setBounds(366, 231, 239, 20);
		contentPane.add(passwordField);
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField_2.setBorder(field_border);
				passwordField.setBorder(field_border);
		
	}
}
