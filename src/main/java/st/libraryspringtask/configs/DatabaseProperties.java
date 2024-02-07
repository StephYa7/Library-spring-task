package st.libraryspringtask.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {
    private String findAllPeople;
    private String savePerson;
    private String getPersonById;
    private String updatePerson;
    private String deletePerson;
    private String findAllBooks;
    private String saveBook;
    private String getBookById;
    private String updateBook;
    private String deleteBook;
}