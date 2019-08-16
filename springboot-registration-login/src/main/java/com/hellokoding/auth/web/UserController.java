package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.ProductService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {
    ProductService productService = new ProductService();

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        ArrayList<Product> a = productService.getList();
        model.addAttribute("listaProduselor", a);
        return "welcome";
    }

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public String home(Model model) {
        ArrayList<Product> a = productService.getList();
        model.addAttribute("listaProduselor", a);
        return "navbar";
    }

    @RequestMapping(value = "/searchProducts")
    public String listSearchProducts(@RequestParam("nume") String nume, Model mo) {
        ArrayList<Product> b = productService.Search(nume, "pret-crescator", 0.00, 9.99);
        mo.addAttribute("listaCautata", b);
        return "listproducts";
    }


   /* @RequestMapping(value = "/sortedList", method = RequestMethod.GET)
    public String so(Model mo) {
        ArrayList<Product> b = productService.Search("Iaurtel", "pret-crescator", 0.00, 9.99);
        mo.addAttribute("listaCautata", b);
        return "listproducts";
    }*/
}
