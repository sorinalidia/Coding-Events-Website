package org.launchcode.hellospring.controllers;

import jakarta.validation.Valid;
import org.launchcode.hellospring.data.EventCategoryRepository;
import org.launchcode.hellospring.models.Event;
import org.launchcode.hellospring.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping()
    public String displayAllCategories(Model model){
        model.addAttribute("title","All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }
    @GetMapping("create")
    public String renderCreateCategory(Model model){
        model.addAttribute("title","Create Category");
        model.addAttribute(new EventCategory());
        model.addAttribute("categories",eventCategoryRepository.findAll());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String createCategory(@ModelAttribute @Valid EventCategory newEventCategory, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Create Category");
            return "eventCategories/create";
        }
        eventCategoryRepository.save(newEventCategory);
        return "redirect:/eventCategories";
    }

}
