package st.libraryspringtask.repository;

import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Book;
import st.libraryspringtask.model.Person;

@Repository
public class BookRepository {


    public Book getBookById(int id) {
        return new Book();
    }
}