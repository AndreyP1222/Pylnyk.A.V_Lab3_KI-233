package ua.cn.stu.lab3.controller;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import ua.cn.stu.lab3.entity.Athlete;
import ua.cn.stu.lab3.service.AthleteService;
import ua.cn.stu.lab3.service.SportService;

@Controller
@RequestMapping("/athletes")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;
    private final SportService sportService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("athletes", athleteService.findAll());
        return "athletes/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Athlete athlete = athleteService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Спортсмена не знайдено з ID: " + id));
        model.addAttribute("athlete", athlete);
        return "athletes/view";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("athlete", new Athlete());
        model.addAttribute("sports", sportService.findAll());
        return "athletes/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Athlete athlete = athleteService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Спортсмена не знайдено з ID: " + id));
        model.addAttribute("athlete", athlete);
        model.addAttribute("sports", sportService.findAll());
        return "athletes/form";
    }

    @PostMapping
    public String save(@ModelAttribute Athlete athlete, @RequestParam Long sportId) {
        athlete.setSport(sportService.findById(sportId)
                .orElseThrow(() -> new NoSuchElementException("Вид спорту не знайдено з ID: " + sportId)));
        athleteService.save(athlete);
        return "redirect:/athletes";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        athleteService.deleteById(id);
        return "redirect:/athletes";
    }
}

