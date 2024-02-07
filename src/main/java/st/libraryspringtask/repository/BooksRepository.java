package st.libraryspringtask.repository;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Book;

import java.util.List;

@Repository
@AllArgsConstructor
public class BooksRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        var a= jdbcTemplate.query(sql, new BookMapper());
        System.out.println(a);
        return a;
    }

    public Book save(Book book) {
        String sql = "INSERT INTO books (name,author,yearOfWriting) VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getYearOfWriting());
        return book;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookMapper());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE books SET name=?, author=?, yearOfWriting=? WHERE book_id=?",
                updateBook.getName(),
                updateBook.getAuthor(),
                updateBook.getYearOfWriting(),
                id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM books WHERE book_id=?";
        jdbcTemplate.update(sql, id);
    }
}