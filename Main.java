import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            System.out.println("Please enter Search");
            String answerGave = scnr.next();
            String matchedAnswer = toSearch(answerGave);
        } catch (IllegalArgumentException AIE) {
            System.out.println(AIE);
            System.out.println("Failed");
        }
        BMWInventory car1 = new BMWInventory("BMW", "X1", "RED", 2020, 1500);

        try {
            System.out.println(car1);
        } catch (IllegalArgumentException AIE) {
            System.out.println(AIE);
            System.out.println("Failed");
        }

    }
   

    

}
