package model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AttributeValue<T> {
    private Attribute<T> attribute;
    private Object value;
}
