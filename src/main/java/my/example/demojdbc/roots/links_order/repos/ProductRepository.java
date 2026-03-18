package my.example.demojdbc.roots.links_order.repos;

import my.example.demojdbc.roots.links_order.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // =============================================================================
    // =============================== VALID QUERIES ===============================

    // simple
    @Query(value = "select name from products where price < 1000")
    List<Product> validQuerySample();

    // with parameter
    @Query("select * from products pr where pr.price = ?1")
    List<Product> validQueryWithParameterSample(BigDecimal price);

    // multiline, inner select
    @Query(value = "select name from products " +
            "  where id in " +
            "  (" +
            "       select product_id " +
            "       from order_items " +
            "       where quantity > 10" +
            "  ) " +
            "  and price < 1000")
    List<String> complicatedQuery();

    // =============================================================================
    // ============================== INVALID QUERIES ==============================

//    @Query(value = "select wrong_column1 from products where wrong_column2 > 100")
//    List<Product> invalidSchemaSample();
//
//    @Query(value = "select pr.name from products pr wrong_keyword")
//    List<Product> invalidSyntaxSample();
//
//    @Query(value = "select pr.name from products pr where pr")
//    List<Product> checkSqlSchemaCompletionSample();
//
//    @Query(value = "select name from products wh")
//    List<Product> checkSqlSyntaxCompletionSample();
    
}

