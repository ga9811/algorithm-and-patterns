package com.yc.jdbc.view;

import com.mysql.cj.util.StringUtils;
import com.yc.jdbc.Utils.LoginConfig;
import com.yc.jdbc.domain.User;
import com.yc.jdbc.service.UserService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField PwdTxt;
//	private Object comboBox;
private JComboBox comboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Library System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("User_ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		userNameTxt = new JTextField();
		userNameTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		userNameTxt.setColumns(10);
		
		PwdTxt = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("Access");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin"}));
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerformed(e);
				
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegActionPerformed(e);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(186))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnRegister)
							.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(75))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(PwdTxt, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(198, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(PwdTxt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(66))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//display in the centre
	}
	protected void RegActionPerformed(ActionEvent e) {
		dispose();//remove current window
		new RegFrm().setVisible(true);//display new window
		
		
	}

	/*
	 * reset event
	 */

	protected void ResetActionPerformed(ActionEvent e) {
		reset();
		
	}
	/*
	 * reset method
	 * set null to the userId and pwd
	 */
	public void reset() {
		this.userNameTxt.setText("");
		this.PwdTxt.setText("");
	}

	protected void LoginActionPerformed(ActionEvent e) {
		String userId = this.userNameTxt.getText();
		String pwd = new String(this.PwdTxt.getPassword());

		if (StringUtils.isNullOrEmpty(userId)) {
			JOptionPane.showMessageDialog(null,"ID can't empty!");
		}
		if (StringUtils.isNullOrEmpty(pwd)) {
			JOptionPane.showMessageDialog(null,"Password can't empty!");
		}
		UserService userService = new UserService();
//		int user_type = ;
		String qxValue = (String) this.comboBox.getSelectedItem();
		if(qxValue.equals("Student")){
			int user_type = 0;
			User user = userService.getUserByIdAndPwd(userId, pwd,user_type);
			if(user != null) {
				dispose();
				LoginConfig.save(new User(userId, pwd, user_type));
				new MainFrm(userId).setVisible(true);//transform userId to MainFrm
				JOptionPane.showMessageDialog(null,"login successful!");
			}else{
				JOptionPane.showMessageDialog(null,"Student_id or Password wrong!");
			}

		} else{
			int user_type = 1;
			User user = userService.getUserByIdAndPwd(userId, pwd,user_type);
			if(user != null) {
				dispose();
				LoginConfig.save(new User(userId, pwd, user_type));
				new AdminFrm().setVisible(true);
				JOptionPane.showMessageDialog(null,"login successful!");
			}else{
				JOptionPane.showMessageDialog(null,"Student_id or Password wrong!");
			}
		}




	}
}
