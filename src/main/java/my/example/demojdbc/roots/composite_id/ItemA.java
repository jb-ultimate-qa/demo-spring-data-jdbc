package my.example.demojdbc.roots.composite_id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "item_a")
public class ItemA {
    @Id private Integer id;
    private String nameA;

    public ItemA() {}

    public ItemA(String name) {
        this.id = null;
        this.nameA = name;
    }

    public ItemA(Integer id, String nameA) {
        this.id = id;
        this.nameA = nameA;
    }

    @Override
    public String toString() {
        return "I1{" + nameA + "(id=" + id + ")}";
    }
}
