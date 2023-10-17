import java.util.*;

public class TestingWordle {

	public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Wordle game1 = new Wordle();

 for(int turn = 0; turn < 20; turn++){
	 
	 		System.out.println("Computer's guess: " + game1.guessWord());
            System.out.println(game1.getSize());
            List<Integer> greenList = new ArrayList<Integer>();
            List<Integer> yellowList = new ArrayList<Integer>();
            System.out.print("Enter the matched positions(GREEN): ");
            String[] greenString = sc.nextLine().split(" ");
            for(int i = 0; i < greenString.length; i++){
                greenList.add(Integer.valueOf(greenString[i]));

            }

            System.out.print("Enter the matched letters positions(YELLOW): ");
            String[] yellowString = sc.nextLine().split(" ");
            for(int i = 0; i < yellowString.length; i++){

                yellowList.add(Integer.valueOf(yellowString[i]));

            }

            if(greenList.size() == 5){

                System.out.println("Computer has successfully guessed your word!");
                break;

            }

            game1.shortlistWords(greenList, yellowList);

        }

    }

}