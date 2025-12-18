package my.example.demojdbc.roots.collection_box;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item3")
public class Item3 {
    @Id
    private Integer id;

    private String name3;

    public Item3() {}

    public Item3(String name) {
        this.id = null;
        this.name3 = name;
    }

    public Item3(Integer id, String name3) {
        this.id = id;
        this.name3 = name3;
    }

    @Override
    public String toString() {
        return "I3{" + name3 + "(id=" + id + ")}";
    }
}
