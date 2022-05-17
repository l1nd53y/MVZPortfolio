package com.l1nd53y.bookstore.service;

import com.l1nd53y.bookstore.exceptions.CustomException;
import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.Genre;
import com.l1nd53y.bookstore.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    GenreRepo genreRepo;
    public void createGenre(Genre genre) {
        genreRepo.save(genre);
    }

    public List<Genre> listGenre() {
        return genreRepo.findAll();
    }

    public void editGenre(int genreId, Genre updateGenre) {
        Genre genre = genreRepo.getById(genreId);
        genre.setGenreName(updateGenre.getGenreName());
        genre.setDescription(updateGenre.getDescription());
        genre.setImageUrl(updateGenre.getImageUrl());
        genreRepo.save(genre);
    }

    public boolean findById(int genreId) {
        return genreRepo.findById(genreId).isPresent();
    }

    public void deleteGenre(Integer genreId) {
        //Checks if item ID belongs to user
        Optional<Genre> optionalGenre = genreRepo.findById(genreId);

        if (optionalGenre.isEmpty()) {
            throw new CustomException("Genre ID is invalid: " +genreId);
        }

        Genre genre = optionalGenre.get();

        genreRepo.delete(genre);
    }
}
