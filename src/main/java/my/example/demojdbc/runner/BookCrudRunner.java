package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.book_by_repo.Book;
import my.example.demojdbc.roots.book_by_repo.BookService;
import my.example.demojdbc.roots.book_by_repo.GenreEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class BookCrudRunner {

    @Bean
    @Profile(AppProfile.BOOK)
    public CommandLineRunner loadData(
            BookService bookService) {
        return args -> {
            String author = "Marcus Aurelius";
            Book book = bookService.createBook("Meditations", author, GenreEnum.CLASSICS);

            System.out.println("========================");
            System.out.println("Book is created: " + book);

            System.out.println("\nThe list of books:");
            bookService.findBooksByAuthor(author).forEach(System.out::println);

            var id = book.getId();
            bookService.deleteBook(id);
            System.out.println("\nBook with id=" + id + " is deleted");
            System.out.println("========================");
        };
    }
}
