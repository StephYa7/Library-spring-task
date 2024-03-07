package st.libraryspringtask.repositorys;


import org.springframework.jdbc.core.RowMapper;
import st.libraryspringtask.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("person_id"));
        person.setFullName(resultSet.getString("fullName"));
        person.setYearOfBirth(resultSet.getInt("yearOfBirth"));

        return person;
    }
}