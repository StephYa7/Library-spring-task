package st.libraryspringtask.repository;

import org.springframework.stereotype.Repository;
import st.libraryspringtask.model.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleRepository {
    List<Person> people = new ArrayList<>();

    {
        people.add(new Person(1, "name a1", 1));
        people.add(new Person(2, "name a2", 1));
        people.add(new Person(3, "name a3", 2));
        people.add(new Person(4, "name a4", 2));
        people.add(new Person(5, "name a5", 2));
        people.add(new Person(6, "name a6", 6));
        people.add(new Person(7, "name a7", 7));
        people.add(new Person(8, "name a8", 8));
    }

    public Person getUserById(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().get();
    }

    public List<Person> findAll() {
        return people;
    }


    public void update(int id, Person updatePerson) {
        Person oldPerson = getUserById(id);
        oldPerson.setFullName(updatePerson.getFullName());
        oldPerson.setYearOfBirth(updatePerson.getYearOfBirth());
    }

    public void delete(int id) {
        people.remove(getUserById(id));
    }

    public void save(Person person) {
        System.out.println(person);
        people.add(person);
    }
}