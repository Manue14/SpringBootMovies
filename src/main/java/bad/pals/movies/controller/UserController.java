package bad.pals.movies.controller;

import bad.pals.movies.model.entities.User;
import bad.pals.movies.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/user/register/submit")
    public String submit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        User savedUser = userService.save(user);
        model.addAttribute("user", savedUser);
        return "registeredUser";
    }

    @GetMapping("/user/{id}")
    public String viewUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "userProfile";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }
}
