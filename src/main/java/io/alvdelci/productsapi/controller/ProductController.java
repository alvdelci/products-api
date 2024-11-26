package io.alvdelci.productsapi.controller;

import io.alvdelci.productsapi.model.Product;
import io.alvdelci.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        var id = UUID.randomUUID().toString();
        product.setId(id);
        productRepository.save(product);
        return product;
    }
    @GetMapping("{id}")
    public Product getById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id, @RequestBody Product product) {
        //Quando passamos o id do product o metodo save identifica que o produto ja existe e atualiza as informações. Por isso usamos o mesmo metodo
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> findAll(@RequestParam("name") String name) {
        return productRepository.findByName(name);
    }
}
