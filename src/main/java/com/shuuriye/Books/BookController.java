package com.shuuriye.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //get all books
    @GetMapping
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }
    //getbook by id
    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id){
      Book searchedbook =  bookService.getBookById(id);
      if(searchedbook == null)
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("book not found");
      return ResponseEntity.ok(searchedbook);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
}
