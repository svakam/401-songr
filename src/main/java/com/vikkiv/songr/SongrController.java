package com.vikkiv.songr;

import com.vikkiv.songr.model.Album;
import com.vikkiv.songr.model.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongrController {

    @Autowired
    AlbumRepository albumRepository;

    // get home route
    @GetMapping("/")
    public String getHome(Model m) {
        return "home";
    }

    // get hello route
    @GetMapping("/hello")
    public String getHello(Model m) {
        return "hello";
    }

    // get capitalize route with variable param
    @GetMapping("/capitalize/{input}")
    public String getCapitalize(@PathVariable String input, Model m) {
        m.addAttribute("input", input.toUpperCase());
        return "capitalized";
    }

    // get albums route
    @GetMapping("/albums")
    public String getAlbums(Model m) {
        List<Album> albumarray = albumRepository.findAll();
        m.addAttribute("albumarray", albumarray);
        return "albums";
    }

    // post added album route
    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    // error
    @GetMapping("/error")
    public String getError() {
        return "error";
    }
}
