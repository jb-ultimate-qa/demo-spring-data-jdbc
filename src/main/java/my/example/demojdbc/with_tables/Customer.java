package my.example.demojdbc.with_tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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