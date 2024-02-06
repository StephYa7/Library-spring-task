package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.model.Book;
import st.libraryspringtask.model.Person;
import st.libraryspringtask.repository.BooksRepository;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksRepository bookRepository;

//    @GetMapping
//    public String showAll(Model model) {
//        List<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
//        return "list";
//    }

//    @GetMapping
//    public String index() {
//        return "index";
//    }
//
//    @PatchMapping("{id}/update")
//    public String update() {
//        return "redirect:/books";
//    }
//
//    @GetMapping("{id}/update")
//    public String redactor(@PathVariable("id") int id, Model model) {
//        Book book = bookRepository.getBookById(id);
//        model.addAttribute("person", book);
//        return "update";
//    }
//
//    @PostMapping("/new")
//    public String create() {
//
//        return "redirect:/books";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//
//        return "redirect:/books";
//    }
}