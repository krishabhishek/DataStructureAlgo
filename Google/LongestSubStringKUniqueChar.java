package Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Nitin Gupta(nitin.gupta@walmart.com)
 * Date: 2019-06-30
 * Description:https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 * <p>
 * Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
 * Examples:
 * <p>
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * <p>
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * <p>
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * <p>
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 * Source: Google Interview Question.
 */
public class LongestSubStringKUniqueChar {

    public static void main(String args[]) {

        System.out.println(longestSubStringKUniqueChar("aabbcc", 3));

        System.out.println(longestSubStringKUniqueChar("aabbcc", 2));

        System.out.println(longestSubStringKUniqueChar("aabbcc", 1));

        System.out.println(longestSubStringKUniqueChar("aabbcccccc", 1));

        System.out.println(longestSubStringKUniqueChar("aabacbebebe", 3));

        System.out.println(longestSubStringKUniqueChar("aaabbb", 3));
    }

    /**
     * time/space = O(n)/O(1)
     * @param string
     * @param k
     * @return
     */
    public static String longestSubStringKUniqueChar(String string, int k) {

        String subStr = "";
        if (null == string || string.isEmpty() || k == 0)
            return subStr;

        string = string.trim();
        char str[] = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int totalUnique = 0, countOfUnique = 0;
        int start = 0;

        for (int i = 0; i < str.length; i++) {


            if (!map.containsKey(str[i])) {
                countOfUnique++;
                totalUnique++;
                map.put(str[i], 1);
            } else
                map.put(str[i], map.getOrDefault(str[i], 0) + 1);

            if (countOfUnique == k) {

                if (subStr.length() < (i - start + 1)) {
                    subStr = string.substring(start, i + 1);
                }
            } else if (countOfUnique > k) {

                while (countOfUnique > k) {

                    char c = str[start];

                    if (map.get(c) > 0) {
                        map.put(c, map.getOrDefault(c, 1) - 1);

                        if (map.get(c) == 0)
                            countOfUnique--;

                    }
                    start++;
                }
            }

        }

        if (totalUnique < k)
            throw new IllegalArgumentException("input has less unique char then require");
        return subStr;

    }


}
