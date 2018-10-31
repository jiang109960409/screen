package com.screen.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JavaTest {

	public static void main(String[] args) {
		String s= "data.id=2\r\n" + 
				"content=<p>撒打算</p><figure class=\"image\"><img src=\"/image/1540361362456.png\"></figure>\r\n" + 
				"";
		System.out.println(s.substring(19));
	}
}
