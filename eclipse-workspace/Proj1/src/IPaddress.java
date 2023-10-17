
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class IPaddress {
	
    private List<String> possibleAddresses = new ArrayList<String>();
   // public String[] Parts = getIPAdd().split(".");

    public IPaddress(){
        try {
            File Obj = new File("addresses.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String IpAdd = Reader.nextLine();
                possibleAddresses.add(IpAdd);
            }
            System.out.println(possibleAddresses);
            Reader.close();
        }

        catch (FileNotFoundException e) {
        	
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    
  //123.24.92.106
  //A=123; B=24; C=92; D=106
  // check valid
    
    public int getIPAdd() {
    	
    	return possibleAddresses.size();
    }
    
//    public List<String> ABCD() {
//    	List<String> ABCD = new ArrayList<String>();
//    	
//    }
    }
