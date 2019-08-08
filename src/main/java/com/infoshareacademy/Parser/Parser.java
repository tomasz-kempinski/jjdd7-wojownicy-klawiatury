package com.infoshareacademy.Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(value = {"full_sort_key", "url", "cover_color", "cover", "epoch", "href", "simple_thumb", "slug", "cover_thumb", "liked"})

public class Parser {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Book> books = mapper.readValue(new File("books.json"), new TypeReference<List<Book>>() {
        });

        System.out.println(books);
    }
}
