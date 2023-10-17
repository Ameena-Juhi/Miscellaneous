import java.util.*;
public class collatz {
	public static List<Integer> collatzConj(Integer n){
		List<Integer> list= new ArrayList<Integer>();
		
		while(n>4) {
		
		if (n%2==0) {
			list.add(n);
			n/=2;	
		}
		else {
			list.add(n);
			n=(n*3)+1;
		}
		
		}
		
		if (n==4) {
			list.add(n);
			list.add(n/2);
			list.add(n/4);
		}
		
		return list;
	}
	public static void main(String [] args) {
		int num=23;
		System.out.println(collatzConj(num));
		System.out.println(collatzConj(4));
		System.out.println(collatzConj(2));
	}

}
 