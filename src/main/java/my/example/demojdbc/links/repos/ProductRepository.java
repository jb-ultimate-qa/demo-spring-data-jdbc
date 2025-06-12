package my.example.demojdbc.links.repos;

import my.example.demojdbc.links.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}

