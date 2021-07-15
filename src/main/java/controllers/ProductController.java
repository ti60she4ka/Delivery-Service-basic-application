package controllers;

import api.services.ProductService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import lombok.Setter;
import model.entities.Product;

import java.util.Collection;

public class ProductController {
    private static ProductController instance;
    @Setter
    private ProductService productService;

    private ProductController(){
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

    public Collection<Product> getAll(){
        return productService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        productService.deleteById(id);
    }

    public Product getById(long id) throws EntityNotFoundException {
        return productService.getById(id);
    }
}
