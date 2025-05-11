package org.example.repository;

import org.assertj.core.api.Assertions;
import org.example.product.Product;
import org.example.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindProduct() {
        // given
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(100));

        // when
        Product savedProduct = productRepository.save(product);
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        // then
        Assertions.assertThat(foundProduct).isPresent();
        Assertions.assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
        Assertions.assertThat(foundProduct.get().getPrice()).isEqualTo(BigDecimal.valueOf(100));
    }
}
