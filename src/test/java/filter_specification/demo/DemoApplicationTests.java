package filter_specification.demo;

import filter_specification.demo.entity.Product;
import filter_specification.demo.reponsitory.ProductRepository;
import filter_specification.demo.search.ProductSpecification;
import filter_specification.demo.search.SearchCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductApplicationTests {
    ProductRepository productRepository;

    @Test
    public void demoTest() {
        ProductSpecification filter02 = new ProductSpecification(new SearchCriteria("name", "=","Dung Nguyen"));
        ProductSpecification filter01 = new ProductSpecification(new SearchCriteria("price", ">=", 10000) );
        ProductSpecification filter03 = new ProductSpecification(new SearchCriteria("price", "<=", 15000));
        List<Product> orders = productRepository.findAll(filter01.and(filter03));
        System.out.println(orders.size());
    }

}
