package com.shuuriye.Books;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    Map<Long , Book> books = new ConcurrentHashMap<>();
    AtomicLong counter = new AtomicLong();

    //methods
    public Collection<Book> getBooks(){
        return books.values();
    }

    public Book getBookById(Long id){
        return books.get(id);
    }

    //save
    public Book saveBook(Book book){
        Long id = book.getId() != null ? book.getId() : counter.incrementAndGet();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    //delete
    public Book deleteBook(Long id){
        return books.remove(id);
    }

    //update
    public Book updateBook(Long id , Book bookDetails){
        if(books.containsKey(id)){
            Book oldBook = books.get(id);

            oldBook.setTitle(bookDetails.getTitle());
            oldBook.setAuthor(bookDetails.getAuthor());

            books.put(id, oldBook);
            return oldBook;
        }
        return null;
    }
}
