package com.crud.RestAPI.repository

import com.crud.RestAPI.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>
