package st.libraryspringtask.utils.sortStrategy;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
@Qualifier
public interface SortingStrategy<T> {
    void sort(List<T> list);
}