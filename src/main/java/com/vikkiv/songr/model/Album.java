package com.vikkiv.songr.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // list of songs initialized
    @OneToMany(mappedBy = "album")
    List<Song> songs;
    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;

    public Album() {}

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        // construct album with songs as a linked list
        this.songs = new LinkedList<>();
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public List<Song> getSongs() { return songs; }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId() {
        return id;
    }
}
