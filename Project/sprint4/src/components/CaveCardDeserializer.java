package components;

import animals.Animal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.awt.*;
import java.io.IOException;

public class CaveCardDeserializer extends StdDeserializer<CaveCard> {

    public CaveCardDeserializer() {
        this(null);
    }

    public CaveCardDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public CaveCard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        Animal animal = codec.treeToValue(node.get("animal"), Animal.class);
        Point point = codec.treeToValue(node.get("point"), Point.class);
        boolean isOccupied = node.get("isOccupied").asBoolean();

        CaveCard caveCard = new CaveCard(animal);
        caveCard.setPoint(point);
        caveCard.setOccupied(isOccupied);

        return caveCard;
    }
}
