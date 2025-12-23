package ua.cn.stu.lab3.controller;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import ua.cn.stu.lab3.entity.Olympiad;
import ua.cn.stu.lab3.service.OlympiadService;

@Controller
@RequestMapping("/olympiads")
@RequiredArgsConstructor
public class OlympiadController {

    private final OlympiadService olympiadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("olympiads", olympiadService.findAllOrderByYearDesc());
        return "olympiads/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Olympiad olympiad = olympiadService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Олімпіаду не знайдено з ID: " + id));
        model.addAttribute("olympiad", olympiad);
        return "olympiads/view";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("olympiad", new Olympiad());
        return "olympiads/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Olympiad olympiad = olympiadService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Олімпіаду не знайдено з ID: " + id));
        model.addAttribute("olympiad", olympiad);
        return "olympiads/form";
    }

    @PostMapping
    public String save(@ModelAttribute Olympiad olympiad) {
        olympiadService.save(olympiad);
        return "redirect:/olympiads";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        olympiadService.deleteById(id);
        return "redirect:/olympiads";
    }
}

