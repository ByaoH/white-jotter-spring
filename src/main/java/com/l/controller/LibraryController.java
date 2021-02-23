package com.l.controller;

import com.l.entity.Book;
import com.l.result.Result;
import com.l.result.ResultFactory;
import com.l.service.BookService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result<Book> addOrUpdate(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return ResultFactory.buildSuccessResult(book);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @GetMapping("/getByCategoryId/{id}")
    public Result<List<Book>> listByCategoryId(@PathVariable("id") Integer id) {
        if (id <= 0) {
            return list();
        }
        return ResultFactory.buildSuccessResult(bookService.listByCategory(id));
    }
}
