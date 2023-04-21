package com.yc.jdbc.view;

import com.yc.jdbc.domain.Books;
import com.yc.jdbc.service.UserService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookInformationUpdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			
////			BookInformation dialog = new BookInformation(ISN);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	public BookInformationUpdate(int ISN) {
		//invok from userService method to get data from database
		UserService userService = new UserService();
		Books book = userService.getBookInformationsByISN(ISN);
		
		setTitle("Update Information");
		setBounds(100, 100, 444, 454);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("ISN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		//get isn from update page isn.
				textField.setText(String.valueOf(book.getIsn()));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(book.getTitle());
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(book.getAuthor());
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(String.valueOf(book.getPrice()));
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText(book.getPublisher());
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText(String.valueOf(book.getBookTypeId()));
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText(String.valueOf(book.getAvailable()));
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_6.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBooktype = new JLabel("BookType");
		lblBooktype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAvailable = new JLabel("Available");
		lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPublisher))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBooktype, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAvailable)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblBooktype, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAvailable, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (validateInput()) {
						int isn = Integer.parseInt(textField.getText());
				        String title = textField_1.getText();
				        String author = textField_2.getText();
				        double price = Double.parseDouble(textField_3.getText());
				        String publisher = textField_4.getText();
				        int bookTypeId = Integer.parseInt(textField_5.getText());
				        int available = Integer.parseInt(textField_6.getText());

				        // Create a new Books object with the updated information
				        Books updatedBook = new Books(isn, title, author, price, publisher, bookTypeId, available);

				        // Call the UserService to update the book information
				        boolean isUpdated = userService.updateBookInformation(updatedBook);

				        if (isUpdated) {
				            JOptionPane.showMessageDialog(null, "Book update successfully!");
				        } else {
				            JOptionPane.showMessageDialog(null, "Failed to update book information!");
				        }
				        }
					}
					private boolean validateInput() {
						try {
							int isn = Integer.parseInt(textField.getText());
							if (String.valueOf(isn).length() != 7) {
								JOptionPane.showMessageDialog(null, "ISN must be  7 digits!");
								return false;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "ISN must be an integer!");
							return false;
						}
						String title = textField_1.getText();
						if (title.length() > 30 || title.length() == 0) {
							JOptionPane.showMessageDialog(null, "Title must be filled properly!");
							return false;
						}
						String author = textField_2.getText();
						if (author.length() > 30 || author.length()==0 ) {
							JOptionPane.showMessageDialog(null, "Author must be filled properly!");
							return false;
						}
						String publisher = textField_4.getText();
						if (publisher.length() > 30 || publisher.length() ==0) {
							JOptionPane.showMessageDialog(null, "Author must be filled properly!");
							return false;
						}

						return true;
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Delete");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				        int result = JOptionPane.showConfirmDialog(null, 
				        		"Are you sure you want to delete this book?", "Delete Book", 
				        		JOptionPane.YES_NO_OPTION);
				        if (result == JOptionPane.YES_OPTION) {
				            int isn = Integer.parseInt(textField.getText());
				            boolean isDeleted = userService.deleteBook(isn);
				            if (isDeleted) {
				                JOptionPane.showMessageDialog(null, "Book deleted successfully!");
				            } else {
				                JOptionPane.showMessageDialog(null, "Failed to delete book!");
				            }
				        }
				    }
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
