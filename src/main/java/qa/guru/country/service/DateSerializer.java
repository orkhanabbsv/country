package qa.guru.country.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date>{
    private final String format;

    public DateSerializer(final String format) {
        this.format = format;
    }

    @Override
    public void serialize(
            final Date value, final JsonGenerator jgen, final SerializerProvider provider
    ) throws IOException {
        jgen.writeString(new SimpleDateFormat(format).format(value));
    }
}
