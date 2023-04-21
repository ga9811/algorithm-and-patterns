package com.yc.jdbc.view;

import com.yc.jdbc.domain.BookAndBorrow;
import com.yc.jdbc.domain.Books;
import com.yc.jdbc.service.UserService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class BooksSearchAndUpdate extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private UserService userService = new UserService();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksSearchAndUpdate frame = new BooksSearchAndUpdate();
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
	public BooksSearchAndUpdate() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Books Index and update");
		setBounds(100, 100, 1153, 594);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserIdSearchActionPerformed();
			}
		});
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserIdSearchActionPerformed();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int ISN = (int) table.getValueAt(selectedRow, 0);
					String userId = BooksSearchAndUpdate.this.textField.getText();
					if (userService.returnBook(userId, ISN)) {
						JOptionPane.showMessageDialog(null, "Returned successfully!");
						// delete current row
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(selectedRow);
					} else {
						JOptionPane.showMessageDialog(null, "Failed to return the book!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a book to return!");
				}
				
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleSearchActionPerformed();
			}
		});
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleSearchActionPerformed();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1_1 = new JButton("Borrow");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table.getSelectedRow();
					String userId = BooksSearchAndUpdate.this.textField.getText();
					if (selectedRow != -1) {
						String isn = table.getValueAt(selectedRow, 0).toString();
						int available = (int) table.getValueAt(selectedRow, 7);
						if (available == 0) {
							if (userService.borrowBook(userId, isn)) {
								JOptionPane.showMessageDialog(null, "Borrowed successfully!");
								
								table.setValueAt(1, selectedRow, 7);
							} else {
								JOptionPane.showMessageDialog(null, "Failed to borrow the book!");
							}
						} else {
							JOptionPane.showMessageDialog(null, "The book is already borrowed!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please select a book to borrow!");
					}
				}
			
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblWhenBorrowNeed = new JLabel("when borrow need fill User ID");
		lblWhenBorrowNeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnNewButton_1_2 = new JButton("Update");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create new dialog for update
				int selectedRow = table.getSelectedRow();
				if(selectedRow !=-1) {
					int ISN =(int)table.getValueAt(selectedRow, 0);
					BookInformationUpdate dialog = new BookInformationUpdate(ISN);
				dialog.setModal(true);
				dialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Please select a row in the table!");
				}
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_2_1 = new JButton("Add Book");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook dialog = new AddBook();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(374)
							.addComponent(lblWhenBorrowNeed, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_1_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(48)
									.addComponent(btnNewButton_1_2_1)))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnNewButton)
						.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenBorrowNeed, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISN", "User_id", "Book Name", "Author", "Borrow Date", "Return Date", "Publisher", "Available"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

	protected void UserIdSearchActionPerformed() {
		String user_id = this.textField.getText();
		List<BookAndBorrow> searchResults = userService.searchBooksByUserId(user_id);
	    fillTableWithSearchResults(searchResults);

	    if (searchResults.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No books found with the ID: " + user_id);
	    }
	}
	
	
		
	

	protected void TitleSearchActionPerformed() {
		String title = this.textField_1.getText();
		List<BookAndBorrow> searchResults = userService.searchBooksByTitleByAdmin(title);
	    fillTableWithSearchResults(searchResults);

	    if (searchResults.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No books found with the title: " + title);
	    }
	}

	private void fillTableWithSearchResults(List<BookAndBorrow> searchResults) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // clear table

		for (BookAndBorrow bookAndBorrow : searchResults) {
			Vector<Object> vector = new Vector<>();

			vector.add(bookAndBorrow.getIsn());
			vector.add(bookAndBorrow.getUser_id());
			vector.add(bookAndBorrow.getTitle());
			vector.add(bookAndBorrow.getAuthor());
			vector.add(bookAndBorrow.getBorrow_date());
			vector.add(bookAndBorrow.getReturn_date());
			vector.add(bookAndBorrow.getPublisher());
			vector.add(bookAndBorrow.getAvailable());

			dtm.addRow(vector);
		}
	}
	}

