package my.example.demojdbc.links;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table("order_items")
public class OrderItem {
    private Long productId;         // link to Product by id
    private int quantity;

    @Override
    public String toString() {
        return "Item {" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
