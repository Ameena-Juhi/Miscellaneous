package Generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static String processCommands(String initialText, String commandFile) {
        List<Character> text = new ArrayList<>();
        List<Character> undoStack = new ArrayList<>();
        int undoCount = 0;

        AppendCommand appendCommand = new AppendCommand();
        BackSpace backspaceCommand = new BackSpace();
        UndoCommand undoCommand = new UndoCommand();

        text.addAll(initialText.chars().mapToObj(c -> (char) c).toList());

        try (BufferedReader reader = new BufferedReader(new FileReader(commandFile))) {
            String line = reader.readLine();
            boolean shouldIgnore = false;

            for (int i = 0; i < line.length(); i++) {
                char command = line.charAt(i);

                if (shouldIgnore) {
                    if (command == '>') {
                        shouldIgnore = false;
                    }
                    continue; 
                }

                if (command == '<') {
                    if (i + 1 < line.length()) {
                        char nextCommand = line.charAt(i + 1);
                        if (nextCommand == 'u') {
                            i+=5; 
                            if (undoCount > 0 && !undoStack.isEmpty()) {
                                text = undoCommand.execute(text, undoStack);
                                undoCount--;
                            } 
                        } else if (nextCommand == 'b') {
                            i+=5;
                            if (!text.isEmpty()) {
                                undoStack.add(text.remove(text.size() - 1));
                            }
                        } else {
                            shouldIgnore = true; 
                        }
                    } else {
                        shouldIgnore = true; 
                    }
                } else {
                    if (undoCount > 0) {
                        undoStack.clear();
                        undoCount = 0;
                    }
                    text = appendCommand.execute(text, command);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder result = new StringBuilder();
        for (Character c : text) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String initialTextFile = "InputFile.txt";
        String commandFile = "command.txt";

        StringBuilder initialText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(initialTextFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                initialText.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String finalState = processCommands(initialText.toString(), commandFile);
        System.out.println(finalState);
    }
}

