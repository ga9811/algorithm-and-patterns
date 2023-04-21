package com.yc.jdbc.view;

import com.mysql.cj.util.StringUtils;
import com.yc.jdbc.service.UserService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userIdTxt;
	private JPasswordField pwdTxt;
	private JTextField nameTxt;
	private JTextField user_typeTex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrm frame = new RegFrm();
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
	public RegFrm() {
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		userIdTxt = new JTextField();
		userIdTxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		userIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegActionPerformed(e);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		pwdTxt = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		user_typeTex = new JTextField();
		user_typeTex.setFont(new Font("Tahoma", Font.PLAIN, 22));
		user_typeTex.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("User type");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("student 0, admin 1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(186)
					.addComponent(btnNewButton)
					.addContainerGap(383, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(87)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_2)))
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addGap(67)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(259))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(nameTxt, Alignment.LEADING, 333, 333, 333)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(pwdTxt, Alignment.TRAILING)
									.addComponent(userIdTxt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(user_typeTex, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
							.addGap(113))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_typeTex, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addGap(106)
					.addComponent(btnNewButton)
					.addGap(68))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//display in the centre
	}
			/*
			 * registe event
			 */
			protected void RegActionPerformed(ActionEvent e) {

				String userId = this.userIdTxt.getText();
//				Utility.readInt(Integer.parseInt(userId));
				String pwd = new String(this.pwdTxt.getPassword());
				String name = this.nameTxt.getText();
				String userTypeStr = this.user_typeTex.getText();

				// Input validations

				if (StringUtils.isNullOrEmpty(userId)) {
					JOptionPane.showMessageDialog(null, "userId is empty");
					return;
				}
				if (StringUtils.isNullOrEmpty(pwd)) {
					JOptionPane.showMessageDialog(null, "password is empty");
					return;
				}
				if (StringUtils.isNullOrEmpty(name)) {
					JOptionPane.showMessageDialog(null, "name is empty");
					return;
				}

				if (StringUtils.isNullOrEmpty(userTypeStr)) {
					JOptionPane.showMessageDialog(null, "user_type is empty");
					return;
				}

				int userType;
				try {
					userType = Integer.parseInt(userTypeStr);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "user_type is not a valid number");
					return;
				}

				if (userType != 0 && userType != 1) {
					JOptionPane.showMessageDialog(null, "user_type is invalid");
					return;
				}

				UserService userService = new UserService();
				int user = userService.updateUser(userId, pwd, name, userType);

				if (user > 0) {
					dispose();
					new Login().setVisible(true);
					System.out.println("register successful");
					JOptionPane.showMessageDialog(null, "register successfully");
				} else {
					JOptionPane.showMessageDialog(null, "register failed");
				}
			}
}
