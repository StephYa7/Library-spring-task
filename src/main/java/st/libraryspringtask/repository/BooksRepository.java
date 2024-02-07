package st.libraryspringtask.repository;

import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Book;
import st.libraryspringtask.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksRepository {
    List<Book> books = new ArrayList<>();

    {
        books.add(new Book(1,"BookName a1", "Author b1", 1));
        books.add(new Book(2,"BookName a2", "Author b2", 1));
        books.add(new Book(3,"BookName a3", "Author b3", 1));
        books.add(new Book(4,"BookName a4", "Author b4", 1));
        books.add(new Book(5,"BookName a5", "Author b5", 1));
        books.add(new Book(6,"BookName a6", "Author b6", 1));
        books.add(new Book(7,"BookName a7", "Author b7", 1));
        books.add(new Book(8,"BookName a8", "Author b8", 1));
    }


    public Book getBookById(int id) {
        return books.get(id);
    }

    public List<Book> findAll() {
        return books;
    }


    public void update(int id, Book updateBook) {
        Book oldBook = getBookById(id);
        oldBook.setName(updateBook.getName());
        oldBook.setAuthor(updateBook.getAuthor());
        oldBook.setYearOfWriting(updateBook.getYearOfWriting());
    }

    public void delete(int id) {
        books.remove(getBookById(id));
    }

    public void save(Book book) {
        System.out.println(book);
        books.add(book);
    }
}