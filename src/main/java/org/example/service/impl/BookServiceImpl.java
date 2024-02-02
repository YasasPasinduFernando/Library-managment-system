package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;

    ModelMapper mapper;

    @Bean
    public void setup(){
        this.mapper=new ModelMapper();
    }
    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);//model mapper බීන් නොදැම්මොත් අවුල්
        bookRepository.save(entity);

    }
    @Override
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }
    @Override
    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return mapper.map(byId, Book.class);
    }
}
