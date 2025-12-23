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
import ua.cn.stu.lab3.entity.Sport;
import ua.cn.stu.lab3.service.OlympiadService;
import ua.cn.stu.lab3.service.SportService;

@Controller
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {

    private final SportService sportService;
    private final OlympiadService olympiadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sports", sportService.findAll());
        return "sports/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Sport sport = sportService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Вид спорту не знайдено з ID: " + id));
        model.addAttribute("sport", sport);
        return "sports/view";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("sport", new Sport());
        model.addAttribute("olympiads", olympiadService.findAllOrderByYearDesc());
        return "sports/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Sport sport = sportService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Вид спорту не знайдено з ID: " + id));
        model.addAttribute("sport", sport);
        model.addAttribute("olympiads", olympiadService.findAllOrderByYearDesc());
        return "sports/form";
    }

    @PostMapping
    public String save(@ModelAttribute Sport sport, @RequestParam Long olympiadId) {
        sport.setOlympiad(olympiadService.findById(olympiadId)
                .orElseThrow(() -> new NoSuchElementException("Олімпіаду не знайдено з ID: " + olympiadId)));
        sportService.save(sport);
        return "redirect:/sports";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        sportService.deleteById(id);
        return "redirect:/sports";
    }
}

