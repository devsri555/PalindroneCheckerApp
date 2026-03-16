interface PalindromeStrategy {
    boolean isPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String word) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return word.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String word) {
        java.util.Deque<Character> deque = new java.util.LinkedList<>();

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
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        PalindromeStrategy strategy;

        // choose strategy dynamically
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        if (strategy.isPalindrome(word)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}
