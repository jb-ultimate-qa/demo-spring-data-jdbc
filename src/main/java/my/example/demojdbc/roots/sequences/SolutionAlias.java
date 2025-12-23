package my.example.demojdbc.roots.sequences;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Sequence;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("solution_alias")
public class SolutionAlias {
    @Id
    @Sequence(sequence = "solution_alias_seq")
    private int id;

    private String description;

    public SolutionAlias(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SolutionAlias {id=" + id + ", description='" + description + "'}";
    }
}
