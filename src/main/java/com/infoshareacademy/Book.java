package com.infoshareacademy;

public class Book extends Author {
    private String kind;
    private String title;
    private boolean hasAudio;
    private String genre;

    public Book() {
    }

    public Book(String authorName, String kind, String title, boolean hasAudio, String genre, String author) {
        super(authorName);
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

}
