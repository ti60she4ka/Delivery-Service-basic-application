package by.exposit.web.response;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBody {
  private ResponseBody(){
  }

  public static ResponseEntity<Map<String, String>> successOperation() {
    Map<String, String> response = new HashMap<>();
    response.put("status", "success");
    return new ResponseEntity<>(
        response,
        HttpStatus.OK
    );
  }
}
