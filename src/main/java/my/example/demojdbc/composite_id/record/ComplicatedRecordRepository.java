package my.example.demojdbc.composite_id.record;


import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;

interface ComplicatedRecordRepository extends CrudRepository<@NonNull ComplicatedRecord, @NonNull CompositeRecordId> {
}
