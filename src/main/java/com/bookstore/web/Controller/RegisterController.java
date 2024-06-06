package com.bookstore.web.Controller;

import com.bookstore.dao.ClientRepository;
import com.bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/registerUserAccount")
    public String registerUserAccount(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/login";
    }

}
