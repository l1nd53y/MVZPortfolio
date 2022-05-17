package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.service.GenreService;
import com.l1nd53y.bookstore.model.Genre;
import com.l1nd53y.bookstore.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    //ADD genre
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createGenre(@RequestBody Genre genre) {
        genreService.createGenre(genre);
        return new ResponseEntity<>(new ApiResponse(true, "Genre created."), HttpStatus.CREATED);
    }

    //GET genre
    @GetMapping("/")
    public List<Genre> listGenre() {
        return genreService.listGenre();
    }

    //UPDATE genre
    @PostMapping("/update/{genreId}")
    public ResponseEntity<ApiResponse> updateGenre(@PathVariable("genreId") int genreId, @RequestBody Genre genre ) {
        System.out.println("genre id " + genreId);
        if (!genreService.findById(genreId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Genre does not exist."), HttpStatus.NOT_FOUND);
        }
        genreService.editGenre(genreId, genre);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Updated genre."), HttpStatus.OK);
    }

    //DELETE genre
    @DeleteMapping("/delete/{genreId}")
    public ResponseEntity<ApiResponse> deleteGenre(@PathVariable("genreId") Integer itemId) {

        //Delete item
        genreService.deleteGenre(itemId);
        return new ResponseEntity<>(new ApiResponse(true, "Genre successfully removed from inventory"), HttpStatus.OK);
    }
}
