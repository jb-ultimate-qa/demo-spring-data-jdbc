package my.example.demojdbc.collection_box;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(value = "box")
public class Box {
    @Id
    private Integer id;

    private Double volume;

    @MappedCollection(idColumn = "box1_id", keyColumn = "list_key")
    private List<Item1> items1;

    @MappedCollection(idColumn = "box2_id")
    private Set<Item2> items2;

    @MappedCollection(idColumn = "box3_id", keyColumn = "map_key")
    private Map<String, Item3> items3;

    @Override
    public String toString() {
        String items3Str = items3.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(", ", "{", "}"));

        return "Box {" +
                "id=" + id +
                ", volume=" + volume +
                ", \n  items1 = " + items1 +
                ", \n  items2 = " + items2 +
                ", \n  items3 = " + items3Str +
                "\n}";
    }
}
