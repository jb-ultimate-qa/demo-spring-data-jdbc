package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.composite_id.entity.ComplicatedEntityService;
import my.example.demojdbc.roots.composite_id.entity.ComplicatedEntity;
import my.example.demojdbc.roots.composite_id.entity.CompositeId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(AppProfile.COMPOSITE_ID_ENTITY)
public class ComplicatedEntityCrudRunner implements CommandLineRunner {
    private final ComplicatedEntityService service;

    public ComplicatedEntityCrudRunner(ComplicatedEntityService service) {
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

        System.out.println("\n=== Updating 1 entity ===");
        service.updateEntityName(id, "new name");
        service.findById(id).ifPresent(b -> System.out.println("Updated entity: " + b));
        printAllEntities();

        System.out.println("\n=== Deleting 1 entity ===");
        service.deleteById(id);
        printAllEntities();

        System.out.println("\n=== Deleting all entities ===");
        service.deleteAll();
    }

    private void printAllEntities() {
        Iterable<ComplicatedEntity> all = service.findAll();
        System.out.println("~~~ The list of ComplicatedEntities: ~~~");
        all.forEach(System.out::println);
    }
}
