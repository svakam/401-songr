package com.vikkiv.songr.model;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String title;
    int length;
    int trackNumber;

    // the name of this instance variable is used as the mappedBy value in the Album class
    @ManyToOne
    Album album;

    public Song() {}

    public Song(String title, int length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public void setEntry(Album album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
}
