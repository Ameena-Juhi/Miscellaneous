package yahtzee;

public class Die {

    public static final int MAX =6;
    private int faceValue;


    public Die(){
        faceValue = 1;
    }

    public int DieRoll() {
        faceValue = (int) (Math.random() * MAX) + 1;
        return faceValue;
    }
    public String toString() {
        String result = Integer.toString(faceValue);
        return result;
    }
}