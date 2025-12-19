package my.example.demojdbc.roots.book_by_repo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    private Long id;
    private String title;
    private String author;

    @Override
    public String toString() {
        return "Book{ title: " + title + ", author: " + author + "}";
    }
}
