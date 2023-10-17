package test;

public class RangeTest {
    public static void main(String[] args) {
        
        Range<Integer> range1 = Range.of(1, 5);
        Range<Integer> range2 = Range.of(3, 7);
        Range<Integer> range3 = Range.of(8, 10);

        
        System.out.println(range1.contains(3)); 
        System.out.println(range1.contains(6)); 

        
        System.out.println(range1.containsRange(range2)); 
        System.out.println(range2.containsRange(range1));
        System.out.println(range1.containsRange(range3)); 

        
        try {
            Range<Integer> mergedRange = range1.merge(range2);
            System.out.println(mergedRange); 
        } catch (CustomException e) {
            System.out.println("Merge failed: " + e.getMessage());
        }

        
        try {
            Range<Integer> intersectionRange = range1.intersection(range2);
            System.out.println(intersectionRange); 
        } catch (CustomException e) {
            System.out.println("Intersection failed: " + e.getMessage());
        }

        
        System.out.println(range1.fit(0)); 
        System.out.println(range1.fit(4)); 
        System.out.println(range1.fit(7)); 

        
        Range<Integer> range4 = Range.of(1, 5);
        System.out.println(range1.equals(range4)); 

        
        Range<Double> doubleRange = Range.of(0.2, 1.2);
        Range<Double> doubleRange2 = Range.of(2.1, 3.0);

        System.out.println(doubleRange.contains(1.0));
        try {
            System.out.println(doubleRange.merge(doubleRange2));
        } catch (CustomException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(doubleRange.containsRange(doubleRange2));
        System.out.println(doubleRange.fit(1.3));


        Range<Character> charRange = Range.of('a', 'h');
        Range<Character> charRange2 = Range.of('c', 'i');

        System.out.println(charRange.contains('i'));
        System.out.println(charRange.containsRange(charRange2));


    }
}
