package components;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TokenDeserializer extends StdDeserializer<Token> {

    public TokenDeserializer() {
        this(null);
    }

    public TokenDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Token deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        String dragonColour = node.get("dragonColour").asText();
        int position = node.get("position").asInt();
        Point imageCorner = codec.treeToValue(node.get("imageCorner"), Point.class);
        CaveCard cave = codec.treeToValue(node.get("cave"), CaveCard.class);
        ArrayList<GameComponent> path = codec.treeToValue(node.get("path"), ArrayList.class);
        boolean hasFlipped = node.get("hasFlipped").asBoolean();
        int currentSteps = node.get("currentSteps").asInt();
        boolean inCave = node.get("inCave").asBoolean();

        Token token = new Token(dragonColour);
        token.setPosition(position);
        //token.setImageCorner(imageCorner);
        token.setBornCave(cave);
        //token.setPath(path);
        token.setHasFlipped(hasFlipped);
        token.setCurrentSteps(currentSteps);
        token.setInCave(inCave);

        return token;
    }
}
