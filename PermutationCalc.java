package Java.PermutationMain;

import java.util.*;

public class PermutationCalc {

    public long fctrl(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void perGen(char[] arr, int start, int end, List<String> results) {
        if (start == end) {
            results.add(String.valueOf(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                perGen(arr, start + 1, end, results);
                swap(arr, start, i);
            }
        }
    }

    public List<String> getLnrPer(String input) {
        char[] elements = input.toCharArray();
        List<String> results = new ArrayList<>();
        perGen(elements, 0, elements.length - 1, results);
        return results;
    }

    public List<String> getCrclrPer(String input) {
        if (input.length() <= 1) return Collections.singletonList(input);
        char[] elements = input.toCharArray();
        List<String> results = new ArrayList<>();
        char fixed = elements[0];
        char[] remaining = Arrays.copyOfRange(elements, 1, elements.length);
        List<String> perms = new ArrayList<>();
        perGen(remaining, 0, remaining.length - 1, perms);
        for (String p : perms) {
            results.add(fixed + p);
        }
        return results;
    }

    public long getLnrCnt(int n) { return fctrl(n); }
    public long getCrclrCnt(int n) { return (n <= 1) ? 1 : fctrl(n - 1); }

    public void showSmpSpace(List<String> list, int columns) {
        int count = 0;
        for (String s : list) {
            System.out.printf("%-10s", s);
            count++;
            if (count % columns == 0) System.out.println();
        }
        if (count % columns != 0) System.out.println();
    }
}
