package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.common.ApiResponse;
import com.l1nd53y.bookstore.dto.BookDto;
import com.l1nd53y.bookstore.model.Genre;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.repository.GenreRepo;
import com.l1nd53y.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    GenreRepo genreRepo;

    //ADD book
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createBook(@RequestBody BookDto bookDto) {
        Optional<Genre> optionalGenre = genreRepo.findById(bookDto.getGenreId());
        if (!optionalGenre.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Genre does not exist."), HttpStatus.BAD_REQUEST);
        }
        bookService.createBook(bookDto, optionalGenre.get());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Book has been added."), HttpStatus.CREATED);
    }

    //GET books
    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //UPDATE book
    @PostMapping("/update/{bookId}")
    public ResponseEntity<ApiResponse> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody BookDto bookDto) throws Exception {
        Optional<Genre> optionalGenre = genreRepo.findById(bookDto.getGenreId());
        if (!optionalGenre.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Genre does not exist."), HttpStatus.BAD_REQUEST);
        }
        bookService.updateBook(bookDto, bookId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Book has been updated."), HttpStatus.OK);
    }

    //DELETE book
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable("bookId") Integer itemId) {

        //Delete item
        bookService.deleteBook(itemId);
        return new ResponseEntity<>(new ApiResponse(true, "Book successfully removed from inventory"), HttpStatus.OK);
    }
}
