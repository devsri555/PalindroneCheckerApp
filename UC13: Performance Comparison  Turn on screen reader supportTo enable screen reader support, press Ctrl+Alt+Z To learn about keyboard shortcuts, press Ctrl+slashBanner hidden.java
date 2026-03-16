import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    // Method 1: String Reverse using loop
    public static boolean reverseMethod(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return word.equals(reversed);
    }

    // Method 2: Stack based
    public static boolean stackMethod(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque based
    public static boolean dequeMethod(String word) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String word = "madam";

        long start1 = System.nanoTime();
        boolean result1 = reverseMethod(word);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = stackMethod(word);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = dequeMethod(word);
        long end3 = System.nanoTime();

        System.out.println("Reverse Method Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Method Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");
    }
}
