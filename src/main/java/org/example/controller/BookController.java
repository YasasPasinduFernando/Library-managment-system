package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

   final BookService sevice;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        sevice.addBook(book);
    }

    @GetMapping("/get")
    public Iterable<BookEntity> getBooks(){
        return sevice.getBooks();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBook(@PathVariable Long id){   //මේකෙන් තමා jason covert වන්නෙ.
        sevice.deleteBook(id);
         return "Deleted";
    }
    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return sevice.getBookById(id);

    }

}
