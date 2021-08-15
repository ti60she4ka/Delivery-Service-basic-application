package by.exposit.core.services.order;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.OrderItemDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Order;
import by.exposit.core.model.entities.OrderItem;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.core.repositories.OrderRepository;
import by.exposit.core.repositories.UserRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDto> implements OrderService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;
  private final ArticleRepository articleRepository;

  public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository,
      ArticleRepository articleRepository, BaseMapper<Order, OrderDto> orderMapper) {
    super(orderRepository, orderMapper);
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
    this.articleRepository = articleRepository;
    entityType = "Order";
  }

  @Override
  public OrderDto create(OrderDto orderDto) {
    return mapper.toDto(orderRepository.create(mapToOrder(orderDto)));
  }

  @Override
  public void deleteById(Long id) {
    if (orderRepository.existsById(id)) {
      super.deleteById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public void update(OrderDto orderDto) {
    Order order = mapToOrder(orderDto);
    order.setVersion(getVersionByOrderId(orderDto.getId()));
    orderRepository.update(order);
  }

  @Override
  public OrderDto getById(Long id) {
    if (orderRepository.existsById(id)) {
      return super.getById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  private Order mapToOrder(OrderDto orderDto) {
    Order order = mapper.toEntity(orderDto);

    if (userRepository.existsById(orderDto.getUser().getId())) {
      order.setUser(userRepository.getById(orderDto.getUser().getId()));
    } else {
      throw new EntityNotFoundException("User", orderDto.getUser().getId());
    }

    Collection<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemDto orderItemDto : orderDto.getOrderItems()) {
      if (articleRepository.existsById(orderItemDto.getArticle().getId())) {
        OrderItem orderItem = OrderItem.builder()
            .quantity(orderItemDto.getQuantity())
            .article(articleRepository.getById(orderItemDto.getArticle().getId()))
            .build();
        orderItem.setPrice(orderItem.getArticle().getPrice());

        orderItems.add(orderItem);
      } else {
        throw new EntityNotFoundException("Article", orderItemDto.getArticle().getId());
      }
    }
    order.setOrderItems(orderItems);
    order.setTotalCost(getTotalCost(order));
    order.setCreationDate(LocalDate.now());

    return order;
  }

  private Double getTotalCost(Order order) {
    double totalCost = 0;

    for (OrderItem orderItem : order.getOrderItems()) {
      totalCost += orderItem.getQuantity() * orderItem.getPrice();
    }

    return totalCost;
  }

  private Long getVersionByOrderId(Long id) {
    if (orderRepository.existsById(id)) {
      return orderRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
