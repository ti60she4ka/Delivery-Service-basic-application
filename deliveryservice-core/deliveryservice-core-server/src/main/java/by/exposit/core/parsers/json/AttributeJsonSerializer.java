package by.exposit.core.parsers.json;

import by.exposit.core.model.entities.Attribute;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class AttributeJsonSerializer implements JsonSerializer<Attribute> {

  @Override
  public JsonElement serialize(Attribute attribute, Type type,
      JsonSerializationContext jsonSerializationContext) {

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", attribute.getName());
    jsonObject.addProperty("description", attribute.getDescription());
    jsonObject.addProperty("type", attribute.getType().getName());

    return jsonObject;
  }
}