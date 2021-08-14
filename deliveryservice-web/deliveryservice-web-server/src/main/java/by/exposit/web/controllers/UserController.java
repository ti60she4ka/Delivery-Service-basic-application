package by.exposit.web.controllers;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.UserDto;
import by.exposit.core.services.user.UserService;
import by.exposit.web.mappers.UserRequestMapper;
import by.exposit.web.requests.UserRequest;
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
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<UserDto> create(@RequestBody @Valid UserRequest userRequest) {
    return new ResponseEntity<>(
        userService.create(
            mapper.toDto(userRequest),
            userRequest.getPassword(),
            userRequest.getRole()
        ),
        HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(
        userService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<UserDto>> getAll() {
    return new ResponseEntity<>(
        userService.getAll(),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid UserRequest userRequest) {

    userService.update(mapper.toDtoWithId(userRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id){
    userService.deleteById(id);
    return ResponseBody.successOperation();
  }

  @GetMapping("/{id}/orders")
  public ResponseEntity<Collection<OrderDto>> getOrderByUserId(@PathVariable Long id){
    return new ResponseEntity<>(
        userService.getOrdersByUserId(id),
        HttpStatus.OK
    );
  }
}
