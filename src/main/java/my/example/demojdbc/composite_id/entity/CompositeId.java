package my.example.demojdbc.composite_id.entity;

import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;


public class CompositeId {
    @Column("id_numeric") Long idNumeric;
    @Column("id_extended") String idExtended;

    public CompositeId(Long idNumeric, String idExtended) {
        this.idNumeric = idNumeric;
        this.idExtended = idExtended;
    }

    public Long getIdNumeric() {
        return idNumeric;
    }

    public String getIdExtended() {
        return idExtended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeId that = (CompositeId) o;
        return Objects.equals(idNumeric, that.idNumeric) &&
                Objects.equals(idExtended, that.idExtended);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumeric, idExtended);
    }
}
