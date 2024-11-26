package io.alvdelci.productsapi.repository;

import io.alvdelci.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findByName(String name);
}
