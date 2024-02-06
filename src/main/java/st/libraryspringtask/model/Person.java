package st.libraryspringtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    String fullName;
    int yearOfBirth;
}