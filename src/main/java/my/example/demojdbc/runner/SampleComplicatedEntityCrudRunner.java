package my.example.demojdbc.runner;

import my.example.demojdbc.composite_id.CompositeIdService;
import my.example.demojdbc.composite_id.entity.ComplicatedEntity;
import my.example.demojdbc.composite_id.entity.CompositeId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("composite")
public class SampleComplicatedEntityCrudRunner implements CommandLineRunner {
    private final CompositeIdService service;

    public SampleComplicatedEntityCrudRunner(CompositeIdService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Insert 4 ComplicatedEntity ===");
        service.insertSampleData();
        printAllEntities();

        Iterable<ComplicatedEntity> all = service.findAll();
        ComplicatedEntity first = all.iterator().next();
        CompositeId id = first.getId();

        System.out.println("\n=== Reading the first entity by id ===");
        service.findById(id).ifPresentOrElse(
                b -> System.out.println("Fetched entity: " + b),
                () -> System.out.println("Entity is not found")
        );

        System.out.println("\n=== Updating entity ===");
        service.updateEntityName(id, "new name");
        service.findById(id).ifPresent(b -> System.out.println("Updated entity: " + b));
        printAllEntities();

        service.deleteById(id);
        printAllEntities();

        service.deleteAll();
    }

    private void printAllEntities() {
        Iterable<ComplicatedEntity> all = service.findAll();
        System.out.println("\n=== The list of ComplicatedEntities: ===");
        all.forEach(System.out::println);
    }
}
