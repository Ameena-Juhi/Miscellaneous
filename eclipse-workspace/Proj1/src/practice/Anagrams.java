package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

    
    public static Map<String,List<String>> isAnagram(List<String> words){

        Map<String,List<String>> AnagramGroups = new HashMap<>();
        for (String word : words){
            char[] wordletters = word.toLowerCase().toCharArray();
            Arrays.sort(wordletters);
            String sortedWord = new String(wordletters);
            System.out.println(sortedWord);

            if(!AnagramGroups.containsKey(sortedWord)){
                AnagramGroups.put(sortedWord, new ArrayList<>());
            }

            AnagramGroups.get(sortedWord).add(word);

        }


        return AnagramGroups; 
    }

    public static void main(String[] args) {
        List<String> AnList = new ArrayList<>(Arrays.asList("god","dog","Spear","Pears","cat","mouse"));
        System.out.println( );
        System.out.println(isAnagram(AnList));

        List<List<String>> wordsList = isAnagram(AnList).values().stream()
        .filter(list -> list.size()>1)
        .collect(Collectors.toList());

        System.out.println(wordsList);
        


    }
}
