package services;

import api.repositories.ProductRepository;
import api.services.ProductService;
import model.entities.Product;
import repositories.ProductRepositoryImpl;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {
    private static ProductServiceImpl instance;
    private final ProductRepository clientRepository;

    private ProductServiceImpl(){
        super(ProductRepositoryImpl.getInstance());
        clientRepository = (ProductRepository) abstractRepository;
    }

    public static ProductServiceImpl getInstance(){
        if(instance == null){
            instance = new ProductServiceImpl();
        }

        return instance;
    }
}
