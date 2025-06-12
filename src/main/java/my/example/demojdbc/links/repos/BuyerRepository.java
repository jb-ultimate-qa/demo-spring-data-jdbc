package my.example.demojdbc.links.repos;

import my.example.demojdbc.links.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {}
