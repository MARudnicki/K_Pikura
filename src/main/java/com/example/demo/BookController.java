package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
@RequestMapping("book")
public class BookController {

    BookDao bookDao;

    @PostMapping
    BookDto create(@RequestBody BookDto bookDto) {

        Book book = new Book();
        book.setValue(bookDto.getValue());

        bookDao.save(book);

        return bookDto;
    }

    @GetMapping
    List<BookDto> getAll() {

        return StreamSupport
                .stream(bookDao.findAll().spliterator(), false)
                .map(b ->
                        new BookDto() {{
                            setValue(b.getValue());
                        }})
                .collect(Collectors.toList());
    }

}
