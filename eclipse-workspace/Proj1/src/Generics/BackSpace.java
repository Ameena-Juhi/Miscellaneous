package Generics;

import java.util.List; 

public class BackSpace {
	public List<Character> execute(List<Character> text) {
        if (!text.isEmpty()) {
            text.remove(text.size() - 1);
        }
        return text;
    }
}
