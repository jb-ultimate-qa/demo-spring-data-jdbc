package my.example.demojdbc.roots.emb_user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Column("username")
    private String username;

// ----- use annotation shortcuts -----
//    @Embedded.Nullable
//    private Address address1;
//
//    @Embedded.Empty
//    private Passport passport1;

// ----- use prefixes -----
//    @Embedded.Nullable(prefix = "first_address_")
//    private Address address1;
//
//    @Embedded(onEmpty = USE_NULL, prefix = "second_address_")
//    private Address address2;
//
//    @Embedded(onEmpty = USE_EMPTY, prefix = "first_")
//    private Passport passport1;
//
//    @Embedded.Empty(prefix = "second_")
//    private Passport passport2;

    @Embedded(onEmpty = USE_NULL)
    private Address address;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Passport passport;

}

