package my.example.demojdbc.links;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("orders")
public class Order {
    @Id
    private Long id;

    private Long buyerId;                           // link to Buyer by id

    private AggregateReference<Shop, Integer> shop; // link to Shop by AggregateReference

    @MappedCollection(idColumn = "order_id")
    private List<OrderItem> items;                  // list of OrderItems

    public void addItem(Product product, int quantity) {
        this.items.add(new OrderItem(product.getId(), quantity));
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }
}
