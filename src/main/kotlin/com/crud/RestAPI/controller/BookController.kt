package com.crud.RestAPI.controller

import com.crud.RestAPI.model.Book
import com.crud.RestAPI.repository.BookRepository
import com.crud.RestAPI.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController @Autowired constructor(private val bookService: BookService) {

    @GetMapping("/")
    fun getAllBooks(): ResponseEntity<List<Book>> {
        return bookService.getAllBooks()
    }

    @PostMapping("/")
    fun addBook(@RequestBody book: Book): Book {
        bookService.addBook(book)
        return book
    }
    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book? {
        return bookService.getBookById(id)
    }
    @GetMapping("/{id}")
    fun getNameById(@PathVariable id: Long): String? {
        return bookService.getNameById(id)
    }
    @PutMapping("/{id}")
    fun updateBookById(@PathVariable id: Long, @RequestBody updatedBook: Book): Book? {
        return bookService.updateBook(id, updatedBook)
    }
    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: Long) {
        return bookService.deleteBook(id)
    }
}
