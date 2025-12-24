package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.composite_id.record.ComplicatedRecord;
import my.example.demojdbc.roots.composite_id.record.ComplicatedRecordService;
import my.example.demojdbc.roots.composite_id.record.CompositeRecordId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(AppProfile.COMPOSITE_ID_RECORD)
public class ComplicatedRecordCrudRunner implements CommandLineRunner {
    private final ComplicatedRecordService service;

    public ComplicatedRecordCrudRunner(ComplicatedRecordService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Insert 4 ComplicatedRecord ===");
        service.insertSampleData();
        printAllEntities();

        Iterable<ComplicatedRecord> all = service.findAll();
        ComplicatedRecord first = all.iterator().next();
        CompositeRecordId id = first.getId();

        System.out.println("\n=== Reading the first entity by id ===");
        service.findById(id).ifPresentOrElse(
                b -> System.out.println("Fetched entity: " + b),
                () -> System.out.println("Entity is not found")
        );

        System.out.println("\n=== Deleting 1 entity ===");
        service.deleteById(id);
        printAllEntities();

        System.out.println("\n=== Deleting all entities ===");
        service.deleteAll();
    }

    private void printAllEntities() {
        Iterable<ComplicatedRecord> all = service.findAll();
        System.out.println("~~~ The list of ComplicatedEntities: ~~~");
        all.forEach(System.out::println);
    }
}
