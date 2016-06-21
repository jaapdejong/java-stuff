//package com.crunchify.tutorials;

import java.util.ArrayList;

//import java.util.HashMap;
//import java.util.TreeMap;
//import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class CrunchifyJava8ForEachTutorialMapAndList {

	public static void main(String[] args) {

		// =============== MAP ================
//		Map<String, String> crunchifyCompanyMap = new HashMap<>();
//		Map<String, String> crunchifyCompanyMap = new TreeMap<>();
//		Map<String, String> crunchifyCompanyMap = new LinkedHashMap<>();
		Map<String, String> crunchifyCompanyMap = new ConcurrentHashMap<>();

		crunchifyCompanyMap.put("Google", "Mountain View");
		crunchifyCompanyMap.put("Facebook", "Santa Clara");
		crunchifyCompanyMap.put("Twitter", "San Francisco");

		// Method1: Standard Method to iterate through Java Map
		CrunchifyStandardForEachMethod4Map(crunchifyCompanyMap);
		// Method2: Java8 Method to iterate through Java Map
		CrunchifyJava8ForEachMethod4Map(crunchifyCompanyMap);

		// =============== List ================
		List<String> crunchifyCompanyList = new ArrayList<>();
		crunchifyCompanyList.add("Google");
		crunchifyCompanyList.add("Facebook");
		crunchifyCompanyList.add("Twitter");

		// Method3: Standard Method to iterate through Java List
		CrunchifyStandardForEachMethod4List(crunchifyCompanyList);
		// Method4,5: Java8 Method to iterate through Java List
		CrunchifyJava8ForEachMethod4List(crunchifyCompanyList);

	}

	private static void CrunchifyStandardForEachMethod4Map(Map<String, String> crunchifyCompanyMap) {

		log("============ Method1: Standard Method to iterate through Java Map");
		for (Map.Entry<String, String> crunchifyEntry : crunchifyCompanyMap.entrySet()) {
			log("crunchifyCompany: " + crunchifyEntry.getKey() + ", address: " + crunchifyEntry.getValue());
		}

		log("\n============ Method2: Using Iterator");
		Iterator<Map.Entry<String, String>> crunchifyIterator = crunchifyCompanyMap.entrySet().iterator();
		while (crunchifyIterator.hasNext()) {
			Map.Entry<String, String> crunchifyEntry = crunchifyIterator.next();
			log("crunchifyCompany: " + crunchifyEntry.getKey() + ", address: " + crunchifyEntry.getValue());
		}

	}

	private static void CrunchifyJava8ForEachMethod4Map(Map<String, String> crunchifyCompanyMap) {

		log("\n============ Method3: Java8 Method to iterate through Java Map");
		crunchifyCompanyMap.forEach((k, v) -> log("crunchifyCompany: " + k + ", address: " + v));

	}

	private static void CrunchifyStandardForEachMethod4List(List<String> crunchifyList) {

		log("\n============ Method3: Standard Method to iterate through Java List");
		for (String item : crunchifyList) {
			log(item);
		}

	}

	private static void CrunchifyJava8ForEachMethod4List(List<String> crunchifyList) {

		// lambda method
		log("\n============ Method4: Java8 Method to iterate through Java List - using Lambda");
		crunchifyList.forEach(item -> log(item));

		// using method reference
		log("\n============ Method5: Java8 Method to iterate through Java List - using Method Reference");
		crunchifyList.forEach(System.out::println);

	}

	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
	}
}

