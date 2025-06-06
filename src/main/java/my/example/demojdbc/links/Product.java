package my.example.demojdbc.links;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;


@Table("products")
@Getter
@Setter
public class Product {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;
}

