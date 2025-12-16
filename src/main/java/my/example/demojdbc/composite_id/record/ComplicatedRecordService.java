package my.example.demojdbc.composite_id.record;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ComplicatedRecordService {

    private final ComplicatedRecordRepository complicatedRecordRepository;
    private final JdbcTemplate jdbcTemplate;

    ComplicatedRecordService(ComplicatedRecordRepository complicatedRecordRepository, JdbcTemplate jdbcTemplate) {
        this.complicatedRecordRepository = complicatedRecordRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertSampleData() {
        jdbcTemplate.execute("INSERT INTO complicated_record(id_num,id_ext,description) VALUES(110, '110_EXT', 'SPINACH')");
        jdbcTemplate.execute("INSERT INTO complicated_record(id_num,id_ext,description) VALUES(220, '220_EXT', 'PARSLEY')");
        jdbcTemplate.execute("INSERT INTO complicated_record(id_num,id_ext,description) VALUES(330, '330_EXT', 'ARUGULA')");
        jdbcTemplate.execute("INSERT INTO complicated_record(id_num,id_ext,description) VALUES(440, '440_EXT', 'BASIL')");
    }

    public Iterable<ComplicatedRecord> findAll() {
        return complicatedRecordRepository.findAll();
    }

    public Optional<ComplicatedRecord> findById(CompositeRecordId compositeId) {
        return complicatedRecordRepository.findById(compositeId);
    }

    @Transactional
    public void deleteById(CompositeRecordId compositeId) {
        complicatedRecordRepository.deleteById(compositeId);
    }

    @Transactional
    public void deleteAll() {
        complicatedRecordRepository.deleteAll();
    }
}
