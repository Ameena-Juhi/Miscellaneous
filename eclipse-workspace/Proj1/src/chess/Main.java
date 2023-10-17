package chess;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		ChessBoard c = new ChessBoard();
		System.out.println(c);
		
		Path p = Paths.get("pgn1.txt");
		List<String> lines = Files.readAllLines(p);
		int moveNumber = 1;
		
		for(String line: lines) {
			System.out.println("Move Number: " + moveNumber);
			moveNumber++;
			String[] moves = line.split(" ");
			c.executeMove("white", moves[0]);
			c.executeMove("black", moves[1]);
			System.out.println(c);
		}
	}
}
