package practice;

public class TrumpCard {

	public String name;
	public int height;
	public int weight;
	public int length;
	public int ferocity;
	public int intelligence;
	
//	public enum Category {
//		HEIGHT,
//		WEIGHT,
//		LENGTH,
//		FEROCITY,
//		INTELLIGENCE
//	}
	
	public int trumps(TrumpCard other,String category) {
		
		switch (category) {
		case ("height"): {
			return Integer.compare(this.height, other.height);
		}
		case ("weight"): {
			return Integer.compare(this.weight, other.weight);
		}
		case ("length"): {
			return Integer.compare(this.length, other.length);
		}
		case ("ferocity"): {
			return Integer.compare(this.ferocity, other.ferocity);
		}
		case ("intelligence"): {
			return Integer.compare(this.intelligence, other.intelligence);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + category);
		}
		
	}
}
