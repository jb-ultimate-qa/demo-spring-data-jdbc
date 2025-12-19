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
    private String nameB;

    public ItemB() {}

    public ItemB(String name) {
        this.id = null;
        this.nameB = name;
    }

    public ItemB(Integer id, String nameB) {
        this.id = id;
        this.nameB = nameB;
    }

    @Override
    public String toString() {
        return "I2{" + nameB + "(id=" + id + ")}";
    }
}
