package com.lieying.user.util;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.util.StringUtils;

public class CustomTimestampEditor extends PropertyEditorSupport{
	
	private final DateFormat dateFormat;

	private final boolean allowEmpty;


	public CustomTimestampEditor(DateFormat dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
	}


	/**
	 * Parse the Date from the given text, using the specified DateFormat.
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else {
			try {
				setValue(new Timestamp(this.dateFormat.parse(text).getTime()));
			}
			catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	@Override
	public String getAsText() {
		Timestamp value = (Timestamp) getValue();
		if(value == null) {
			return null;
		} else {
			Date date = new Date();
			date.setTime(value.getTime());
			return this.dateFormat.format(date);
		}
	}

}
