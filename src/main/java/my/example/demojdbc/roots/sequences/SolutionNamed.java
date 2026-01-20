package my.example.demojdbc.roots.sequences;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Sequence;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("solution_named")
public class SolutionNamed {
    @Id
    @Sequence(value = "solution_named_seq", schema = "public")
    private Long id;

    private String description;

    public SolutionNamed(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SolutionNamed {id=" + id + ", description='" + description + "'}";
    }
}
