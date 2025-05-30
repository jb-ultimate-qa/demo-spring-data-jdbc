package my.example.demojdbc.emb;

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

//    @Embedded.Nullable
//    private Address address1;
//
//    @Embedded.Empty
//    private Passport passport1;

    @Embedded(onEmpty = USE_NULL)
    private Address address;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Passport passport;

}

