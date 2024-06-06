package com.bookstore.web.Controller;

import com.bookstore.dao.AdminRepository;
import com.bookstore.dao.ClientRepository;
import com.bookstore.model.Admin;
import com.bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        Optional<Client> clientOptional = clientRepository.findByUsername(username);
        if (clientOptional.isPresent() && clientOptional.get().getPassword().equals(password)) {
            return "redirect:/client/index";
        }


        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent() && adminOptional.get().getPassword().equals(password)) {
            return "redirect:/Admin/index";
        }


        return "redirect:/login?error=true";
    }

    @GetMapping("/client/index")
    public String clientDashboard() {
        return "clientindex";
    }

    @GetMapping("/admin/index")
    public String adminDashboard() {
        return "admin/index";
    }

}

