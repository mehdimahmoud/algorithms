package com.mmik.trainings.algorithm;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	
	private static HashMap<String, Integer> hmPatterns;

	public static String FindLongestPattern(String input) {
		hmPatterns = new HashMap<>();
		System.out.println("\n Input = "+input);
		for(int i=0;i<input.length();i++){
			for (int j = i+2; j < input.length(); j++) {
					String patternStr = input.substring(i, j);
					updateHashMapPatterns(input, patternStr);
			}
		}
		
		// Get the longest and first pattern :
		String longestPattern = "";
		int maxLength = 0;
		for (String currentPattern : hmPatterns.keySet()) {
			// compare the size
			if(currentPattern.length()>maxLength){
				longestPattern = currentPattern;
				maxLength = longestPattern.length();
			}else if(currentPattern.length()==maxLength){
				// compare the index
				Integer indexCurrentPattern = hmPatterns.get(currentPattern);
				Integer indexLongestPattern = hmPatterns.get(longestPattern);
				//System.out.println("currentPattern = ["+currentPattern+"] ;index current pattern = ["+ indexCurrentPattern + "] ; longestPattern = ["+longestPattern+"] ;index longest pattern = ["+ indexLongestPattern+"]");
				if(indexCurrentPattern < indexLongestPattern){
					longestPattern = currentPattern;
				}
			}
		}
		System.out.println("longest pattern = ["+ longestPattern+"]");
		
		
		return longestPattern;
	}
	
	public static void updateHashMapPatterns(String input, String patternStr){
		
		int count = 0, index = 0;
		Pattern pattern = Pattern.compile(patternStr);
        // to ignore case sensitivity, use instead :
        // Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        // check if the pattern is found
        while (matcher.find()) {
            if(count==0) { // Get the index at the beginning
            	index = matcher.start();
            	//System.out.println("count = ["+count + "] ; patternStr = ["+ patternStr + "] ; index = ["+index+"]");
            }
        	count++;
        }
        if(count>1){ // get only if the pattern appears more than once
        	System.out.println("count = ["+count + "] ; patternStr = ["+ patternStr + "] ; index = ["+index+"]");
        	hmPatterns.put(patternStr, index);
        }
	}

}
