public class DecodeWays {

    public int numDecodings(String s) {

        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int prev = 1;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {

            int temp = 0;

            if (s.charAt(i) != '0')
                temp = curr;

            int two = Integer.parseInt(s.substring(i - 1, i + 1));

            if (two >= 10 && two <= 26)
                temp += prev;

            prev = curr;
            curr = temp;
        }

        return curr;
    }
}