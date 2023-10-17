package Generics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessorTesting {

	public static void main(String[] args) {

		try {
			Path input = Paths.get("InputFile.txt");
			String initialText = Files.readString(input);
			Path Command = Paths.get("CommandFile.txt");
            String commandText = Files.readString(Command);
            String finalText = FileProcessor.processCommands(initialText, commandText);
            StringBuilder output = new StringBuilder(finalText).reverse();
            System.out.println(output.toString());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

	}

}
