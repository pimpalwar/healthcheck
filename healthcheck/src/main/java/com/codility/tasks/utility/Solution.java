package com.codility.tasks.utility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	static String solution(String str) {

		try {
			Map<Character, Long> collect = str.chars().mapToObj(i -> (char) i)
					.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

			Optional<Character> firstRepeat = collect.entrySet().stream().filter((e) -> e.getValue() > 1)
					.map(e -> e.getKey()).findFirst();

			return firstRepeat.orElse(null).toString();
		} catch (NullPointerException nex) {
			nex.printStackTrace();
		}
		return "No repeating letter available";

	}

	public static void main(String[] args) {
		String str = "codility";
		System.out.println("Repeating Letter:" + solution(str));
	}

}
