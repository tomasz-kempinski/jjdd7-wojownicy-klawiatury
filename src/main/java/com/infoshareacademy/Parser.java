package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(value = {"full_sort_key", "url", "cover_color", "cover", "epoch", "href", "simple_thumb", "slug", "cover_thumb", "liked"})
class Parser {
    private static List<Book> books;
    public void parseFileToObjects() {
        ObjectMapper mapper = new ObjectMapper ( );

        try {
            books = mapper.readValue (new File (Objects.requireNonNull (getClass ( ).getClassLoader ( ).getResource ("books.json")).getFile ( )), new TypeReference<List<Book>> ( ) {
            });
        } catch (IOException e) {
            System.out.println ("Problem with IO occurred");
        } catch (NullPointerException n) {
            System.out.println ("Problem with NullPointerException");
        }
    }

    public static List<Book> getBooks() {
        return books;
    }
}