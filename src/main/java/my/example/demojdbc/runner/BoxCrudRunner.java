package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.collection_box.Box;
import my.example.demojdbc.roots.collection_box.BoxService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(AppProfile.BOX)
public class BoxCrudRunner implements CommandLineRunner {

    private final BoxService boxService;

    public BoxCrudRunner(BoxService boxService) {
        this.boxService = boxService;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Creating sample Box ===");
        Box box = boxService.createSampleBox();
        System.out.println("Saved box: " + box);
        var id = box.getId();

        System.out.println("\n=== Reading the saved Box ===");
        printResultBox(id);

        System.out.println("\n=== Updating Box volume ===");
        boxService.updateBoxVolume(id, 99.9);
        printResultBox(id);

        System.out.println("\n=== Editing items in the Box ===");
        boxService.replaceAllItems(id);
        printResultBox(id);

        System.out.println("\n=== Modifying one item in each collection ===");
        boxService.replaceFirstItems(id);
        printResultBox(id);

        System.out.println("\n=== Updating fields inside items ===");
        boxService.updateItemFields(id, "addedKey");
        printResultBox(id);

        System.out.println("\n=== Deleting Box ===");
        boxService.deleteBox(id);
        System.out.println("Deleted box with ID: " + id);

        System.out.println("\n=== Verifying Deletion ===");
        boxService.getBox(id).ifPresentOrElse(
                b -> System.out.println("Unexpectedly found box: " + b),
                () -> System.out.println("Box was successfully deleted")
        );
    }

    private void printResultBox(Integer id) {
        boxService.getBox(id)
                .ifPresentOrElse(
                        b -> System.out.println("Result box: " + b),
                        () -> System.out.println("Box not found")
                );
    }
}
