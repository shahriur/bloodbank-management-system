package blood_bank;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt. *;          

import javax.swing.border.EmptyBorder;


public class HOME1 extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Timer tm1,tm2,tm3,tm4,tm5;
	Integer pl1=32,pl2=32,pl3=32,pl4=32,pl5=32;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME1 frame = new HOME1();
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
	public HOME1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(47, 88, 110, 32);
		contentPane.add(lblNewLabel);
		Image img2=new ImageIcon(this.getClass().getResource("/w.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		JLabel label = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/bb.jpg")).getImage();
		label.setIcon(new ImageIcon(img3));
		label.setBounds(47, 264, 233, 125);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("/L1.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img4));
		label_1.setBounds(290, 264, 224, 125);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/ll.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img5));
		label_2.setBounds(524, 264, 233, 125);
		contentPane.add(label_2);
		
		
		
		JTextArea txtrHowToRead = new JTextArea();
		txtrHowToRead.setEditable(false);
		txtrHowToRead.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrHowToRead.setForeground(new Color(0, 255, 255));
		txtrHowToRead.setBackground(new Color(204, 0, 0));
		txtrHowToRead.setText("Accidents never come with a warning. It can happen at any place, any time with anyone. And not just accidents - \nemergency situations when you might badly need a bag of blood for your near and dear ones are aplenty. \r\n\r\nMany people think that donating blood can be harmful for them and they have certain reservations about blood donation.\nThe fear and discomfort has a lot to do with a lack of knowledge. But donating blood is a very safe and simple procedure \nand it takes only 10-15 minutes to complete the process. Any healthy adult aged between 18- 60 and weighing at least 50 \nkg is eligible to donate blood.");
		txtrHowToRead.setBounds(47, 131, 710, 122);
		contentPane.add(txtrHowToRead);
		
		JLabel label_3 = new JLabel();
		Image img6=new ImageIcon(this.getClass().getResource("/iconn.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img6));
		label_3.setBounds(47, 11, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(30, 39, 66, 14);
		contentPane.add(lblLifeSaver);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(149, 11, 173, 32);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("DONOR REGISTRATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dnr_reg dnr_reg=new dnr_reg();
				dnr_reg.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 0));
		panel_1.setBounds(321, 11, 110, 32);
		contentPane.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("       LOG IN     ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBackground(Color.GRAY);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_2.setForeground(Color.WHITE);
		
		JButton btnNewButton_5 = new JButton("     DONOR     ");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				d_login d_login =new d_login ();
				d_login .setVisible(true);
			}
		});
		
		JButton btnAdmin = new JButton("     ADMIN       ");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				adminlog adminlog=new adminlog();
				adminlog.setVisible(true);
			}
		});
		btnAdmin.setBackground(Color.GRAY);
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAdmin.setForeground(Color.WHITE);
		panel_1.add(btnAdmin);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("MODERATOR");
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				admin_l admin_l=new admin_l();
				admin_l.setVisible(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 0, 0));
		panel_2.setBounds(431, 11, 125, 32);
		contentPane.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("SEND REQUEST");
		btnNewButton_1.setBackground(Color.GRAY);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				send_request send_request =new send_request ();
				send_request.setVisible(true);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 0, 0));
		panel_3.setBounds(552, 11, 89, 32);
		contentPane.add(panel_3);
		
		JButton btnNewButton_3 = new JButton("SEARCH");
		panel_3.add(btnNewButton_3);
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				search search =new search ();
				search.setVisible(true);
			}
		});
		
		/** drop down*/
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel.setSize(panel.getWidth(),pl2);
				panel_2.setSize(panel_2.getWidth(),pl3);
				panel_3.setSize(panel_3.getWidth(),pl4);
				tm1.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
			tm1.stop();
				pl1=32;
			}
		});
		
         tm1=new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pl1>400)
				{
					tm1.stop();
					
				}
				else {
					panel_1.setSize(panel_1.getWidth(),pl1);
					pl1+=30;
				}
			}

		
		});
         
         
       /****---*/  
         
         btnNewButton.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent arg0) {
 			
 				panel_1.setSize(panel_1.getWidth(),pl1);
				panel_2.setSize(panel_2.getWidth(),pl3);
				panel_3.setSize(panel_3.getWidth(),pl4);
 				tm2.start();
 			}
 			@Override
 			public void mouseExited(MouseEvent e) {
 			tm2.stop();
 				pl2=32;
 			}
 		});
 		
          tm2=new Timer(20, new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				if(pl2>300)
 				{
 					tm2.stop();
 					
 				}
 				else {
 					panel.setSize(panel.getWidth(),pl2);
 					pl2+=10;
 				}
 			}

 		
 		});
          
          
          
          btnNewButton_1.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mouseEntered(MouseEvent arg0) {
  				panel.setSize(panel.getWidth(),pl2);
  				panel_1.setSize(panel_1.getWidth(),pl1);
				panel_3.setSize(panel_3.getWidth(),pl4);
  				tm3.start();
  			}
  			@Override
  			public void mouseExited(MouseEvent e) {
  			tm3.stop();
  				pl3=32;
  			}
  		});
  		
           tm3=new Timer(20, new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				if(pl3>100)
  				{
  					tm3.stop();
  					
  				}
  				else {
  					panel_2.setSize(panel_2.getWidth(),pl3);
  					pl3+=10;
  				}
  			}

  		
  		});
           
           
           
           btnNewButton_3.addMouseListener(new MouseAdapter() {
   			@Override
   			public void mouseEntered(MouseEvent arg0) {
   				panel_1.setSize(panel_1.getWidth(),pl1);
  				panel.setSize(panel.getWidth(),pl2);
   				panel_2.setSize(panel_2.getWidth(),pl3);
   				tm4.start();
   			}
   			@Override
   			public void mouseExited(MouseEvent e) {
   			tm4.stop();
   				pl4=32;
   			}
   		});
   		
            tm4=new Timer(20, new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				if(pl4>100)
   				{
   					tm4.stop();
   					
   				}
   				else {
   					panel_3.setSize(panel_3.getWidth(),pl4);
   					pl4+=10;
   				}
   			}

   		
   		});
		
	}
}
