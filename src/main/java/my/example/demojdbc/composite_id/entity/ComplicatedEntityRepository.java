package my.example.demojdbc.composite_id.entity;

import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;

interface ComplicatedEntityRepository extends CrudRepository<@NonNull ComplicatedEntity, @NonNull CompositeId> {
}
