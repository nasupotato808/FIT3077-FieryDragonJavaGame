package components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TokenSerializer extends StdSerializer<Token> {

    public TokenSerializer() {
        this(null);
    }

    public TokenSerializer(Class<Token> t) {
        super(t);
    }

    @Override
    public void serialize(Token token, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("dragonColour", token.getDragonColour());
        jsonGenerator.writeNumberField("position", token.getPosition());
        //jsonGenerator.writeObjectField("imageCorner", token.getImageCorner());
        jsonGenerator.writeObjectField("cave", token.getBornCave());
        jsonGenerator.writeObjectField("path", token.getPath());
        //jsonGenerator.writeBooleanField("hasFlipped", token.isHasFlipped());
        jsonGenerator.writeNumberField("currentSteps", token.getCurrentSteps());
        jsonGenerator.writeBooleanField("inCave", token.isInCave());
        jsonGenerator.writeEndObject();
    }
}
