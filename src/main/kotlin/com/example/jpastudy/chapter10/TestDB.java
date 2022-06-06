package com.example.jpastudy.chapter10;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class TestDB extends H2Dialect {

	public TestDB() {
		registerFunction("group_concat", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
	}
}
