package my.example.demojdbc.roots.composite_id.record;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

//import my.example.demojdbc.composite_id.ItemA;
//import my.example.demojdbc.composite_id.ItemB;
//import org.springframework.data.jdbc.core.mapping.AggregateReference;
//import org.springframework.data.relational.core.mapping.MappedCollection;
//import java.util.Set;

@Table("complicated_record")
public record ComplicatedRecord(
    @Id @Embedded.Nullable CompositeRecordId id,
    String description

//    ,AggregateReference<ItemA, Integer> itemA,
//    @MappedCollection(idColumn = "custom_column")
//    Set<ItemB> items
) {
    public void setName(String newName) {
    }

    public CompositeRecordId getId() {
        return id;
    }
}
