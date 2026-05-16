// GroupAnagrams.java

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] chars = s.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagrams obj = new GroupAnagrams();

        String[] input = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        List<List<String>> result =
                obj.groupAnagrams(input);

        System.out.println(result);
    }
}
