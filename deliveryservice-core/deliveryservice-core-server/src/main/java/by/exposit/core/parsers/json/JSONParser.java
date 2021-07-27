package by.exposit.core.parsers.json;

import by.exposit.core.model.entities.Attribute;
import by.exposit.core.parsers.Parser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class JSONParser implements Parser {

  private static final Gson gson = new GsonBuilder()
      .setPrettyPrinting()
      .registerTypeAdapter(Attribute.class, new AttributeJsonSerializer())
      .registerTypeAdapter(Attribute.class, new AttributeJsonDeserializer())
      .create();

  @Override
  public String serialize(Object objectToSerialize, Type type) {
    return gson.toJson(objectToSerialize, type);
  }

  @Override
  public Object deserialize(String data, Type type) {
    return gson.fromJson(data, type);
  }
}
