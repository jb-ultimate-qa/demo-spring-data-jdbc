package my.example.demojdbc.links;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("buyers")
@Getter
@Setter
public class Buyer {
    @Id
    private Long buyerId;
    private String fullName;
}
