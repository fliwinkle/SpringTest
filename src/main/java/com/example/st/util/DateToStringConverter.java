package com.example.st.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class DateToStringConverter implements AttributeConverter<String, String>{

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return attribute;
	}

  @Override
	public String convertToEntityAttribute(String dbData) {
		StringBuilder sb = new StringBuilder();
		if(dbData!=null) {
			SimpleDateFormat dbFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = null;
			try {
				date = dbFormat.parse(dbData);
				SimpleDateFormat entityFormat = new SimpleDateFormat("yyyyMMdd");
				sb.append(entityFormat.format(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return sb.toString();
		}
		return dbData;
	}

}
