package com.ycw.controller;

public class SystemConstant {
	
	public static final String HOST = "127.0.0.1";
	public static String user = "sa";
	public static String password = "!Asdqaz80323";
	
	
//	public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=servdb"
//			+ "encrypt=false;user=" + user + ";password=" + password;
	
	public static String dbURL = "jdbc:sqlserver://" + HOST 
			+ ":1433;databaseName=stock;encrypt=false;user=" + user + ";password=" + password;

	static {
		System.out.println("dbURL=" + dbURL);
		System.out.println("user=" + user);
		System.out.println("password=" + password);
	}

	public static String getDbURL() {
		return dbURL;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}
	
	
}
