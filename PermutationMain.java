package Java.PermutationMain;
import java.util.*;

public class PermutationMain {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PermutationCalc calc = new PermutationCalc();
            int choice;

            do {
                System.out.print("""
                
                PERMUTATION MENU
                1) Linear Permutations Sample Space
                2) Circular Permutations Sample Space
                3) Linear and Circular Permutations Calculator
                4) Exit

                """);

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 ->  {
                        System.out.print("\nEnter a string (EX: abc, 123): ");
                        String str = sc.nextLine();
                        List<String> linearPerms = calc.getLnrPer(str);
                        System.out.println("\nLinear Permutations:\n");
                        calc.showSmpSpace(linearPerms, 5);
                        System.out.println("\nTotal: " + calc.getLnrCnt(str.length()));
                    }

                    case 2 ->  {
                        System.out.print("\nEnter a string (e.g., ABC): ");
                        String str = sc.nextLine();
                        List<String> circularPerms = calc.getCrclrPer(str);
                        System.out.println("\nCircular Permutations:\n");
                        calc.showSmpSpace(circularPerms, 5);
                        System.out.println("\nTotal: " + calc.getCrclrCnt(str.length()));
                    }

                    case 3 ->  {
                        System.out.print("\nEnter number of elements (n): ");
                        int n = sc.nextInt();
                        System.out.println("\nTotal Linear Permutations (n!) = " + calc.getLnrCnt(n));
                        System.out.println("Total Circular Permutations ((n - 1)!) = " + calc.getCrclrCnt(n));
                    }

                    case 4 ->  { System.out.println("\nExiting...");
                    }

                    default -> System.out.println("\nInvalid choice! Please try again.");
                }
            } while (choice != 4);
        }
    }
}
