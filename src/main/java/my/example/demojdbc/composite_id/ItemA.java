package my.example.demojdbc.composite_id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item_a")
public class ItemA {
    @Id private Integer id;
    private String name1;

    public ItemA() {}

    public ItemA(String name) {
        this.id = null;
        this.name1 = name;
    }

    public ItemA(Integer id, String name1) {
        this.id = id;
        this.name1 = name1;
    }

    @Override
    public String toString() {
        return "I1{" + name1 + "(id=" + id + ")}";
    }
}
