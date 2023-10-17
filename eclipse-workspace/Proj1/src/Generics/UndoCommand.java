package Generics;

import java.util.List;

public class UndoCommand {
	public List<Character> execute(List<Character> text, List<Character> Stack) {
        if (!text.isEmpty()) {
            char removedChar = text.remove(text.size() - 1);
            Stack.add(removedChar);
            return Stack;
        }
        else {
        	System.out.println("Text is empty to perform backspace operation");
        	return null;
        }
    }

}
