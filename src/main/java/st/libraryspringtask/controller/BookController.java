package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import st.libraryspringtask.repository.LibraryRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class BookController {
    private final LibraryRepository libraryRepository;



}