package com.codility.tasks.utility;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inverter {
	
	
	public static String invert(String string) {
        return Stream.of(string==null?"":string)
            .map(word->new StringBuilder(word).reverse())
            .collect(Collectors.joining(" "));
    }
	
	   public static void main(String[] args) {

           System.out.println(invert("abcd"));
       }

}
