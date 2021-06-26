package controllers;

import api.services.ProductService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.Product;
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

    public void create(Product product) throws EntityCannotBeAddedException {
        productService.create(product);
    }

    public List<Product> getAll(){
        return productService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        productService.deleteById(id);
    }

    public Product getById(long id) throws EntityNotFoundException {
        return productService.getById(id);
    }
}
