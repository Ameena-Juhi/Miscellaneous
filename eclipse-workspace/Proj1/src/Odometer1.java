
public class Odometer1 {
	public int reading;
	public int size;
	
	public Odometer1(int size) {
		if (size<1 || size>9) {
			System.out.println("Invalid size!");
			return;
		}
		
		for(int i = 1 ;i <= size ; i++)
		{
			reading=reading*10;
			reading+=i;
		}
		this.size = size ;
	}
	
	public void getSize() {
		
	}
	
	public Odometer1 copy() {}
	
	

}
