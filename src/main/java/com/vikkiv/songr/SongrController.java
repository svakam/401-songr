package com.vikkiv.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongrController {

    @GetMapping("/")
    public String getHome(Model m) {
            m.addAttribute("username", "Vik");
        return "home";
    }
}

