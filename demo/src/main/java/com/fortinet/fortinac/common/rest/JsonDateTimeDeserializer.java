package com.fortinet.fortinac.common.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateTimeDeserializer extends JsonDeserializer<Date>
{
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
	{
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(DataConsts.DateFormat.DateTime);

			return dateFormat.parse(jp.getText());
		}
		catch( ParseException e )
		{
			return null;
		}
	}
}
