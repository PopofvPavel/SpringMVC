package com.example.controller;

import com.example.model.Director;
import com.example.repository.DirectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/director")
public class DirectorController {

    DirectorsRepository directorsRepository;

    @Autowired
    public void setDirectorsRepository(DirectorsRepository directorsRepository) {
        this.directorsRepository = directorsRepository;
    }

    @GetMapping
    public String showDirectorsPage(Model model) {
        model.addAttribute("directors", directorsRepository.getDirectors());
        return "directors-page";
    }

    @GetMapping("/add")
    public String showAddDirectorPage(Model model) {
        Director director = new Director();
        model.addAttribute("director", director);
        return "add_director";
    }

    @PostMapping("/add")
    public String showDirectorsPageOnAddDirector(@ModelAttribute("director") Director director) {
        System.out.println("In post method");
        directorsRepository.addDirector(director);
        return "redirect:/director";
    }
}
