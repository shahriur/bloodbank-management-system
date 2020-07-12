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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class add_moderator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
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
					add_moderator frame = new add_moderator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn=null;
	private JTextField textField_4;
	static JTextField textField_5;
	public add_moderator(){
		add_admin1();
		conn=connection.dbConnector();
	}
	/**
	 * Create the frame.
	 */
	private void add_admin1() {
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
		
		JLabel lblNewLabel = new JLabel("ADD MODERATOR");
		lblNewLabel.setForeground(new Color(0, 255, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(281, 107, 232, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name                         :");
		lblName.setBounds(147, 157, 113, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email                          :");
		lblEmail.setBounds(147, 193, 113, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password                 :");
		lblPassword.setBounds(147, 270, 113, 14);
		contentPane.add(lblPassword);
		
		JLabel lblMobile = new JLabel("Mobile                        :");
		lblMobile.setBounds(147, 234, 123, 14);
		contentPane.add(lblMobile);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(270, 154, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(270, 190, 255, 20);
		contentPane.add(textField_1);
		((JTextField) textField_1).setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_2.setBounds(270, 231, 255, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JPasswordField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_3.setBounds(270, 267, 148, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(147, 313, 113, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_4 = new JPasswordField();
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_4.setBounds(270, 310, 148, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		textField_1.setBorder(field_border);
		textField_2.setBorder(field_border);
		textField_3.setBorder(field_border);
		textField_4.setBorder(field_border);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(444, 351, 64, 32);
		contentPane.add(panel);
		
		JButton btnAdd = new JButton("ADD");
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField.getText();
				String email=textField_1.getText();
				String phone=textField_2.getText();
				String password=textField_3.getText();
				
				
				if (verifyFields())
						{
					if(!checkEmail(email))
					{
						PreparedStatement ps;
						String registerUserQuery="insert into moderator(name,email,pass,phone) values(?,?,?,?)";
						try{ps=conn.prepareStatement(registerUserQuery);
						    ps.setString(1, name);
						    ps.setString(2,email);
						    ps.setString(3,password);
						    ps.setString(4, phone);
						   
						    if(ps.executeUpdate()!=0) {
						    	JOptionPane.showMessageDialog(null,"Moderator Added Successfully");
						    	dispose();
						    	adaccess adaccess=new adaccess();
								 blood_bank.adaccess.textField.setText(add_moderator.textField_5.getText());
								 adaccess.setVisible(true);
						    }
						    else  {
						    	JOptionPane.showMessageDialog(null,"Error:Check Your Information");
						    	dispose();
						    	adaccess adaccess=new adaccess();
								 blood_bank.adaccess.textField.setText(add_moderator.textField_5.getText());
								 adaccess.setVisible(true);
						    }
						    	
						}catch(Exception e1) {}
						}
					}
				
				
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.GRAY);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setBackground(new Color(204, 0, 0));
		textField_5.setForeground(new Color(204, 0, 0));
		textField_5.setEditable(false);
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 0));
		panel_1.setBounds(353, 351, 81, 32);
		contentPane.add(panel_1);
		
		JButton btnCancel = new JButton("CANCEL");
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				adaccess adaccess=new adaccess();
				 blood_bank.adaccess.textField.setText(add_moderator.textField_5.getText());
				 adaccess.setVisible(true);
				
			}
		});
		btnCancel.setForeground(new Color(255, 255, 204));
		btnCancel.setBackground(new Color(255, 0, 0));
		
	}
	//create a function to verify empty fields
	public boolean verifyFields()
	{
		String name=textField.getText();
		String email=textField_1.getText();
		String phone=textField_2.getText();
		
		String password=textField_3.getText();
		String cpswrd=textField_4.getText();
	if(name.trim().equals("")||email.trim().equals("")||phone.trim().equals("")||password.trim().equals("")||cpswrd.trim().equals(""))
	{
		JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
		return false;}
	
	 if(password.equals(cpswrd))
	{
		return true;
		}
	else {
		JOptionPane.showMessageDialog(null, "Password Doesn't Match,Retype Password");
		return false;
		
		}
	}
	//create a function to check  email already exist or not
	public boolean checkEmail(String email) {
		PreparedStatement st;
		ResultSet rs;
		boolean email_exist=false;
		String query="select * from moderator where email=?";
		try{
			st=conn.prepareStatement(query);
		st.setString(1, email);
		rs=st.executeQuery();
		if(rs.next())
		{email_exist=true;
		JOptionPane.showMessageDialog(null, "This email is already used");
		}
		}catch(Exception e) {
			
		}
		return email_exist;
		}
}
