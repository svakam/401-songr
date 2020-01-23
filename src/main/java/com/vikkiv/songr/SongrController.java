package com.vikkiv.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongrController {

    // home route
    @GetMapping("/")
    public String getHome(Model m) {
        return "home";
    }

    // hello route
    @GetMapping("/hello")
    public String getHello(Model m) {
        return "hello";
    }

    // capitalize route with variable param
    @GetMapping("/capitalize/{input}")
    public String getCapitalize(@PathVariable String input, Model m) {
        m.addAttribute("input", input.toUpperCase());
        return "capitalized";
    }

    // albums route
    @GetMapping("/albums")
    public String getAlbums(Model m) {
        // image links are possible thanks to Wikipedia
        Album[] albumarray = {
                new Album("Rubber Soul", "The Beatles", 13, 20489, "https://upload.wikimedia.org/wikipedia/en/7/74/Rubber_Soul.jpg"),
                new Album("1984", "Van Halen", 8, 19383, "https://upload.wikimedia.org/wikipedia/en/5/5f/Van_Halen_-_1984.jpg"),
                new Album("Currents", "Tame Impala", 10, 18372, "https://upload.wikimedia.org/wikipedia/en/9/9b/Tame_Impala_-_Currents.png"),
        };
        m.addAttribute("albumarray", albumarray);
        return "albums";
    }
}
