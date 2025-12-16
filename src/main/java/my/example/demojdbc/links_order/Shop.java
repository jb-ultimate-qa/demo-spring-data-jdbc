package my.example.demojdbc.links_order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Table("shops")
@Getter
@Setter
public class Shop {
    @Id
    private int id;
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Shop {" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
