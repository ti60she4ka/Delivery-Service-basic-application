package by.exposit.core;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.mappers.article.ArticleMapper;
import by.exposit.core.mappers.category.CategoryMapper;
import by.exposit.core.mappers.order.OrderMapper;
import by.exposit.core.mappers.product.ProductMapper;
import by.exposit.core.mappers.shop.ShopMapper;
import by.exposit.core.mappers.user.UserMapper;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.core.repositories.OrderRepository;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.core.repositories.UserRepository;
import by.exposit.core.services.article.ArticleService;
import by.exposit.core.services.article.ArticleServiceImpl;
import by.exposit.core.services.category.CategoryService;
import by.exposit.core.services.category.CategoryServiceImpl;
import by.exposit.core.services.order.OrderService;
import by.exposit.core.services.order.OrderServiceImpl;
import by.exposit.core.services.product.ProductService;
import by.exposit.core.services.product.ProductServiceImpl;
import by.exposit.core.services.shop.ShopService;
import by.exposit.core.services.shop.ShopServiceImpl;
import by.exposit.core.services.user.UserService;
import by.exposit.core.services.user.UserServiceImpl;
import by.exposit.core.storages.ArticleDataStorage;
import by.exposit.core.storages.CategoryDataStorage;
import by.exposit.core.storages.OrderDataStorage;
import by.exposit.core.storages.ProductDataStorage;
import by.exposit.core.storages.ShopDataStorage;
import by.exposit.core.storages.UserDataStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.exposit.core"})
public class CoreAutoConfiguration {

  private static final String ARTICLE_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/ArticleDataStorage.json";
  private static final String CATEGORY_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/CategoryDataStorage.json";
  private static final String ORDER_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/OrderDataStorage.json";
  private static final String PRODUCT_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/ProductDataStorage.json";
  private static final String SHOP_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/ShopDataStorage.json";
  private static final String USER_DATA_STORAGE_PATH = "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/UserDataStorage.json";

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
  public ArticleService articleService(ArticleRepository articleRepository,
      ShopRepository shopRepository, ProductRepository productRepository) {

    return new ArticleServiceImpl(articleRepository, shopRepository,
        productRepository, ArticleMapper.INSTANCE);
  }

  @Bean
  @ConditionalOnMissingBean
  public CategoryService categoryService(CategoryRepository categoryRepository) {
    return new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE, ProductMapper.INSTANCE);
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderService orderService(OrderRepository orderRepository, UserRepository userRepository,
      ArticleRepository articleRepository) {
    return new OrderServiceImpl(orderRepository, userRepository, articleRepository, OrderMapper.INSTANCE);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductService productService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    return new ProductServiceImpl(productRepository, categoryRepository, ProductMapper.INSTANCE, ArticleMapper.INSTANCE);
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopService shopService(ShopRepository shopRepository) {
    return new ShopServiceImpl(shopRepository, ShopMapper.INSTANCE, ArticleMapper.INSTANCE);
  }

  @Bean
  @ConditionalOnMissingBean
  public UserService userService(UserRepository userRepository) {
    return new UserServiceImpl(userRepository, UserMapper.INSTANCE, OrderMapper.INSTANCE);
  }
}