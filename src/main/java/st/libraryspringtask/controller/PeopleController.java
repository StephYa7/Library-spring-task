package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import st.libraryspringtask.repository.LibraryRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private final LibraryRepository libraryRepository;

    @GetMapping
    public String showAll() {
        return "list";
    }
}