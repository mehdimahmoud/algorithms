package com.mmik.trainings.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// 3. Add the right runner for parameterizing
@RunWith(Parameterized.class)
public class LongestPatternTest {

	// 1. Declare fields and the custom constructor with the fields in signature :
	private String inputString, expectedResult;
	public LongestPatternTest(String input, String pattern){
		this.inputString = input;
		this.expectedResult = pattern;
	}
		
	// 2. Declare the static method, annotate it and create the static datas 
	@Parameters
	public static Collection<String[]> datas(){
		String[][] arrayStrings = new String[][]{
			{"abcwxyzabghwxyz", "wxyz"},
			{"abcadefcb", ""},
			{"abcaeabcaeabcdabcd", "abcae"}
		};
		return Arrays.asList(arrayStrings);
	}
		
	@Test
	public void findLongestPatternInString_ShouldCheckPositivesValues()
	{
		String result = Solution.FindLongestPattern(inputString);
		assertEquals(expectedResult, result);
	}
	
}
