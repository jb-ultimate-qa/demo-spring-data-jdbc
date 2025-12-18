package my.example.demojdbc.roots.links_order.repos;

import my.example.demojdbc.roots.links_order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
