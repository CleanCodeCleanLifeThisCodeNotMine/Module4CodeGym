package org.example.demojwtc04.service.product;

import org.example.demojwtc04.model.Product;
import org.example.demojwtc04.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }
}
