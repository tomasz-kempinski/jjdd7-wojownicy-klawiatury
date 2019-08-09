package com.infoshareacademy;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "title",
        "author",
        "has_audio",
        "genre",
})
public class Book {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("has_audio")
    private Boolean hasAudio;
    @JsonProperty("genre")
    private String genre;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<> ( );

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("has_audio")
    public Boolean getHasAudio() {
        return hasAudio;
    }

    @JsonProperty("has_audio")
    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put (name, value);
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nkind='" + kind + '\'' +
                "\ntitle='" + title + '\'' +
                "\nauthor='" + author + '\'' +
                "\nhasAudio=" + hasAudio +
                "\ngenre='" + genre + '\'' +
                "\n}";
    }
}