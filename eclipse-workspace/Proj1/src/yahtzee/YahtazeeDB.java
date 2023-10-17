package yahtzee;

import java.sql.*;
import java.util.*;

public class YahtazeeDB {

    public List<Integer> dieValue = new ArrayList<>();

    public void roll(int die) {

        Random random = new Random();

        for (int i = 0; i < die; i++) {
        	
            dieValue.add(random.nextInt(6) +1);

        }

        System.out.println(" Rolled Dice Value : " + dieValue);

    }

    public void Upper(int category , int user_id) {

        Connection cnx = null;
        PreparedStatement stmt =null;
        Scanner sc = new Scanner(System.in);

         try {
                int sum = 0;
                for (int die : dieValue) {
                    if (die == category)
                        sum = sum + category;
             }

             String query = "INSERT INTO SCORE (PLAYER_ID, CATEGORY_NAME, SCORE) VALUES ( ?, ?, ?)";
             cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Yahtzee","Ameena","Ameena");
             stmt =cnx.prepareStatement(query);

             //System.out.println("enter player id");

            // int id=sc.nextInt();


             stmt.setInt(1,1);
             stmt.setString(2, "UpperHouse");
             stmt.setInt(3, sum);
             stmt.executeUpdate();
             stmt.close();
             cnx.close();
             System.out.println("Upper House : " + sum);

             } 

         catch (SQLException e) {

                e.printStackTrace();

            }
    }

 

    public void Straight(int sequence,int user_id)
     {

        int sum=0;
            int checkConsq=0;
         int[] freq =new int[10];
         for(int die:dieValue)

         {
             freq[die]++;
         }

        for(int i = 1;i <= 6;i++)

        {
            if(freq[i]!=0 && freq[i]!=2)
                checkConsq++;
            else 
                checkConsq = 0;
        }

        if(checkConsq == sequence)

          sum =30;
         Connection cnx = null;
             PreparedStatement stmt =null;
                try {
                    String query = "INSERT INTO SCORE (PLAYER_ID, CATEGORY_NAME, SCORE) VALUES ( ?, ?, ?)";
                    cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/YaHtzee","Ameena","Ameena");
                    stmt =cnx.prepareStatement(query);
                    stmt.setInt(1,user_id);
                    stmt.setString(2, "Straight");
                    stmt.setInt(3, sum);
                    stmt.executeUpdate();
                    stmt.close();
                    cnx.close();
                 System.out.println("Straight : " + sum);


                    } 

                catch (SQLException e) {

                       e.printStackTrace();

                   }

     }

    public void fullHouse(int user_id) {

        int[] freq = new int[10];
        for (int die : dieValue) {

            freq[die]++;
        }

        boolean containsTwo = false;
        boolean containsThree = false;

            Connection cnx = null;

            PreparedStatement stmt =null;

            Scanner sc = new Scanner(System.in);

            try {

                int sum = 0;

                for(int i=1; i <= 6; i++) {

                    if(freq[i] == 2) {

                        containsTwo = true;

                    }

                    else if(freq[i] == 3) {

                        containsThree = true;

                    }

                    if(containsTwo && containsThree) {

                        sum= 25;


                    }

                }

                String query = "INSERT INTO SCORE (PLAYER_ID, CATEGORY_NAME, SCORE) VALUES ( ?, ?, ?)";

                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Yatzee","Database","atharva");

                stmt =cnx.prepareStatement(query);

                //System.out.println("enter player id");

               // int id = sc.nextInt();

                System.out.println("enter categoryName");
                stmt.setInt(1,user_id);
                stmt.setString(2, "fullHouse");
                stmt.setInt(3, sum);
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
             System.out.println("FUll House : " + sum);
                } 

            catch (SQLException e) {

                   e.printStackTrace();

               }
        }

    public void threeOfAKind(int user_id) {

        int[] freq = new int[10];

 

            int sum = 0;

            for (int dice : dieValue) {

                sum = sum + dice;

            }       

            for (int die : dieValue) {

                freq[die]++;

            }

              for (int i = 1; i <= 6; i++) {

                if (freq[i] == 3) {

                    System.out.println("Three of A Kind"+sum);

                }

            }

        Connection cnx = null;

           PreparedStatement stmt =null;


           try {

               String query = "INSERT INTO SCORE (PLAYER_ID, CATEGORY_NAME, SCORE) VALUES ( ?, ?, ?)";

               cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Yatzee","Database","atharva");

               stmt = cnx.prepareStatement(query);

               stmt.setInt(1,1);

               stmt.setString(2,"threeOfAkind" );

               stmt.setInt(3, sum);

               stmt.executeUpdate();

               stmt.close();

               cnx.close();

            System.out.println("three of a Kind : " + sum);


               } 

           catch (SQLException e) {

                  e.printStackTrace();

              }


    }


    public void fourOfAKind(int user_id) {

        Connection cnx = null;

          PreparedStatement stmt =null;


          try {
             int Sum = 0;

             for (int dice : dieValue) {

                 Sum = Sum + dice;

             }

             int[] freq = new int[10];

             for (int die : dieValue) {

                 freq[die]++;

             }

             for (int i = 1; i <= 6; i++) {

                 if (freq[i] == 4) {

                     System.out.println("Four of A Kind"+Sum);                   

                 }

             }

              String query = "INSERT INTO SCORE (PLAYER_ID, CATEGORY_NAME, SCORE) VALUES ( ?, ?, ?)";
              cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Yatzee","Database","atharva");
              stmt =cnx.prepareStatement(query);
              stmt.setInt(1,user_id);
              stmt.setString(2," fourOfAkind" );
              stmt.setInt(3, Sum);
              stmt.executeUpdate();
              stmt.close();
              cnx.close();
              } 

          catch (SQLException e) {

                 e.printStackTrace();

             }

    }


    public static void main(String[] args) {
        YahtazeeDB game = new YahtazeeDB();

        System.out.println("enter user id:");

      int user_id;

        Scanner sc = new Scanner(System.in);        

        user_id = sc.nextInt();

        game.roll(5);


        System.out.println("Choose category:");
        System.out.println("1 - Upper House");
        System.out.println("2 - Full House");
        System.out.println("3 - Three of A Kind");
        System.out.println("4 - Four of A Kind");
        System.out.println("5 - Straight of A Kind");
        for(int i=0;i<13;i++) {
        int categoryChoice;
        System.out.print("Enter category: ");
        categoryChoice = sc.nextInt();
        switch (categoryChoice) {

            case 1:
                System.out.print("Enter Round  Name in upper Category: ");
                int n = sc.nextInt();
                game.Upper(n,user_id);
                break;
            case 2:
                 game.fullHouse(user_id);
                break;
            case 3:
                game.threeOfAKind(user_id);
                break;
            case 4:
                 game.fourOfAKind(user_id);
                break;
            case 5:
                int num;
                System.out.println("Enter the sequence number either 4 or 5");
                num = sc . nextInt();
                game.Straight(num, user_id);
                break;
            default:
                System.out.println("Invalid category choice.");

        }


        }
    }

}