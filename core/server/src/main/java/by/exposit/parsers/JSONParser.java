package by.exposit.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class JSONParser implements Parser {

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Override
  public String serialize(Object objectToSerialize, Type type) {
    return gson.toJson(objectToSerialize, type);
  }

  @Override
  public Object deserialize(String data, Type type) {
    return gson.fromJson(data, type);
  }
}
