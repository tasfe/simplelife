/*
 * Copyright 2007 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *      
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.simplelife.dao;

/**
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public abstract class DaoUtil {

	/**
	 * 用于将SQL中like关键字中的特殊字符替代
	 * 
	 * @param keyword
	 *            the keyword
	 * @param escape
	 *            the escape
	 * 
	 * @return the like string
	 */
	public static String getLikeString(String keyword, String escape) {
		if (keyword != null && escape != null) {
			return keyword.replaceAll(escape, escape + escape).replaceAll("_",
					escape + "_").replaceAll("%", escape + "%");
		}
		return null;
	}

	/**
	 * The Constructor.
	 */
	private DaoUtil() {
	}
}
