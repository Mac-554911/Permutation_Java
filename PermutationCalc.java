package Java.PermutationMain;

import java.util.*;

public class PermutationCalc {

    // Factorial
    public long fctrl(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i; // start from 2 (1*1 unnecessary)
        return fact;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Permutation Generator
    private void perGnrtr(char[] arr, int start, int end, List<String> results) {
        if (start == end) {
            results.add(new String(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                perGnrtr(arr, start + 1, end, results);
                swap(arr, start, i); // backtrack
            }
        }
    }

    // Linear
    public List<String> getLnrPer(String input) {
        List<String> results = new ArrayList<>();
        perGnrtr(input.toCharArray(), 0, input.length() - 1, results);
        return results;
    }

    // Circular
    public List<String> getCrclrPer(String input) {
        if (input.length() <= 1) return Collections.singletonList(input);
        char fixed = input.charAt(0);
        List<String> results = new ArrayList<>();
        List<String> perms = new ArrayList<>();
        perGnrtr(input.substring(1).toCharArray(), 0, input.length() - 2, perms); // length-1 for remaining
        for (String p : perms) results.add(fixed + p);
        return results;
    }

    // Counter
    public long getLnrCnt(int n) { return fctrl(n); }
    public long getCrclrCnt(int n) { return (n <= 1) ? 1 : fctrl(n - 1); }

    // Sample Space
    public void showSmpSpace(List<String> list, int columns) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-10s", list.get(i));
            if ((i + 1) % columns == 0) System.out.println();
        }
        if (list.size() % columns != 0) System.out.println();
    }
}
