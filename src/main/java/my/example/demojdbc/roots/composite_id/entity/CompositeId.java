package my.example.demojdbc.roots.composite_id.entity;

//import my.example.demojdbc.composite_id.ItemA;
//import my.example.demojdbc.composite_id.ItemB;
//import org.springframework.data.jdbc.core.mapping.AggregateReference;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.MappedCollection;
//import java.util.Set;
import java.util.Objects;


public class CompositeId {
    Long idNumeric;
    String idExtended;
//    AggregateReference<ItemA, Integer> itemA;
//    @MappedCollection(idColumn = "custom_column") Set<ItemB> items;

    public CompositeId(Long idNumeric, String idExtended) {
        this.idNumeric = idNumeric;
        this.idExtended = idExtended;
    }

    public Long getIdNumeric() {
        return idNumeric;
    }

    public String getIdExtended() {
        return idExtended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeId that = (CompositeId) o;
        return Objects.equals(idNumeric, that.idNumeric) &&
                Objects.equals(idExtended, that.idExtended);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumeric, idExtended);
    }
}
