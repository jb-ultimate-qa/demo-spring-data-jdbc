package my.example.demojdbc.roots.composite_id.record;

//import my.example.demojdbc.composite_id.ItemA;
//import org.springframework.data.jdbc.core.mapping.AggregateReference;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.MappedCollection;
//import java.util.Set;

public record CompositeRecordId(
//        @Column("id_num") Long idNum,
//        @Column("id_ext") String idExt
        Long idNum,
        String idExt
//        AggregateReference<ItemA, Integer> itemA
//        @MappedCollection(idColumn = "custom_column")
//        Set<ItemA> items
) {
}
