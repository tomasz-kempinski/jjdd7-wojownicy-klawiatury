package com.infoshareacademy;

public class Book {
    private final String kind;
    private final String fullSortKey;
    private final String title;
    private final String url;
    private final String coverColor;
    private final String epoch;
    private final String href;
    private final String hasAudio;
    private final String genre;

    public Book(String kind, String fullSortKey, String title, String url, String coverColor, String epoch, String href, String hasAudio, String genre) {
        this.kind = kind;
        this.fullSortKey = fullSortKey;
        this.title = title;
        this.url = url;
        this.coverColor = coverColor;
        this.epoch = epoch;
        this.href = href;
        this.hasAudio = hasAudio;
        this.genre = genre;
    }

    public String getKind() {
        return kind;
    }

    public String getFullSortKey() {
        return fullSortKey;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getCoverColor() {
        return coverColor;
    }

    public String getEpoch() {
        return epoch;
    }

    public String getHref() {
        return href;
    }

    public String getHasAudio() {
        return hasAudio;
    }

    public String getGenre() {
        return genre;
    }
}
