package com.yc.jdbc.view;

import com.yc.jdbc.dao.UserDAO;
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

public class MyBooks extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private UserService userService = new UserService();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyBooks frame = new MyBooks();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MyBooks(String userId) {
		setClosable(true);
		setIconifiable(true);
		setTitle("MyBooks");
		setBounds(100, 100, 1063, 587);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblBorrowDate = new JLabel("Publisher");
		lblBorrowDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//monitor the fill title by search
				TitleSearchActionPerformed();
			}
		});
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthorSearchActionPerformed();
			}
		});
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublisherSearchActionPerformed();
			}
		});
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleSearchActionPerformed();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setForeground(new Color(0, 191, 255));
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String bookId = table.getValueAt(selectedRow, 0).toString();
					int available = (int) table.getValueAt(selectedRow, 5);
					if (available == 0) {
						if (userService.borrowBook(userId, bookId)) {
							JOptionPane.showMessageDialog(null, "Borrowed successfully!");
							// 更新表格中的available列为1
							table.setValueAt(1, selectedRow, 5);
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
		btnBorrow.setFont(new Font("Bahnschrift", btnBorrow.getFont().getStyle() | Font.BOLD, 20));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(new Color(0, 191, 255));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int ISN = (int) table.getValueAt(selectedRow, 0);
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
		btnReturn.setFont(new Font("Bahnschrift", btnReturn.getFont().getStyle() | Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthorSearchActionPerformed();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublisherSearchActionPerformed();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBorrowDate, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(47)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnReturn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBorrow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBorrowDate, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBorrow, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnReturn, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
							.addGap(14)))
					.addGap(110))
		);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISN", "Book Name", "Author", "Borrow Date", "Publisher", "Available"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable(userId);

	}

	private void PublisherSearchActionPerformed() {
		String publisher = this.textField_2.getText();
		List<Books> searchResults = userService.searchBooksByPublisher(publisher);
		fillTableWithPublishSearch(searchResults);
		if (searchResults.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No books found with the publisher: " + publisher);
		}
	}

	private void fillTableWithPublishSearch(List<Books> searchResults) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // clear table

		for (Books book : searchResults) {
			Vector<Object> vector = new Vector<>();

			vector.add(book.getIsn());
			vector.add(book.getTitle());
			vector.add(book.getAuthor());
			vector.add(book.getBook_id());
			vector.add(book.getPublisher());
			vector.add(book.getAvailable());

			dtm.addRow(vector);
		}
	}

	private void AuthorSearchActionPerformed() {
		String author = this.textField_1.getText();
		List<Books> searchResults = userService.searchBooksByAuthor(author);
		fillTableWithAuthorSearch(searchResults);
		if (searchResults.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No books found with the author: " + author);
		}
	}

	private void fillTableWithAuthorSearch(List<Books> searchResults) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // clear table

		for (Books book : searchResults) {
			Vector<Object> vector = new Vector<>();

			vector.add(book.getIsn());
			vector.add(book.getTitle());
			vector.add(book.getAuthor());
			vector.add(book.getBook_id());
			vector.add(book.getPublisher());
			vector.add(book.getAvailable());

			dtm.addRow(vector);
		}
	}

	protected void TitleSearchActionPerformed() {
		//get input title
		String title = this.textField.getText();
		List<Books> searchResults = userService.searchBooksByTitle(title);
	    fillTableWithSearchResults(searchResults);

	    if (searchResults.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No books found with the title: " + title);
	    }
	}

	private void fillTableWithSearchResults(List<Books> searchResults) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // clear table

		for (Books book : searchResults) {
			Vector<Object> vector = new Vector<>();

			vector.add(book.getIsn());
			vector.add(book.getTitle());
			vector.add(book.getAuthor());
			vector.add(book.getBook_id());
			vector.add(book.getPublisher());
			vector.add(book.getAvailable());

			dtm.addRow(vector);
		}
	}

	/*
	 * initial table
	 */
	public void fillTable(String userId) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		List<BookAndBorrow> bookAndBorrows = UserDAO.listBook(userId);
		for(BookAndBorrow bookAndBorrow : bookAndBorrows) {
			Vector<Object> vector = new Vector<>();
			
			vector.add(bookAndBorrow.getIsn());
			vector.add(bookAndBorrow.getTitle());
			vector.add(bookAndBorrow.getAuthor());
			vector.add(bookAndBorrow.getBorrow_date());
//			vector.add(bookAndBorrow.getPublisher());
//			vector.add(bookAndBorrow.getAvailable());
			dtm.addRow(vector);

		}
 	}
}
