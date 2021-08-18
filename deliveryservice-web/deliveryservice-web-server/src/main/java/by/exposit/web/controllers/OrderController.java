package by.exposit.web.controllers;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.services.order.OrderService;
import by.exposit.web.mappers.OrderRequestMapper;
import by.exposit.web.requests.OrderRequest;
import by.exposit.web.response.ResponseBody;
import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<OrderDto> create(@RequestBody @Valid OrderRequest orderRequest) {
    return new ResponseEntity<>(
        orderService.create(mapper.toDto(orderRequest)),
        HttpStatus.CREATED
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(
        orderService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<OrderDto>> getAll() {
    return new ResponseEntity<>(
        orderService.getAll(),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid OrderRequest orderRequest) {

    orderService.update(mapper.toDtoWithId(orderRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id) {
    orderService.deleteById(id);
    return ResponseBody.successOperation();
  }
}
