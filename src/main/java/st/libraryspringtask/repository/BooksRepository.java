package st.libraryspringtask.repository;

import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksRepository {
    List<Book> books = new ArrayList<>();

    {
        books.add(new Book("BookName a1", "Author b1", 1));
        books.add(new Book("BookName a2", "Author b2", 1));
        books.add(new Book("BookName a3", "Author b3", 1));
        books.add(new Book("BookName a4", "Author b4", 1));
        books.add(new Book("BookName a5", "Author b5", 1));
        books.add(new Book("BookName a6", "Author b6", 1));
        books.add(new Book("BookName a7", "Author b7", 1));
        books.add(new Book("BookName a8", "Author b8", 1));
    }


    public Book getBookById(int id) {
        return books.get(id);
    }

    public List<Book> findAll() {
        return books;
    }
}