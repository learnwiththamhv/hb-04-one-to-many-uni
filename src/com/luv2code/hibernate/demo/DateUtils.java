package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String dateString) throws ParseException {
		Date result = formatter.parse(dateString);
		return result;

	}

	public static String formatDate(Date date) {
		String result = null;
		if (date != null) {
			result = formatter.format(date);
		}

		return result;
	}
}
