package anagrams;
import java.util.*;
public class anagrams {
	public static boolean areAnagrams(String aWord, String bWord ) {
		int aLen = aWord.length();
		int bLen = bWord.length();
		
		if (aLen!=bLen)
			return false;
		
		aWord=aWord.toLowerCase();
		bWord=bWord.toLowerCase();
		
		char s1[]=aWord.toCharArray();
		Arrays.sort(s1);
		
		char s2[]=bWord.toCharArray();
		Arrays.sort(s2);
		
		return Arrays.equals(s1, s2);
			
		
	}
	
	public static void main(String [] args) {
		System.out.println(areAnagrams("care","Race"));
		System.out.println(areAnagrams("Spear","spare"));
		System.out.println(areAnagrams("cares","race"));
}

}
	
