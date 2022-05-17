package com.l1nd53y.bookstore.service;

import com.l1nd53y.bookstore.dto.BookDto;
import com.l1nd53y.bookstore.exceptions.CustomException;
import com.l1nd53y.bookstore.exceptions.ProductNotExistException;
import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.Genre;
import com.l1nd53y.bookstore.model.WishList;
import com.l1nd53y.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    public void createBook(BookDto bookDto, Genre genre) {
        Book book = new Book();
        book.setDescription(bookDto.getDescription());
        book.setImageURL(bookDto.getImageURL());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(genre);
        book.setPrice(bookDto.getPrice());
        bookRepo.save(book);
    }

    public BookDto getBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setDescription(book.getDescription());
        bookDto.setImageURL(book.getImageURL());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setGenreId(book.getGenre().getId());
        bookDto.setPrice(book.getPrice());
        bookDto.setId(book.getId());
        return bookDto;
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepo.findAll();

        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book: allBooks) {
            bookDtos.add(getBookDto(book));
        }
        return bookDtos;
    }

    public void updateBook(BookDto bookDto, Integer bookId) throws Exception {
        Optional<Book> optionalBook = bookRepo.findById(bookId);
        // throw an exception if book does not exist
        if (!optionalBook.isPresent()) {
            throw new Exception("Book does not exist.");
        }
        Book book = optionalBook.get();
        book.setDescription(bookDto.getDescription());
        book.setImageURL(bookDto.getImageURL());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        bookRepo.save(book);
    }

    public Book findById(Integer bookId) throws ProductNotExistException {
        Optional<Book> optionalBook = bookRepo.findById(bookId);
        if(optionalBook.isEmpty()) {
            throw new ProductNotExistException("Product ID is invalid: " + bookId);
        }
        return optionalBook.get();
    }

    public void deleteBook(Integer bookId) {
        //Checks if item ID belongs to user
        Optional<Book> optionalBook = bookRepo.findById(bookId);

        if (optionalBook.isEmpty()) {
            throw new CustomException("Book ID is invalid: " +bookId);
        }

        Book book = optionalBook.get();

        bookRepo.delete(book);
    }
}
