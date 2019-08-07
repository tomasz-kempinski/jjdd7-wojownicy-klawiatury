package com.infoshareacademy;

import java.util.List;

public class Book {
    private String kind;
    private String title;
    private boolean hasAudio;
    private List<String> genre;
    private String author;

    public Book() {
    }

    public Book(String kind, String title, boolean hasAudio, List<String> genre, String author) {
        this.kind = kind;
        this.title = title;
        this.hasAudio = hasAudio;
        this.genre = genre;
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
