package Util;

public class StringUtil {
	public static String getString(String value) {
		return value == null?"":value;
	}
	public static String getString(Object value) {
		return value ==null?"":String.valueOf(value);
	}

}
