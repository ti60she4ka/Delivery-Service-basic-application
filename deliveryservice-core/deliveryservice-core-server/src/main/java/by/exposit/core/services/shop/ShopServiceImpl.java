package by.exposit.core.services.shop;

import by.exposit.core.dto.ShopDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.shop.ShopRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ShopServiceImpl extends AbstractServiceImpl<Shop, ShopDto> implements ShopService {

  private final ShopRepository shopRepository;

  public ShopServiceImpl(ShopRepository shopRepository, BaseMapper<Shop, ShopDto> mapper) {
    super(shopRepository, mapper);
    this.shopRepository = shopRepository;
  }
}
