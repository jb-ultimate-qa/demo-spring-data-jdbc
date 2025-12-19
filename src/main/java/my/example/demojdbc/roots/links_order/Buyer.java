package my.example.demojdbc.roots.links_order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Getter
@Setter
@Table("buyers")
public class Buyer {
    @Id
    private Long buyerId;
    private String fullName;

    public Buyer(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Buyer {" +
                "buyerId=" + buyerId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
