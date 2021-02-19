package com.l.controller;

import com.l.entity.Book;
import com.l.result.Result;
import com.l.result.ResultFactory;
import com.l.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author l
 */
@RestController
@RequestMapping("/books")
public class LibraryController {
    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Result<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResultFactory.buildSuccessResult(books);
    }
}
