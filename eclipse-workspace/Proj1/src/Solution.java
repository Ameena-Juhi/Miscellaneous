import java.util.*;
public class Solution {
	 public static void toHinduArabic(String roman) {
	        //your code here
		 Map<Character, Integer> map=new HashMap<Character, Integer>();  
	       
	        map.put('I',1);  
	        map.put('V',5);  
	        map.put('X',10);  
	        map.put('L',50);  
	        map.put('C',100);  
	        map.put('D',500);  
	        map.put('M',1000);    
	        roman = roman.replace("IV","IIII");  
	        roman = roman.replace("IX","VIIII");  
	        roman = roman.replace("XL","XXXX");  
	        roman = roman.replace("XC","LXXXX");  
	        roman = roman.replace("CD","CCCC");  
	        roman = roman.replace("CM","DCCCC");  
	        int number = 0;  
	      
	        for (int i = 0; i < roman.length(); i++)  
	        {  
	   
	            number = number + (map.get(roman.charAt(i)));  
	        }  
	        
	        System.out.println (number); 
	       
	    }
	 	
	 public static void toRoman(int num) {
		 int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		 String[] romanLetters= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		 StringBuilder roman = new StringBuilder();
		 for (int i = 0; i < values.length; i++) {
		while(num>=values[i]) {
			
			num = num- values[i];
			roman.append(romanLetters[i]);
			
		}	 
		 }
		 System.out.println(roman);
		 }
		 
		 
	        public static void main(String [] args) {
	        	toHinduArabic("MCDXCVI");
	        	toRoman(252);
	        }
}



