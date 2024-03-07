package st.libraryspringtask.configs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import st.libraryspringtask.utils.sortStrategy.SortByIdStrategy;
import st.libraryspringtask.utils.sortStrategy.SortByYearOfWritingStrategy;
import st.libraryspringtask.utils.sortStrategy.SortingStrategy;

@Configuration
@EnableConfigurationProperties(DatabaseProperties.class)
public class AppConfig {
    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}