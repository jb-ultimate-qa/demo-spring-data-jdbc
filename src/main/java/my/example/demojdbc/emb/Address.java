package my.example.demojdbc.emb;

import org.springframework.data.relational.core.mapping.Column;

public class Address {
    @Column("city")
    private String city;

    @Column("street")
    private String street;
}
