package my.example.demojdbc.roots.emb_user;

import org.springframework.data.relational.core.mapping.Column;

public class Address {
    @Column("city")
    private String city;

    @Column("street")
    private String street;
}
