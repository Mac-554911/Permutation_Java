package Java.PermutationMain;

import java.util.*;

public class PermutationMain {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PermutationCalc calc = new PermutationCalc();

            //Create String
            System.out.print("Enter the string of elements (EX: 123, abc): ");
            String str = sc.nextLine();
            int n = str.length();

            // Linear and Circular Count
            long lnrCnt = calc.getLnrCnt(n);
            long crclrCnt = calc.getCrclrCnt(n);

            System.out.println(String.format("""
                
                Number of Students (n): %d
                Linear Arrangements: %d
                Circular Arrangements: %d
                """, n, lnrCnt, crclrCnt));



             // First 10 Linear Permutations
            List<String> lnrPer = calc.getLnrPer(str);
            System.out.println("First 10 Linear Permutations:");
            calc.showSmpSpace(lnrPer.subList(0, Math.min(10, lnrPer.size())), 5);
        }
    }
}
