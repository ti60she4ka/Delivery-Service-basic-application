package controllers;

import api.services.ClientService;
import api.services.ProductService;
import exceptions.EntityNotFoundException;
import model.entities.Client;
import model.entities.Product;
import services.ClientServiceImpl;
import services.ProductServiceImpl;

import java.util.List;

public class ProductController {
    private static ProductController instance;
    private final ProductService productService;

    private ProductController(){
        productService = ProductServiceImpl.getInstance();
    }

    public static ProductController getInstance() {
        if(instance == null){
            instance = new ProductController();
        }

        return instance;
    }

    public void createProduct(Product product){
        productService.create(product);
    }

    public List<Product> getProducts(){
        return productService.getAll();
    }

    public void deleteProduct(long id) throws EntityNotFoundException {
        productService.delete(id);
    }

    public Product getProduct(long id) throws EntityNotFoundException {
        return productService.get(id);
    }
}
