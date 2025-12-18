package my.example.demojdbc.roots.composite_id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item_b")
public class ItemB {
    @Id private Integer id;
    private String name2;

    public ItemB() {}

    public ItemB(String name) {
        this.id = null;
        this.name2 = name;
    }

    public ItemB(Integer id, String name2) {
        this.id = id;
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "I2{" + name2 + "(id=" + id + ")}";
    }
}
