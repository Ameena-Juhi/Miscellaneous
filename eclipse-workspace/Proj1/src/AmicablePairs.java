import java.util.*;
public class AmicablePairs {
	public static int Amicable(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int sum=0;
		for (int i=1;i<n;i++) {
			if(n%i==0) {
				list.add(i);
				System.out.println(i);
			}
			
		}
		for (int each : list) {
			sum+=each;
		}
		return (sum);
	}

	public static Map<Integer,List<Integer>> areAmicablePairs(List<Integer> numList){

		Map<Integer,List<Integer>> amicablePairsMap = new HashMap<>();
		for (int num : numList){
			int newNum = Amicable(num);
			if(!amicablePairsMap.containsKey(newNum)){
				amicablePairsMap.put(num, new ArrayList<Integer>());
			}
			else{
				amicablePairsMap.get(newNum).add(num);
			}
			System.out.println(amicablePairsMap);
		}
		return amicablePairsMap;
	}
	public static void main(String[] args) {
		int num=36;
		System.out.println("36 is "+Amicable(55));
		System.out.println(Amicable(284));
		List<Integer> list = new ArrayList<Integer>();
		list = List.of(21,220,284,36,55);
		System.out.println(areAmicablePairs(list));
	}

}
