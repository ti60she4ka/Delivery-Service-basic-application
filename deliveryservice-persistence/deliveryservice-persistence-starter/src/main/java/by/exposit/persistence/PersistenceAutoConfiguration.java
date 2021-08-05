package by.exposit.persistence;

import by.exposit.core.CoreAutoConfiguration;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.core.repositories.OrderRepository;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.core.repositories.UserRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import by.exposit.persistence.mappers.CategoryPersistenceMapper;
import by.exposit.persistence.mappers.OrderPersistenceMapper;
import by.exposit.persistence.mappers.ProductPersistenceMapper;
import by.exposit.persistence.mappers.ShopPersistenceMapper;
import by.exposit.persistence.mappers.UserPersistenceMapper;
import by.exposit.persistence.repositories.article.ArticleJpaRepository;
import by.exposit.persistence.repositories.article.ArticleRepositoryImpl;
import by.exposit.persistence.repositories.category.CategoryJpaRepository;
import by.exposit.persistence.repositories.category.CategoryRepositoryImpl;
import by.exposit.persistence.repositories.order.OrderJpaRepository;
import by.exposit.persistence.repositories.order.OrderRepositoryImpl;
import by.exposit.persistence.repositories.order.orderitem.OrderItemJpaRepository;
import by.exposit.persistence.repositories.product.ProductJpaRepository;
import by.exposit.persistence.repositories.product.ProductRepositoryImpl;
import by.exposit.persistence.repositories.product.attribute.AttributeJpaRepository;
import by.exposit.persistence.repositories.shop.ShopJpaRepository;
import by.exposit.persistence.repositories.shop.ShopRepositoryImpl;
import by.exposit.persistence.repositories.user.UserJpaRepository;
import by.exposit.persistence.repositories.user.UserRepositoryImpl;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "by.exposit.persistence")
@EntityScan(basePackages = "by.exposit.persistence")
@EnableJpaRepositories(basePackages = "by.exposit.persistence")
@AutoConfigureBefore({CoreAutoConfiguration.class})
public class PersistenceAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public CategoryRepository categoryRepository(CategoryJpaRepository categoryJpaRepository,
      CategoryPersistenceMapper categoryMapper, ProductPersistenceMapper productMapper) {

    return new CategoryRepositoryImpl(categoryJpaRepository, categoryMapper, productMapper);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProductRepository productRepository(ProductJpaRepository productJpaRepository,
      AttributeJpaRepository attributeJpaRepository, ProductPersistenceMapper productMapper,
      ArticlePersistenceMapper articleMapper){

    return new ProductRepositoryImpl(productJpaRepository, attributeJpaRepository,
        productMapper, articleMapper);
  }

  @Bean
  @ConditionalOnMissingBean
  public UserRepository userRepository(UserJpaRepository userJpaRepository,
      UserPersistenceMapper userMapper, OrderPersistenceMapper orderMapper){

    return new UserRepositoryImpl(userJpaRepository, userMapper, orderMapper);
  }

  @Bean
  @ConditionalOnMissingBean
  public ShopRepository shopRepository(ShopJpaRepository shopJpaRepository,
      ShopPersistenceMapper shopMapper, ArticlePersistenceMapper articleMapper){

    return new ShopRepositoryImpl(shopJpaRepository, shopMapper, articleMapper);
  }

  @Bean
  @ConditionalOnMissingBean
  public ArticleRepository articleRepository(ArticleJpaRepository articleJpaRepository,
      ArticlePersistenceMapper mapper){

    return new ArticleRepositoryImpl(articleJpaRepository, mapper);
  }

  @Bean
  @ConditionalOnMissingBean
  public OrderRepository orderRepository(OrderJpaRepository orderJpaRepository,
      OrderItemJpaRepository orderItemJpaRepository, OrderPersistenceMapper mapper){

    return new OrderRepositoryImpl(orderJpaRepository, orderItemJpaRepository, mapper);
  }
}
