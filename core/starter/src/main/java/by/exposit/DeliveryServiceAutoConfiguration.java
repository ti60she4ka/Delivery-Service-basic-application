package by.exposit;

import by.exposit.controllers.ArticleController;
import by.exposit.controllers.CategoryController;
import by.exposit.controllers.OrderController;
import by.exposit.controllers.ProductController;
import by.exposit.controllers.ShopController;
import by.exposit.controllers.UserController;
import by.exposit.filemanager.FileManager;
import by.exposit.repositories.article.ArticleRepository;
import by.exposit.repositories.article.ArticleRepositoryImpl;
import by.exposit.repositories.category.CategoryRepository;
import by.exposit.repositories.category.CategoryRepositoryImpl;
import by.exposit.repositories.order.OrderRepository;
import by.exposit.repositories.order.OrderRepositoryImpl;
import by.exposit.repositories.product.ProductRepository;
import by.exposit.repositories.product.ProductRepositoryImpl;
import by.exposit.repositories.shop.ShopRepository;
import by.exposit.repositories.shop.ShopRepositoryImpl;
import by.exposit.repositories.user.UserRepository;
import by.exposit.repositories.user.UserRepositoryImpl;
import by.exposit.services.article.ArticleService;
import by.exposit.services.article.ArticleServiceImpl;
import by.exposit.services.category.CategoryService;
import by.exposit.services.category.CategoryServiceImpl;
import by.exposit.services.order.OrderService;
import by.exposit.services.order.OrderServiceImpl;
import by.exposit.services.product.ProductService;
import by.exposit.services.product.ProductServiceImpl;
import by.exposit.services.shop.ShopService;
import by.exposit.services.shop.ShopServiceImpl;
import by.exposit.services.user.UserService;
import by.exposit.services.user.UserServiceImpl;
import by.exposit.storages.ArticleDataStorage;
import by.exposit.storages.CategoryDataStorage;
import by.exposit.storages.OrderDataStorage;
import by.exposit.storages.ProductDataStorage;
import by.exposit.storages.ShopDataStorage;
import by.exposit.storages.UserDataStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.exposit"})
public class DeliveryServiceAutoConfiguration {

  private static final String ARTICLE_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/ArticleDataStorage.json";
  private static final String CATEGORY_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/CategoryDataStorage.json";
  private static final String ORDER_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/OrderDataStorage.json";
  private static final String PRODUCT_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/ProductDataStorage.json";
  private static final String SHOP_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/ShopDataStorage.json";
  private static final String USER_DATA_STORAGE_PATH = "core/server/src/main/java/by/exposit/files/UserDataStorage.json";

  @Bean
  @ConditionalOnMissingBean
  public FileManager fileManager() {
    return new FileManager();
  }

  @Bean
  @ConditionalOnMissingBean
  public ArticleDataStorage articleDataStorage(FileManager fileManager) {
    return new ArticleDataStorage(
        fileManager,
        ARTICLE_DATA_STORAGE_PATH,
        ArticleDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public CategoryDataStorage categoryDataStorage(FileManager fileManager) {
    return new CategoryDataStorage(
        fileManager,
        CATEGORY_DATA_STORAGE_PATH,
        CategoryDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderDataStorage orderDataStorage(FileManager fileManager) {
    return new OrderDataStorage(
        fileManager,
        ORDER_DATA_STORAGE_PATH,
        OrderDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductDataStorage productDataStorage(FileManager fileManager) {
    return new ProductDataStorage(
        fileManager,
        PRODUCT_DATA_STORAGE_PATH,
        ProductDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopDataStorage shopDataStorage(FileManager fileManager) {
    return new ShopDataStorage(
        fileManager,
        SHOP_DATA_STORAGE_PATH,
        ShopDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public UserDataStorage userDataStorage(FileManager fileManager) {
    return new UserDataStorage(
        fileManager,
        USER_DATA_STORAGE_PATH,
        UserDataStorage.class
    );
  }

  @Bean
  @ConditionalOnMissingBean
  public ArticleRepository articleRepository(ArticleDataStorage articleDataStorage) {
    return new ArticleRepositoryImpl(articleDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public CategoryRepository categoryRepository(CategoryDataStorage categoryDataStorage) {
    return new CategoryRepositoryImpl(categoryDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderRepository orderRepository(OrderDataStorage orderDataStorage) {
    return new OrderRepositoryImpl(orderDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductRepository productRepository(ProductDataStorage productDataStorage) {
    return new ProductRepositoryImpl(productDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopRepository shopRepository(ShopDataStorage shopDataStorage) {
    return new ShopRepositoryImpl(shopDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public UserRepository userRepository(UserDataStorage userDataStorage) {
    return new UserRepositoryImpl(userDataStorage);
  }

  @Bean
  @ConditionalOnMissingBean
  public ArticleService articleService(ArticleRepository articleRepository) {
    return new ArticleServiceImpl(articleRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public CategoryService categoryService(CategoryRepository categoryRepository) {
    return new CategoryServiceImpl(categoryRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderService orderService(OrderRepository orderRepository) {
    return new OrderServiceImpl(orderRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductService productService(ProductRepository productRepository) {
    return new ProductServiceImpl(productRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopService shopService(ShopRepository shopRepository) {
    return new ShopServiceImpl(shopRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public UserService userService(UserRepository userRepository) {
    return new UserServiceImpl(userRepository);
  }

  @Bean
  @ConditionalOnMissingBean
  public ArticleController articleController(ArticleService articleService) {
    return new ArticleController(articleService);
  }

  @Bean
  @ConditionalOnMissingBean
  public CategoryController categoryController(CategoryService categoryService) {
    return new CategoryController(categoryService);
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderController orderController(OrderService orderService) {
    return new OrderController(orderService);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductController productController(ProductService productService) {
    return new ProductController(productService);
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopController shopController(ShopService shopService) {
    return new ShopController(shopService);
  }

  @Bean
  @ConditionalOnMissingBean
  public UserController userController(UserService userService) {
    return new UserController(userService);
  }
}
