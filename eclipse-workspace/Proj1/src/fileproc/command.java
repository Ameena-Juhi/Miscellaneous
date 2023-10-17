package fileproc;

import java.util.List;

interface Command {
    List<Character> execute(List<Character> text, List<Character> stack);

	List<Character> execute(List<Character> text, List<Character> stack, char charToAppend);
}

abstract class AppendCommand implements Command {
    @Override
    public List<Character> execute(List<Character> text, List<Character> stack, char charToAppend) {
        text.add(charToAppend);
        return text;
    }
}

abstract class BackSpace implements Command {
    @Override
    public List<Character> execute(List<Character> text, List<Character> stack) {
        if (!text.isEmpty()) {
            char removedChar = text.remove(text.size() - 1);
            stack.add(removedChar);
        }
        return text;
    }
}

abstract class UndoCommand implements Command {
    @Override
    public List<Character> execute(List<Character> text, List<Character> stack) {
        if (!stack.isEmpty()) {
            char removedChar = stack.remove(stack.size() - 1);
            text.add(removedChar);
        } else {
            System.out.println("Stack is empty, cannot perform undo operation");
        }
        return text;
    }
}

