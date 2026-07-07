import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    private final String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.isEmpty())
            return result;

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder sb,
                           List<String> result) {

        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            sb.append(c);

            backtrack(digits, index + 1, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
