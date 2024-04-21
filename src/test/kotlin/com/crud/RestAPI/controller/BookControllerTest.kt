package com.crud.RestAPI.controller

import com.crud.RestAPI.model.Book
import com.crud.RestAPI.service.BookService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.ResponseEntity


@ExtendWith(MockitoExtension::class)
class BookControllerTest {

    @Mock
    lateinit var bookService: BookService

    @InjectMocks
    lateinit var bookController: BookController

    @Test
    fun `test getAllBooks`() {
        // Mock service behavior
        val books = listOf(Book(1, "Book 1", "Author 1"), Book(2, "Book 2", "Author 2"))
        `when`(bookService.getAllBooks()).thenReturn(ResponseEntity(books, HttpStatus.OK))

        // Call controller method
        val response: ResponseEntity<List<Book>> = bookController.getAllBooks()

        // Verify response
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)

        // Verify response body
        assertThat(response.body).isEqualTo(books)
    }
}