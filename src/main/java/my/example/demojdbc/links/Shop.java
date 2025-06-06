package my.example.demojdbc.links;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("shops")
@Getter
@Setter
public class Shop {
    @Id
    private int id;
    private String shopName;
}
