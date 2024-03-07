package st.libraryspringtask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private int person_id;
    private String name;
    private String author;
    private int yearOfWriting;
}