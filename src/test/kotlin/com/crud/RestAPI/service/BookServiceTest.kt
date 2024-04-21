package com.crud.RestAPI.service

import com.crud.RestAPI.model.Book
import com.crud.RestAPI.repository.BookRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class BookServiceTest {

    @Mock
    lateinit var bookRepository: BookRepository

    @InjectMocks
    lateinit var bookService: BookService

    @Test
    fun `test getBookById`() {
        // Mock repository behavior
        val book = Book(1, "Book 1", "Author 1")
        `when`(bookRepository.findById(1L)).thenReturn(Optional.of(book))

        // Call service method
        val result = bookService.getBookById(1)

        // Verify result
        assertThat(result).isEqualTo(book)
    }
}