package st.libraryspringtask.repository;


import org.springframework.jdbc.core.RowMapper;
import st.libraryspringtask.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("book_id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setYearOfWriting(resultSet.getInt("yearOfWriting"));

        return book;
    }
}