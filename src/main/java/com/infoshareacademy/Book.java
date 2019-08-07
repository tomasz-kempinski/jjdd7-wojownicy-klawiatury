package com.infoshareacademy;

public class Book {
    private String kind;
    private String title;
    private boolean hasAudio;
    private String genre;
    private String author;

    public Book() {
    }

    public Book(String author, String kind, String title, boolean hasAudio, String genre) {
        this.author = author;
        this.kind = kind;
        this.title = title;
        this.hasAudio = hasAudio;
        this.genre = genre;
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

    public boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isHasAudio() {
        return hasAudio;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
