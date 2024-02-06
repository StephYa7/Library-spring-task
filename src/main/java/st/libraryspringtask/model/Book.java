package st.libraryspringtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    String name;
    String author;
    int yearOfWriting;
}