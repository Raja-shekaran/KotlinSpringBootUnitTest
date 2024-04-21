package com.crud.RestAPI.service

import com.crud.RestAPI.model.Book
import com.crud.RestAPI.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository) {

    fun getAllBooks(): ResponseEntity<List<Book>>
    {
        val books = bookRepository.findAll()
        return if (books != null && books.isNotEmpty()) {
            ResponseEntity(books, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    fun getBookById(id: Long): Book? {
        return bookRepository.findById(id).orElse(null)
    }

    fun addBook(book: Book): Book {
        return bookRepository.save(book)
    }

    fun updateBook(id: Long, updatedBook: Book): Book? {
        val existingBook = getBookById(id)
        return if (existingBook != null) {
            bookRepository.save(updatedBook)
        } else {
            null
        }
    }

    fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }
}