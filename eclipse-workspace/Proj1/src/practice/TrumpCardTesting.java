package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TrumpCardTesting {
	
	public static void main(String[] args) {
		
		List<String> data = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Path path = Paths.get("DinoCards.txt");
		try {
			data = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random random = new Random();
		int randomIndex = random.nextInt(data.size());
		String randomLine = data.get(randomIndex);
		String[] parts = randomLine.split(" ");
		
		int otherRandomIndex = random.nextInt(data.size());
		String otherRandomLine =data.get(otherRandomIndex);
		String[] Otherparts = otherRandomLine.split(" ");
		
		System.out.println("Your Card: ");
		System.out.println(randomLine);
		System.out.println("Opponents Card: ");
		System.out.println(otherRandomLine);
		TrumpCard mycard = new TrumpCard();
		mycard.name=parts[0];
		mycard.height=Integer.parseInt(parts[1]);
		mycard.weight=Integer.parseInt(parts[2]);
		mycard.length=Integer.parseInt(parts[3]);
		mycard.ferocity=Integer.parseInt(parts[4]);
		mycard.intelligence=Integer.parseInt(parts[5]);
		
		TrumpCard otherCard = new TrumpCard();
		otherCard.name=Otherparts[0];
		otherCard.height=Integer.parseInt(Otherparts[1]);
		otherCard.weight=Integer.parseInt(Otherparts[2]);
		otherCard.length=Integer.parseInt(Otherparts[3]);
		otherCard.ferocity=Integer.parseInt(Otherparts[4]);
		otherCard.intelligence=Integer.parseInt(Otherparts[5]);
		
		System.out.println("Enter the trump category : ");
		String category = sc.nextLine();
		int val = mycard.trumps(otherCard, category);
		if(val > 0) {
			System.out.println(mycard.name + " trumps this game!");
		}
		else if(val<0) {
			System.out.println(otherCard.name + " trumps this game!");
		}
		else
			System.out.println("Both are equal in this game!");

	}

}
