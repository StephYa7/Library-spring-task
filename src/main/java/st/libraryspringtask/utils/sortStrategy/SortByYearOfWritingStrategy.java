package st.libraryspringtask.utils.sortStrategy;

import org.springframework.stereotype.Component;
import st.libraryspringtask.models.Book;

import java.util.Comparator;
import java.util.List;

@Component("byYearOfWriting")
public class SortByYearOfWritingStrategy implements SortingStrategy<Book> {
    @Override
    public void sort(List<Book> books) {
        books.sort(Comparator.comparingInt(Book::getYearOfWriting));
    }
}