package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    // Show portfolio page
    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio"; // looks for templates/portfolio.html
    }
}

