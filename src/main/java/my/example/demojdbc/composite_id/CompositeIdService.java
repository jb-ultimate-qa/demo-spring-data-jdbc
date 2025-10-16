package my.example.demojdbc.composite_id;

import my.example.demojdbc.composite_id.entity.ComplicatedEntity;
import my.example.demojdbc.composite_id.entity.CompositeId;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompositeIdService {

    private final ComplicatedEntityRepository complicatedEntityRepository;
    private final JdbcTemplate jdbcTemplate;

    CompositeIdService(ComplicatedEntityRepository complicatedEntityRepository, JdbcTemplate jdbcTemplate) {
        this.complicatedEntityRepository = complicatedEntityRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertSampleData() {
        jdbcTemplate.execute("INSERT INTO complicated_entity(id_numeric,id_extended,name) VALUES(10, '10_EXT', 'spinach')");
        jdbcTemplate.execute("INSERT INTO complicated_entity(id_numeric,id_extended,name) VALUES(20, '20_EXT', 'parsley')");
        jdbcTemplate.execute("INSERT INTO complicated_entity(id_numeric,id_extended,name) VALUES(30, '30_EXT', 'arugula')");
        jdbcTemplate.execute("INSERT INTO complicated_entity(id_numeric,id_extended,name) VALUES(40, '40_EXT', 'basil')");
    }

    public Iterable<ComplicatedEntity> findAll() {
        return complicatedEntityRepository.findAll();
    }

    public Optional<ComplicatedEntity> findById(CompositeId compositeId) {
        return complicatedEntityRepository.findById(compositeId);
    }

    @Transactional
    public void updateEntityName(CompositeId id, String newName) {
        complicatedEntityRepository.findById(id).ifPresent(entity -> {
            entity.setName(newName);
            complicatedEntityRepository.save(entity);
        });
    }

    @Transactional
    public void deleteById(CompositeId compositeId) {
        complicatedEntityRepository.deleteById(compositeId);
    }

    @Transactional
    public void deleteAll() {
        complicatedEntityRepository.deleteAll();
    }
}
