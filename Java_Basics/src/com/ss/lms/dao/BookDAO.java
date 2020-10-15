/**
 * 
 */
package com.ss.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Book;
import com.ss.lms.entity.Book;

/**
 * @book ppradhan
 *
 */
public class BookDAO extends BaseDAO<Book>{

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book (title) VALUES (?)", new Object[] { book.getTitle() });
	}

	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		save("UPDATE tbl_book SET bookName = ? WHERE bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });
	}

	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		save("DELETE FROM tbl_book WHERE bookId = ?", new Object[] { book.getBookId() });
	}

	public List<Book> readAllBooks() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM tbl_book", null);
	}
	
	public List<Book> readAllBooksByName(String searchString) throws SQLException, ClassNotFoundException {
		searchString = "%"+searchString+"%";
		return read("SELECT * FROM tbl_book WHERE title LIKE ?", new Object[] {searchString});
	}

	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			books.add(new Book(rs.getInt("bookId"), rs.getString("title")));
		}
		return books;
	}
}
