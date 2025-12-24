package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.sequences.SolutionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static java.lang.System.out;

@Configuration
@Profile(AppProfile.SOLUTION)
public class SolutionCrudRunner implements CommandLineRunner {

    private final SolutionService service;

    public SolutionCrudRunner(SolutionService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        out.println("=== Creating sample Solution with Default sequence name ===");
        service.insertSampleDataForSolutionDefault();

        out.println("=== Creating sample Solution with defined sequence name and schema ===");
        service.insertSampleDataForSolutionNamed();

        out.println("=== Creating sample Solution with using alias for sequence name ===");
        service.insertSampleDataForSolutionAlias();

        out.println("=== Deleting all ===");
        service.deleteAll();
    }
}
