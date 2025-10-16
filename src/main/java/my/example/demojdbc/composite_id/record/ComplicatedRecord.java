package my.example.demojdbc.composite_id.record;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Table("complicated_record")
public record ComplicatedRecord(
    @Id @Embedded.Nullable CompositeRecordId id,
    String description
) {
    public void setName(String newName) {
    }

    public CompositeRecordId getId() {
        return id;
    }
}
