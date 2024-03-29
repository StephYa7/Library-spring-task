package st.libraryspringtask.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.models.Person;
import st.libraryspringtask.repositorys.PeopleRepository;

import java.util.List;

@Log
@Controller
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private final PeopleRepository peopleRepository;

    @GetMapping
    public String showAll(Model model) {
        List<Person> people = peopleRepository.findAll();
        model.addAttribute("people", people);
        return "people/list";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleRepository.getPersonById(id));
        model.addAttribute("books", peopleRepository.getAllPersonBook(id));
        return "people/index";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleRepository.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {

        peopleRepository.update(id, person);

        return "redirect:/people";
    }

    @GetMapping("{id}/update")
    public String redactor(@PathVariable("id") int id, Model model) {
        Person person = peopleRepository.getPersonById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PatchMapping("/new")
    public String create(@ModelAttribute("person") Person person) {
        peopleRepository.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleRepository.delete(id);
        return "redirect:/people";
    }
}