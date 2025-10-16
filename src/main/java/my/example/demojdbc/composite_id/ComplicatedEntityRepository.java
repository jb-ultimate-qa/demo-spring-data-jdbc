package my.example.demojdbc.composite_id;

import my.example.demojdbc.composite_id.entity.ComplicatedEntity;
import my.example.demojdbc.composite_id.entity.CompositeId;
import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;

interface ComplicatedEntityRepository extends CrudRepository<@NonNull ComplicatedEntity, @NonNull CompositeId> {
}
