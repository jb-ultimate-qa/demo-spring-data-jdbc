package my.example.demojdbc;

import my.example.demojdbc.book.Book;
import my.example.demojdbc.book.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJdbcApplication implements CommandLineRunner {

    private final BookService bookService;

    public DemoJdbcApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        checkBookCRUD();
    }

    private void checkBookCRUD() {
        String author = "Marcus Aurelius";
        Book book = bookService.createBook("Meditations", author);

        System.out.println("========================");
        System.out.println("Book is created: " + book);

        System.out.println("\nThe list of books:");
        bookService.findBooksByAuthor(author).forEach(System.out::println);

        bookService.deleteBook(book.getId());
        System.out.println("\nBook is deleted");
        System.out.println("========================");
    }
}
