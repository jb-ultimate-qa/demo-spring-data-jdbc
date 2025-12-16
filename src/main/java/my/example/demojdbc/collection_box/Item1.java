package my.example.demojdbc.collection_box;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item1")
public class Item1 {
    @Id
    private Integer id;

    private String name1;

    public Item1() {}

    public Item1(String name) {
        this.id = null;
        this.name1 = name;
    }

    public Item1(Integer id, String name1) {
        this.id = id;
        this.name1 = name1;
    }

    @Override
    public String toString() {
        return "I1{" + name1 + "(id=" + id + ")}";
    }
}
