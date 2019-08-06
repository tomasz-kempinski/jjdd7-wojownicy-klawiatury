package com.infoshareacademy;

public class Book {
    private String kind;
    private String title;
    private String hasAudio;
    private String genre;
    private String author;

    public Book() {
    }

    public Book(String kind, String title, String hasAudio, String genre, String author) {
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

    public String getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(String hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
