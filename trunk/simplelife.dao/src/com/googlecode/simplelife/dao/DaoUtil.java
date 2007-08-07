package com.googlecode.simplelife.dao;

public abstract class DaoUtil {

	public static String getLikeString(String keyword, String escape) {
		if (keyword != null && escape != null) {
			return keyword.replaceAll(escape, escape + escape).replaceAll("_",
					escape + "_").replaceAll("%", escape + "%");
		}
		return null;
	}

	private DaoUtil() {
	}
}
