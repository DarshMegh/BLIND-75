// ValidAnagram.java

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();

        boolean result = obj.isAnagram(
                "listen",
                "silent"
        );

        System.out.println(result);
    }
}
