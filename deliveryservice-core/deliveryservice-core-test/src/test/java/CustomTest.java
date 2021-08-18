import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomTest {

  private List<Integer> integers;

  @BeforeEach
  public void setEmptyList(){
    integers = new ArrayList<>();
  }

  @AfterEach
  public void setListNull(){
    integers = null;
  }

  @Test
  void testIsListEmpty(){
    Assertions.assertTrue(integers.isEmpty());
  }
}
