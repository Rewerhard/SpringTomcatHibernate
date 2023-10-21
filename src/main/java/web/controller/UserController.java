package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/form")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value = "user") User user) {
        userService.update(user);
        return "redirect:/";
    }
}
