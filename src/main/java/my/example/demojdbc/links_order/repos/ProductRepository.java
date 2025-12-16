package my.example.demojdbc.links_order.repos;

import my.example.demojdbc.links_order.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}

