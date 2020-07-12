package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ud_dname extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ud_dname frame = new ud_dname();
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
	public ud_dname(){
		ud_dname1();
		conn=connection.dbConnector();
	}
	public void ud_dname1() {
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
		
		JLabel lblNewLabel = new JLabel("UPDATE DONOR NAME");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(270, 93, 266, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(61, 150, 46, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setBounds(150, 147, 208, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewName = new JLabel("NEW NAME:");
		lblNewName.setBounds(61, 199, 79, 14);
		contentPane.add(lblNewName);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(150, 196, 208, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query1="update d_registration set name=? where email=?";
					PreparedStatement pstt=conn.prepareStatement(query1);
					
					pstt.setString(1,textField_1.getText());
					pstt.setString(2,textField.getText());
				
					 if(pstt.executeUpdate()!=0) {
					    	JOptionPane.showMessageDialog(null,"Name Updated Successfully");
					    	dispose();
							dnrlog dnrlog=new dnrlog();
							blood_bank.dnrlog.textField.setText(ud_dname.textField.getText());
							dnrlog.setVisible(true);
					    }
					    else  {
					    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
					    	dispose();
							dnrlog dnrlog=new dnrlog();
							blood_bank.dnrlog.textField.setText(ud_dname.textField.getText());
							dnrlog.setVisible(true);
					    }
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "wrong");
					
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.setBounds(269, 248, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dnrlog dnrlog=new dnrlog();
				blood_bank.dnrlog.textField.setText(ud_dname.textField.getText());
				dnrlog.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(157, 248, 89, 23);
		contentPane.add(btnBack);
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				textField_1.setBorder(field_border);
		
	}
}
