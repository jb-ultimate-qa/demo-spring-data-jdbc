package my.example.demojdbc.links.repos;

import my.example.demojdbc.links.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
