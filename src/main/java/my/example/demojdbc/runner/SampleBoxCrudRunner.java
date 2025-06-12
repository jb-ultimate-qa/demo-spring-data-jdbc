package my.example.demojdbc.runner;

import my.example.demojdbc.collection.Box;
import my.example.demojdbc.collection.BoxService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("box")
public class SampleBoxCrudRunner implements CommandLineRunner {

    private final BoxService boxService;

    public SampleBoxCrudRunner(BoxService boxService) {
        this.boxService = boxService;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Creating sample Box ===");
        Box box = boxService.createSampleBox();
        System.out.println("Saved box: " + box);
        var id = box.getId();

        System.out.println("\n=== Reading the saved Box ===");
        boxService.getBox(id)
                .ifPresentOrElse(
                b -> System.out.println("Fetched box: " + b),
                () -> System.out.println("Box not found")
        );


        System.out.println("\n=== Updating Box volume ===");
        boxService.updateBoxVolume(id, 99.9);
        boxService.getBox(id).ifPresent(b -> System.out.println("Updated box: " + b));

        System.out.println("\n=== Editing items in the Box ===");
        boxService.replaceAllItems(id);
        boxService.getBox(id).ifPresent(b -> System.out.println("Box after item edits: " + b));

        System.out.println("\n=== Modifying one item in each collection ===");
        boxService.replaceFirstItems(id);
        boxService.getBox(id).ifPresent(b -> System.out.println("Box after single-item edits: " + b));

        System.out.println("\n=== Updating fields inside items ===");
        boxService.updateItemFields(id, "addedKey");
        boxService.getBox(box.getId()).ifPresent(b -> System.out.println("Box after field updates: " + b));


        System.out.println("\n=== Deleting Box ===");
        boxService.deleteBox(id);
        System.out.println("Deleted box with ID: " + id);

        System.out.println("\n=== Verifying Deletion ===");
        boxService.getBox(id).ifPresentOrElse(
                b -> System.out.println("Unexpectedly found box: " + b),
                () -> System.out.println("Box was successfully deleted")
        );
    }
}
