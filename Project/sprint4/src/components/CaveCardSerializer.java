package components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CaveCardSerializer extends StdSerializer<CaveCard> {

    public CaveCardSerializer() {
        this(null);
    }

    public CaveCardSerializer(Class<CaveCard> t) {
        super(t);
    }

    @Override
    public void serialize(CaveCard caveCard, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("animal", caveCard.getAnimal());
        jsonGenerator.writeObjectField("point", caveCard.getPoint());
        jsonGenerator.writeBooleanField("isOccupied", caveCard.isOccupied());
        jsonGenerator.writeEndObject();
    }
}
