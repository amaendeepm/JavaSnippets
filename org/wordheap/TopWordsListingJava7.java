package org.wordheap;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TopWordsListingJava7 {
	
	public TopWordsListingJava7() {
		
	}
	
	protected void printTopWords(String fileContents, int topWC) {
		Map<String, Integer> occurenceMap = new HashMap<String, Integer>(); // \\s+
		
		String wordsArr[] = fileContents.toLowerCase().trim().split("[\\n+\\s+\\,\\:\\!\\;\\?\\.]");
	
		for(String word: wordsArr) {
			if(word.trim().length()>0) {
				int times = 1;
				if(occurenceMap.containsKey(word))
					times = occurenceMap.get(word) + 1;
				occurenceMap.put(word, times);
			}
		}
		
		Map<String, Integer> sortedOccurences = sortDescending(occurenceMap);
		
		//Jdk8 sortedOccurences.forEach((k,v)->System.out.println(k + "("+ v + ")"));
		
		Iterator<Entry<String, Integer>> itr = sortedOccurences.entrySet().iterator();
		int i=0;
		
		while(itr.hasNext() && i <topWC) {
			Entry<String,Integer> e = itr.next();
			System.out.println(e.getKey() + "("+ e.getValue() + ")");
			i++;
		}
		
	}
	
	
	private Map<String,Integer >sortDescending(Map<String, Integer> inputMap) {
		
		//Collect items from map in order
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(inputMap.entrySet());
		
		//Constructed ordered map object to hold these Entry'ies
		LinkedHashMap<String,Integer> map =  new LinkedHashMap<String, Integer>();
				
		//Sort custom comparison way - http://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#sort(java.util.List, java.util.Comparator)
		Collections.sort(list, new Comparator<Entry<String, Integer>> () {
			
			//http://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html#compare(T, T)
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue()); //descend
			}
		});
		
		//Populate ordered map
		for(Entry<String,Integer> entry : list) {
			map.put(entry.getKey(),entry.getValue());
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Please provide Filename and Word in syntax: TopWordListingJava7 <FileNamePath>");			
		}
		else {
			try {
				System.out.println(args[0]);
				String content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
				TopWordsListingJava7 listing = new TopWordsListingJava7();
				//System.out.println(content);
				listing.printTopWords(content,10);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
