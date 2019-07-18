package com.fortinet.fortinac.common.rest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateTimeSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DataConsts.DateFormat.DateTime);
		gen.writeString(dateFormat.format(date));
	}
}
