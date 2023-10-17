package Generics;

import java.util.Deque;
import java.util.LinkedList;

public class FileProcessor {

	public static String processCommands(String initialText, String commandText) throws Exception {
	    StringBuilder result = new StringBuilder();
	    Deque<Character> undoStack = new LinkedList<>();
	    int initialTextIndex = 0;

	    for (char command : commandText.toCharArray()) {
	        if (command == '<') {
	            if (undoStack.isEmpty()) {
	                throw new Exception("Cannot perform <undo> without previous actions");
	            } else {
	                result.append(undoStack.pop());
	            }
	        } else if (command == '\b') {
	            if (initialTextIndex > 0) {
	                initialTextIndex--;
	            }
	        } else if (command == '\0') {
	            // Skip null character
	        } else {
	            undoStack.push(initialText.charAt(initialTextIndex));
	            initialTextIndex++;
	        }
	    }

	    while (!undoStack.isEmpty()) {
	        result.append(undoStack.pop());
	    }
	  
	    return result.toString();
	    
	}
}
