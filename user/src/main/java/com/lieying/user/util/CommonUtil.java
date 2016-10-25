package com.lieying.user.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

	private static final String EMPTY_STR = "";
	private static final String LIKE_SYMBOL = "%";
	public static final String CHARESET_UTF8 = "UTF-8";



	public static String emptyToNull(Object obj) {
		if(obj == null || EMPTY_STR.equals(obj.toString().trim())) {
			return null;
		}
		return obj.toString();
	}

	public static String getLikeQueryStr(String param) {
		return emptyToNull(param) == null ? null : LIKE_SYMBOL + param.trim() + LIKE_SYMBOL;
	}

	public static String convertToCharSetUTF8(String source) {
		if(StringUtils.isNotEmpty(source)) {
			try {
				return new String(source.getBytes(),CHARESET_UTF8);
//								return new String(source.getBytes(CHARESET_ISO),CHARESET_UTF8);
			} catch (UnsupportedEncodingException e) {
				return source;
			}
		}
		return source;
	}

}
