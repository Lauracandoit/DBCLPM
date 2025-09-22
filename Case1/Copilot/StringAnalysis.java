import java.util.*;

public class StringAnalysis {

    public static String longestUniqueSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int start = 0, maxLen = 0;
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.containsKey(c) && seen.get(c) >= start) {
                start = seen.get(c) + 1;
            }
            seen.put(c, i);
            if (i - start + 1 > maxLen) {
                maxLen = i - start + 1;
                longest = s.substring(start, i + 1);
            }
        }
        return longest;
    }

    public static int wordCount(String s) {
        return s.trim().split("\\s+").length;
    }

    public static String replaceSubstring(String s, String oldStr, String newStr) {
        return s.replace(oldStr, newStr);
    }

    public static void main(String[] args) {
        String text = "hello world, welcome to the world of Java";
        System.out.println("🔹 Chuỗi con dài nhất không lặp: " + longestUniqueSubstring(text));
        System.out.println("🔹 Số từ: " + wordCount(text));
        System.out.println("🔹 Chuỗi sau khi thay thế: " + replaceSubstring(text, "world", "universe"));
    }
}

