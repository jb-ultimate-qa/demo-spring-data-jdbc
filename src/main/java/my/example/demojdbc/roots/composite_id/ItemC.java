package my.example.demojdbc.roots.composite_id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//import org.springframework.data.jdbc.core.mapping.AggregateReference;
//import org.springframework.data.relational.core.mapping.MappedCollection;
//import java.util.Set;

@Getter
@Setter
@Table(value = "item_c")
public class ItemC {
    @Id private Integer id;
    private String name3;

//    AggregateReference<ComplicatedEntity, Integer> coentity;
//    @MappedCollection(idColumn = "custom_column")
//    Set<ComplicatedEntity> coentities;

    public ItemC() {}

    public ItemC(String name) {
        this.id = null;
        this.name3 = name;
    }

    public ItemC(Integer id, String name3) {
        this.id = id;
        this.name3 = name3;
    }

    @Override
    public String toString() {
        return "I3{" + name3 + "(id=" + id + ")}";
    }
}
