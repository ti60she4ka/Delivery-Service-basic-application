package by.exposit.core.parsers.json;

import by.exposit.core.model.entities.Attribute;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AttributeJsonDeserializer implements JsonDeserializer<Attribute> {

  @Override
  public Attribute deserialize(JsonElement jsonElement, Type type,
      JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

    JsonObject jsonObject = jsonElement.getAsJsonObject();

    try {
      return Attribute.builder()
          .name(jsonObject.get("name").getAsString())
          .description(jsonObject.get("description").getAsString())
          .type(Class.forName(jsonObject.get("type").getAsString()))
          .build();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}