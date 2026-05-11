package com.deploy.pertemuan6.controller;

import com.deploy.pertemuan6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140079";

    private final List<User> dataList = new ArrayList<>();

    @GetMapping("/")
    public String loginpage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homepage(Model model) {
        model.addAttribute("dataList", dataList); // 🔥 kirim data ke home
        return "home";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userData", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user) {
        dataList.add(user);
        return "redirect:/home"; // 🔥 balik ke home langsung
    }
}
