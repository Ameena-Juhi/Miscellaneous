package Generics;

import java.util.List;

public class AppendCommand {
    public List<Character> execute(List<Character> text, char charToAppend) {
        text.add(charToAppend);
        return text;
    }
}
