package st.libraryspringtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String name;
    private String author;
    private int yearOfWriting;
}