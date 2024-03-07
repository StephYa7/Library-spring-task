package st.libraryspringtask.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.models.Book;
import st.libraryspringtask.models.Person;
import st.libraryspringtask.repositorys.BooksRepository;
import st.libraryspringtask.repositorys.PeopleRepository;
import st.libraryspringtask.services.FileGateway;
import st.libraryspringtask.utils.sortStrategy.SortingStrategy;

import java.time.LocalDateTime;
import java.util.List;

@Log
@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksRepository bookRepository;
    private final PeopleRepository peopleRepository;
    private SortingStrategy byYearOfWriting;
    private FileGateway fileGateway;

    @GetMapping
    public String showAll(Model model) {
        List<Book> books = bookRepository.findAll();
        byYearOfWriting.sort(books);
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
        bookRepository.changePersonIdInBook(id, 0);

        LocalDateTime date = LocalDateTime.now();
        fileGateway.writeToFile("whenBookBack.txt",
                bookRepository.getBookById(id).getName() + " вернули " + date);
        return "redirect:/books/{id}";
    }

    @PatchMapping("/{id}/addPerson")
    public String addPersonInBook(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        LocalDateTime date = LocalDateTime.now();
        fileGateway.writeToFile("whoTakeBook.txt",
                bookRepository.getBookById(id).getName() +
                        " взял пользователь с id: " + person.getId() +
                        " " + date);
        bookRepository.changePersonIdInBook(id, person.getId());
        return "redirect:/books/{id}";
    }
}