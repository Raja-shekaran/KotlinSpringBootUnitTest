package com.crud.RestAPI.repository

import com.crud.RestAPI.model.Book
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Test
    fun `test findById`() {
        // Create test data
        val book = Book(title = "Book 1", author = "Author 1")
        val savedBook = bookRepository.save(book)

        // Retrieve book from the database
        val retrievedBook = bookRepository.findById(savedBook.id).orElse(null)

        // Verify that the retrieved book is not null
        assertThat(retrievedBook).isNotNull

        // Verify the properties of the retrieved book
        assertThat(retrievedBook?.title).isEqualTo("Book 1")
        assertThat(retrievedBook?.author).isEqualTo("Author 1")
    }
}
