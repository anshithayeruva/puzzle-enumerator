package com.example.puzzleenumerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    PuzzleService service = new PuzzleService();

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/solve")
    public String solve(@RequestParam String elements,
                        @RequestParam String constraints,
                        Model model) {

        var solutions = service.generateSolutions(elements, constraints);

        model.addAttribute("solutions", solutions);
        model.addAttribute("count", solutions.size());
        model.addAttribute("constraints", service.constraintMessages);

        return "index"; // 🔥 SAME PAGE
    }
}
