package my.example.demojdbc.book;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    // has methods save(), count(), findById(), findAll(), deleteById() etc.


    Optional<Book> findByTitle(String title);
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByTitleContaining(String fragment);

    @Query("select * from book where title like :titlePattern")
    List<Book> findBooksByTitle(String titlePattern);

    @Query("select * from book where author = :author order by title limit 10")
    List<Book> findTop10ByAuthor(String author);

    @Modifying
    @Query("update book set title = :title where id = :id")
    void updateTitle(@Param("id") Long id, @Param("title") String title);
}
