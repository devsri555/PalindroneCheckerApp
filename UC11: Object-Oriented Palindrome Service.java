class PalindromeChecker {

    public boolean checkPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(word)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}
