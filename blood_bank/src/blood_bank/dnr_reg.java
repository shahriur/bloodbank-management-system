package blood_bank;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class dnr_reg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dnr_reg frame = new dnr_reg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	public dnr_reg(){
		dnr_reg1();
		conn=connection.dbConnector();
	}
	/**
	 * Create the frame.
	 */
	
	
	
	
	private void dnr_reg1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel();
		Image img6=new ImageIcon(this.getClass().getResource("/iconn.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img6));
		label_3.setBounds(47, 11, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(35, 42, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblDonorRegistration = new JLabel("DONOR REGISTRATION");
		lblDonorRegistration.setForeground(Color.CYAN);
		lblDonorRegistration.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDonorRegistration.setBounds(268, 27, 305, 32);
		contentPane.add(lblDonorRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblName.setBounds(293, 94, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(401, 91, 227, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGender.setBounds(293, 126, 46, 14);
		contentPane.add(lblGender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setForeground(new Color(0, 255, 255));
		male.setBackground(new Color(204, 0, 0));
		male.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		male.setBounds(401, 118, 85, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setForeground(new Color(0, 255, 255));
		female.setBackground(new Color(204, 0, 0));
		female.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		female.setBounds(488, 118, 85, 23);
		contentPane.add(female);
		JRadioButton Other = new JRadioButton("Other");
		Other.setForeground(new Color(0, 255, 255));
		Other.setBackground(new Color(204, 0, 0));
		Other.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Other.setBounds(578, 118, 64, 23);
		contentPane.add(Other);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setBounds(401, 207, 145, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAge.setBounds(293, 151, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMobileNo.setBounds(293, 207, 64, 14);
		contentPane.add(lblMobileNo);
		
		JLabel lblBloodGroup = new JLabel("Blood Group:");
		lblBloodGroup.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBloodGroup.setBounds(293, 182, 75, 14);
		contentPane.add(lblBloodGroup);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.addItem("AB+");
		comboBox.addItem("AB-");
		comboBox.addItem("A+");
		comboBox.addItem("A-");
		comboBox.addItem("B+");
		comboBox.addItem("B-");
		comboBox.addItem("O+");
		comboBox.addItem("O-");
		comboBox.setBounds(401, 179, 75, 20);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(401, 148, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(293, 241, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_3.setBounds(401, 238, 282, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(293, 319, 64, 14);
		contentPane.add(lblPassword);
		
		textField_4 = new JPasswordField();
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_4.setBounds(401, 316, 123, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblConfirmPassword.setBounds(293, 354, 105, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_5 = new JPasswordField();
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_5.setBounds(401, 351, 128, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(626, 382, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String gender="Male";
				String blood_group=(String)comboBox.getSelectedItem();
				if (female.isSelected())
				{
					gender="Female";
				}
				else if (Other.isSelected())
				{
					gender="Other";
				}
				
				
				int age=Integer.parseInt(textField_1.getText());
				String mobile=textField_6.getText();
				String email=textField_3.getText();
				String pass=textField_4.getText();
				String address=textField_7.getText();
				
				if (verifyFields())
						{
					if(age>=18&&age<=50)
					
					{if( checkEmailagain())
					{
					
					if(!checkEmail(email))
					{ if(verifyphn()) {
						PreparedStatement ps;
						String registerUserQuery="insert into d_registration(name,gender,age,blood,mobile,email,pass,address) values(?,?,?,?,?,?,?,?)";
						try{ps=conn.prepareStatement(registerUserQuery);
						    ps.setString(1, name);
						    ps.setString(2, gender);
						    ps.setInt(3, age);
						    ps.setString(4, blood_group);
						    ps.setString(5, mobile);
						    ps.setString(6,email);
						    ps.setString(7, pass);
						    ps.setString(8, address);
						    if(ps.executeUpdate()!=0) {
						    	
						    	
						    	PreparedStatement ps1;
								String Query="insert into availstatus values(?,DATETIME('now'),'Available')";
								try{ps1=conn.prepareStatement(Query);
								   
								    
								    ps1.setString(1,email);
								   
								    if(ps1.executeUpdate()!=0) {
				
						    	
						    	JOptionPane.showMessageDialog(null,"Account Created");
						    	dispose();
								HOME1 home1=new HOME1();
								home1.setVisible(true);
								    }
								    
								    else  {
								    	JOptionPane.showMessageDialog(null,"Error:Check Your Information");
								    }
								
								
								}catch(Exception e) {
									
									JOptionPane.showMessageDialog(null,"Error:Check Your Information for status");
									
								}
						    }
						    else  {
						    	JOptionPane.showMessageDialog(null,"Error:Check Your Information");
						    }
						    	
						}catch(Exception e) {
							
							JOptionPane.showMessageDialog(null,"Error:Check Your Information for input");
						}
						}}}
						}
					else {
						JOptionPane.showMessageDialog(null,"For your age you are not able to be a donor");
					}
					}
						}
			
		});
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(new Color(255, 255, 204));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(495, 382, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		contentPane.add(btnCancel);
		textField_7 = new JTextField();
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_7.setBounds(401, 277, 333, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				textField_1.setBorder(field_border);
				textField_3.setBorder(field_border);
				textField_4.setBorder(field_border);
				textField_5.setBorder(field_border);
				textField_6.setBorder(field_border);
				textField_7.setBorder(field_border);
				
				JLabel lblAddress = new JLabel("Address :");
				lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
				lblAddress.setBounds(293, 280, 64, 14);
				contentPane.add(lblAddress);
				
			
				
				
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (male.isSelected())
				{
					female.setSelected(false);
					Other.setSelected(false);
				}
			}
		});
		
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (female.isSelected())
				{
					male.setSelected(false);
					Other.setSelected(false);
				}
			}
		});
		Other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Other.isSelected())
				{
					male.setSelected(false);
					female.setSelected(false);
				}
			}
		});
	}
	//create a function to verify empty fields
		public boolean verifyFields()
		{
		String name=textField.getText();
		String age=textField_1.getText();
	
		String mobile=textField_6.getText();
		String email=textField_3.getText();
		String pass=textField_4.getText();
		String cpass=textField_5.getText();
		String address=textField_7.getText();
		
		if(name.trim().equals("")||age.trim().equals("")||mobile.trim().equals("")||email.trim().equals("")||pass.trim().equals("")||cpass.trim().equals("")||address.trim().equals(""))
		{
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
			return false;}
		
		
		 if(pass.equals(cpass))
		{
			return true;
			}
		else {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match,Retype Password");
			return false;
			
			}
		}
		
		public boolean verifyphn()
		{
			String mobile=textField_6.getText();
			int l= mobile.length();
			
			if(l==11)
			{
				char first= mobile.charAt(0);
				char sec= mobile.charAt(1);
				char third= mobile.charAt(2);
				if(first=='0')
				{
					if(sec=='1')
					{
						if(third=='7')
						{
							return true;
						}
						else if(third=='3')
						{
							return true;
						}
						else if(third=='4')
						{
							return true;
						}
						else if(third=='9')
						{
							return true;
						}
						else if(third=='6')
						{
							return true;
						}
						else if(third=='8')
						{
							return true;
						}
						else if(third=='5')
						{
							return true;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Mobile No ");
							return false;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Mobile No ");
						return false;
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Mobile No ");
					return false;
				}
				
				}
			else {
				JOptionPane.showMessageDialog(null, "Mobile No must be of 11 digits");
				return false;
			}
			
		}
		
		
		
		//create a function to check  email already exist or not
		public boolean checkEmail(String email) {
			PreparedStatement st;
			ResultSet rs;
			boolean email_notexist=false;
			String query="select * from d_registration where email=?";
			try{
				st=conn.prepareStatement(query);
			st.setString(1, email);
			rs=st.executeQuery();
			if(rs.next())
			{email_notexist=true;
			JOptionPane.showMessageDialog(null, "This email is already used");
			}
			}catch(Exception e) {
				
			}
			
		
			    return email_notexist;
			
			
			}
		public boolean checkEmailagain() {
			String email=textField_3.getText();
		
			int em= email.length();
			int i=1;
			while(i<em)
			{
				char test= email.charAt(i);
				if(test=='@')
				{
					int j=i+1;
					while(j<em)
					{
						char testt= email.charAt(j);
						if(testt=='.')
						{
							return true;
						}
						else {
							j++;
						}
					}
					 if(j==em)
					{
						
						JOptionPane.showMessageDialog(null, "This email is invalid");
						return false;
					}
					
				}
				else {
					i++;
				}
				
			}
			if(i==em)
			{
				
				JOptionPane.showMessageDialog(null, "This email is invalid");
				return false;
			}
			
			else return true;
			
			}
		
		
		
		
}
