package com.tkksys.backendninja.util;

public class MyUtil {
	/**
	 * Validacion de campos nulos
	 * @param obj
	 * @return
	 */
	public static String isNull(Object obj) {
		return obj == null ? "" : (String) obj;
	}
}
