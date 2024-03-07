package st.libraryspringtask.repositorys;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import st.libraryspringtask.configs.DatabaseProperties;
import st.libraryspringtask.models.Book;
import st.libraryspringtask.models.Person;

import java.util.List;

@Repository
@AllArgsConstructor
@PropertySource("classpath:application.yml")

public class PeopleRepository {
    private final JdbcTemplate jdbcTemplate;
    private final DatabaseProperties databaseProperties;


    public List<Person> findAll() {
        return jdbcTemplate.query(databaseProperties.getFindAllPeople(), new PersonMapper());
    }

    public Person save(Person person) {
        jdbcTemplate.update(databaseProperties.getSavePerson(), person.getFullName(), person.getYearOfBirth());
        return person;
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.queryForObject(databaseProperties.getGetPersonById(), new Object[]{id}, new PersonMapper());

    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update(databaseProperties.getUpdatePerson(),
                updatePerson.getFullName(),
                updatePerson.getYearOfBirth(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update(databaseProperties.getDeletePerson(), id);
    }
    public List<Book> getAllPersonBook(int id) {
        return jdbcTemplate.query(databaseProperties.getGetAllPersonBook()
                , new Object[]{id}, new BookMapper());
    }
}