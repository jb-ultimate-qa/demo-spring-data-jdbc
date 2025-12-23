package my.example.demojdbc.roots.sequences;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Sequence;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("solution_default")
public class SolutionDefault {
    @Id
    @Sequence("solution_default_seq")
    private Long id;

    private String description;

    public SolutionDefault(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SolutionDefault {id=" + id + ", description='" + description + "'}";
    }
}
