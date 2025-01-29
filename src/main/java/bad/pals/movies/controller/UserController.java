package bad.pals.movies.controller;

import bad.pals.movies.model.entities.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/register/submit")
    public String submit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        model.addAttribute("user", user);
        return "registeredUser";
    }
}
