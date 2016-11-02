package com.gdgxwl.core.common.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	@Override
	public void serialize(Date date, JsonGenerator generator,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		String formattedDate = dateFormat.format(date);

		generator.writeString(formattedDate);

	}

}
