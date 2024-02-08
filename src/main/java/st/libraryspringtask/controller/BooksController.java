package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.model.Book;
import st.libraryspringtask.model.Person;
import st.libraryspringtask.repository.BooksRepository;
import st.libraryspringtask.repository.PeopleRepository;

import java.util.List;

@Log
@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksRepository bookRepository;
    private final PeopleRepository peopleRepository;

    @GetMapping
    public String showAll(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookRepository.getBookById(id));
        model.addAttribute("people", peopleRepository.findAll());
        model.addAttribute("person", new Person());
        return "books/index";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookRepository.getBookById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book,
                         @PathVariable("id") int id) {
        bookRepository.update(id, book);

        return "redirect:/books";
    }

    @GetMapping("{id}/update")
    public String redactor(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.getBookById(id);
        model.addAttribute("book", book);
        return "update";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PatchMapping("/new")
    public String create(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookRepository.delete(id);

        return "redirect:/books";
    }

    @PostMapping("/{id}")
    public String delPersonFromBook(@PathVariable("id") int id) {
        bookRepository.removePersonId(id);
        return "redirect:/books/{id}";
    }

    @PatchMapping("/{id}/addPerson")
    public String addPersonInBook(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        bookRepository.addPersonInBook(id, person.getId());
        return "redirect:/books/{id}";
    }
}