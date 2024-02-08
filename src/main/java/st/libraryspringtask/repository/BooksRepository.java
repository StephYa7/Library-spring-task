package st.libraryspringtask.repository;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import st.libraryspringtask.configs.DatabaseProperties;
import st.libraryspringtask.model.Book;

import java.util.List;

@Repository
@AllArgsConstructor
public class BooksRepository {
    private final JdbcTemplate jdbcTemplate;
    private final DatabaseProperties databaseProperties;

    public List<Book> findAll() {
        return jdbcTemplate.query(databaseProperties.getFindAllBooks(), new BookMapper());
    }

    public Book save(Book book) {
        jdbcTemplate.update(databaseProperties.getSaveBook(), book.getName(), book.getAuthor(), book.getYearOfWriting());
        return book;
    }

    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(databaseProperties.getGetBookById(), new Object[]{id}, new BookMapper());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update(databaseProperties.getUpdateBook(),
                updateBook.getName(),
                updateBook.getAuthor(),
                updateBook.getYearOfWriting(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update(databaseProperties.getDeleteBook(), id);
    }


    public void changePersonIdInBook(int id, int person_id) {
        if (person_id == 0) {
            String set = null;
            jdbcTemplate.update(databaseProperties.getAddPersonInBook(), set, id);
            return;
        }
        jdbcTemplate.update(databaseProperties.getAddPersonInBook(), person_id, id);
    }
}