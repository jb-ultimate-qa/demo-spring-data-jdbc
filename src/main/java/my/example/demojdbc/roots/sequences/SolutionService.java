package my.example.demojdbc.roots.sequences;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SolutionService {

    JdbcAggregateTemplate template;

    public SolutionService(JdbcAggregateTemplate template) {
        this.template = template;
    }

    @Transactional
    public void insertSampleDataForSolutionDefault() {
        template.save(new SolutionDefault("default 1"));
        template.save(new SolutionDefault("default 2"));
        template.save(new SolutionDefault("default 3"));

        List<SolutionDefault> all = template.findAll(SolutionDefault.class);
        all.forEach(System.out::println);
    }

    @Transactional
    public void insertSampleDataForSolutionNamed() {
        template.save(new SolutionNamed("named 1"));
        template.save(new SolutionNamed("named 2"));
        template.save(new SolutionNamed("named 3"));

        List<SolutionNamed> all = template.findAll(SolutionNamed.class);
        all.forEach(System.out::println);
    }

    @Transactional
    public void insertSampleDataForSolutionAlias() {
        template.save(new SolutionAlias("alias 1"));
        template.save(new SolutionAlias("alias 2"));
        template.save(new SolutionAlias("alias 3"));

        List<SolutionAlias> all = template.findAll(SolutionAlias.class);
        all.forEach(System.out::println);
    }
}
