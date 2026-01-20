package my.example.demojdbc.roots.links_order.repos;

import my.example.demojdbc.roots.links_order.Order;
import my.example.demojdbc.roots.links_order.Shop;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findOrderByShop(Integer shop);
    List<Order> findOrderByShop(AggregateReference<Shop, Integer> shop);
}
