package my.example.demojdbc.links;

import lombok.AllArgsConstructor;

import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Table("order_items")
public class OrderItem {
    private Long productId;         // link to Product by id
    private int quantity;
}
