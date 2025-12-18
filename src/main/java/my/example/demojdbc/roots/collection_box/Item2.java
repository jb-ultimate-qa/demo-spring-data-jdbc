package my.example.demojdbc.roots.collection_box;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item2")
public class Item2 {
    @Id
    private Integer id;

    private String name2;

    public Item2() {}

    public Item2(String name) {
        this.id = null;
        this.name2 = name;
    }

    public Item2(Integer id, String name2) {
        this.id = id;
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "I2{" + name2 + "(id=" + id + ")}";
    }
}
