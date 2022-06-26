package com.example.testcontainers;

import com.example.testcontainers.configuration.ContainersEnvironment;
import com.example.testcontainers.model.Product;
import com.example.testcontainers.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = TestcontainersApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT
)
class TestcontainersApplicationTests extends ContainersEnvironment {

  @Autowired
  private ProductRepository productRepository;

  @Test
  void contextLoads() {
    Product product = new Product();
    product.setName("Testcontainers");
    productRepository.save(product);
    System.out.println("Context load!");
  }

}
