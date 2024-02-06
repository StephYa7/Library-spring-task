package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.model.Person;
import st.libraryspringtask.repository.PeopleRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private final PeopleRepository peopleRepository;

    @GetMapping
    public String showAll() {

        return "list";
    }

    @GetMapping
    public String indexForm() {
        return "index";
    }

    @PatchMapping("{id}/update")
    public String update() {
        return "redirect:/people";
    }

    @GetMapping("{id}/update")
    public String redactor(@PathVariable("id") int id, Model model) {
        Person person = peopleRepository.getUserById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @PostMapping("/new")
    public String create() {

        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {

        return "redirect:/people";
    }
}