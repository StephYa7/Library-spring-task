package st.libraryspringtask.repository;

import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Person;

@Repository
public class PeopleRepository {
    public Person getUserById(int id) {
        return new Person();
    }
}