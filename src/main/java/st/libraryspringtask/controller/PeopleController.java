package st.libraryspringtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import st.libraryspringtask.model.Person;
import st.libraryspringtask.repository.PeopleRepository;

import java.util.List;

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
        model.addAttribute("person", peopleRepository.getUserById(id));
        return "people/index";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleRepository.getUserById(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {

        peopleRepository.update(id, person);

        return "redirect:/people";
    }

    @GetMapping("{id}/update")
    public String redactor(@PathVariable("id") int id, Model model) {
        Person person = peopleRepository.getUserById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        System.out.println("new form method called");
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("person") Person person) {
        System.out.println("create method");
        peopleRepository.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleRepository.delete(id);
        return "redirect:/people";
    }
}