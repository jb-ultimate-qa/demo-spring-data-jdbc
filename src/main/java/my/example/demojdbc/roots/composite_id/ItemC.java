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
    private String nameC;

//    AggregateReference<ComplicatedEntity, Integer> coentity;
//    @MappedCollection(idColumn = "custom_column")
//    Set<ComplicatedEntity> coentities;

    public ItemC() {}

    public ItemC(String name) {
        this.id = null;
        this.nameC = name;
    }

    public ItemC(Integer id, String nameC) {
        this.id = id;
        this.nameC = nameC;
    }

    @Override
    public String toString() {
        return "I3{" + nameC + "(id=" + id + ")}";
    }
}
