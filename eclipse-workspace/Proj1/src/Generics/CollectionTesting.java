package Generics;

public class CollectionTesting {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Amelia", 27);
        Pair<String, Integer> pair2 = new Pair<>("Jack", 49);
        Pair<String, Integer> pair3 = new Pair<>("Cera", 31);

        TupleCollection<Pair<String, Integer>> collection = new TupleCollection<>(3);
        collection.add(pair1);
        collection.add(pair2);
        collection.add(pair3);

        for (Pair<String, Integer> pair : collection) {
            System.out.println(pair.getFirst() + " - " + pair.getSecond());
        }
    }
}
