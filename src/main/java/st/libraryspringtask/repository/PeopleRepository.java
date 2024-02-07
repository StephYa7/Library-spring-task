package st.libraryspringtask.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Person;

import java.util.List;

@Repository
@AllArgsConstructor
public class PeopleRepository {
    private final JdbcTemplate jdbcTemplate;


    public List<Person> findAll() {
        String sql = "SELECT * FROM people";
        var a = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(a);
        return a;
    }

    public Person save(Person person) {
        String sql = "INSERT INTO people (fullName,yearOfBirth) VALUES (?, ?)";
        jdbcTemplate.update(sql, person.getFullName(), person.getYearOfBirth());
        return person;
    }

    public Person getPersonById(int id) {
        String sql = "SELECT * FROM people WHERE person_id = ?";
        jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonMapper());
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonMapper());

    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE people SET fullName=?, yearOfBirth=? WHERE person_id=?",
                updatePerson.getFullName(),
                updatePerson.getYearOfBirth(),
                id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM people WHERE person_id=?";
        jdbcTemplate.update(sql, id);
    }
}