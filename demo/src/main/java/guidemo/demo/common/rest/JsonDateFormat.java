package guidemo.demo.common.rest;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class JsonDateFormat extends DateFormat {
 
	private DateFormat dateFormat;
 
	private SimpleDateFormat defaultFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
 
	public JsonDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
 
	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		return dateFormat.format(date, toAppendTo, fieldPosition);
	}
 
	@Override
	public Date parse(String source, ParsePosition pos) {
 
		Date date = null;
 
		try {
 
			date = dateFormat.parse(source, pos);
		} catch (Exception e) {
 
			date = defaultFormat.parse(source, pos);
		}
 
		return date;
	}
 
	@Override
	public Date parse(String source) throws ParseException {
 
		Date date = null;
 
		try {
			date = dateFormat.parse(source);
		} catch (Exception e) {
			date = defaultFormat.parse(source);
		}
 
		return date;
	}
 
	@Override
	public Object clone() {
		Object format = dateFormat.clone();
		return new JsonDateFormat((DateFormat) format);
	}
}
