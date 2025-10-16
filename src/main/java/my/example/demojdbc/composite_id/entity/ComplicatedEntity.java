package my.example.demojdbc.composite_id.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Getter
@Setter
@Table("complicated_entity")
public class ComplicatedEntity implements Persistable<CompositeId> {
    @Id @Embedded.Nullable CompositeId id;
    String name;

    @Transient
    private boolean isNew = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplicatedEntity that = (ComplicatedEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ComplicatedEntity {" +
                "idExtended=" + id.idExtended +
                ", idNumeric=" + id.idNumeric +
                ", name='" + name + '\'' +
                '}';
    }

    public ComplicatedEntity() {
    }

    @PersistenceCreator
    public ComplicatedEntity(CompositeId id, String name) {
        this.id = id;
        this.name = name;
        this.isNew = false;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
