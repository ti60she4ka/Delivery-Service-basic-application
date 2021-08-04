package by.exposit.web.mappers;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.dto.ShopDto;
import by.exposit.web.requests.ArticleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ArticleRequestMapper {

  @Mapping(target = "shop", source = "shopId", qualifiedByName = "shopIdToShop")
  @Mapping(target = "product", source = "productId", qualifiedByName = "productIdToProduct")
  ArticleDto toDto(ArticleRequest articleRequest);

  @Mapping(target = "shop", source = "articleRequest.shopId", qualifiedByName = "shopIdToShop")
  @Mapping(target = "product", source = "articleRequest.productId", qualifiedByName = "productIdToProduct")
  ArticleDto toDtoWithId(ArticleRequest articleRequest, Long id);

  @Named("shopIdToShop")
  default ShopDto shopIdToShop(Long shopId){
    ShopDto shopDto = new ShopDto();
    shopDto.setId(shopId);
    return shopDto;
  }

  @Named("productIdToProduct")
  default ProductDto productIdToProduct(Long productId){
    ProductDto productDto = new ProductDto();
    productDto.setId(productId);
    return productDto;
  }
}
