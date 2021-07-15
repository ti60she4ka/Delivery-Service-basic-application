package initializers;

import controllers.*;
import repositories.*;
import services.*;
import storages.*;

public class ContextInitializer implements Initializer {
    @Override
    public void init() {
        initRepositories();
        initServices();
        initControllers();
    }

    private void initRepositories(){
        ArticleRepositoryImpl.getInstance().setArticleDataStorage(ArticleDataStorage.getInstance());
        CategoryRepositoryImpl.getInstance().setCategoryDataStorage(CategoryDataStorage.getInstance());
        OrderRepositoryImpl.getInstance().setOrderDataStorage(OrderDataStorage.getInstance());
        ProductRepositoryImpl.getInstance().setProductDataStorage(ProductDataStorage.getInstance());
        ShopRepositoryImpl.getInstance().setShopDataStorage(ShopDataStorage.getInstance());
        UserRepositoryImpl.getInstance().setUserDataStorage(UserDataStorage.getInstance());
    }

    private void initServices(){
        ArticleServiceImpl.getInstance().setArticleRepository(ArticleRepositoryImpl.getInstance());
        CategoryServiceImpl.getInstance().setCategoryRepository(CategoryRepositoryImpl.getInstance());
        OrderServiceImpl.getInstance().setOrderRepository(OrderRepositoryImpl.getInstance());
        ProductServiceImpl.getInstance().setProductRepository(ProductRepositoryImpl.getInstance());
        ShopServiceImpl.getInstance().setShopRepository(ShopRepositoryImpl.getInstance());
        UserServiceImpl.getInstance().setUserRepository(UserRepositoryImpl.getInstance());
    }

    private void initControllers() {
        ArticleController.getInstance().setArticleService(ArticleServiceImpl.getInstance());
        CategoryController.getInstance().setCategoryService(CategoryServiceImpl.getInstance());
        OrderController.getInstance().setOrderService(OrderServiceImpl.getInstance());
        ProductController.getInstance().setProductService(ProductServiceImpl.getInstance());
        ShopController.getInstance().setShopService(ShopServiceImpl.getInstance());
        UserController.getInstance().setUserService(UserServiceImpl.getInstance());
    }
}
