package services;

import api.repositories.ProductRepository;
import api.services.ProductService;
import model.entities.Product;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {
    private static ProductServiceImpl instance;
    private ProductRepository productRepository;

    private ProductServiceImpl(){
    }

    public static ProductServiceImpl getInstance(){
        if(instance == null){
            instance = new ProductServiceImpl();
        }

        return instance;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        abstractRepository = productRepository;
    }
}
