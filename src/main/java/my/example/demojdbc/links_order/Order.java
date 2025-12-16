package my.example.demojdbc.links_order;

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

//    @MappedCollection(idColumn = "order_id") // Missing 'keyColumn' attribute inspection
    @MappedCollection(idColumn = "order_id", keyColumn = "orders_key")
    private List<OrderItem> items;                  // list of OrderItems

    public void addItem(Product product, int quantity) {
        this.items.add(new OrderItem(product.getId(), quantity));
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", shopId=" + shop.getId() +
                ", items=" + items +
                '}';
    }
}
