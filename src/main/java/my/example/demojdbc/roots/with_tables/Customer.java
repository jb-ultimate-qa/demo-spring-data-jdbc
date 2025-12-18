package my.example.demojdbc.roots.with_tables;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("customers")
public class Customer {
    @Id
    @Column("customer_id")
    private Long customerId;

    @Column("full_name")
    private String name;

    private String email;

    @Column(value = "city")
    public String city;
}