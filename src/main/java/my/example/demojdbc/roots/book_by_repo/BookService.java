package my.example.demojdbc.roots.book_by_repo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book createBook(String title, String author) {
        Book book = new Book(null, title, author, null);
        return bookRepository.save(book);
    }

    @Transactional
    public Book createBook(String title, String author, GenreEnum genreEnum) {
        Book book = new Book(null, title, author, genreEnum);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    @Transactional
    public void updateTitle(Long id, String newTitle) {
        Book book = getBookById(id);
        book.setTitle(newTitle);
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
    }

}
