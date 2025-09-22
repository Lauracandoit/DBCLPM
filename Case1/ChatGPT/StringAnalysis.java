package ChatGPT;
public class StringAnalysis {

    // Tìm chuỗi con dài nhất lặp lại
    public static String longestRepeatedSubstring(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (sub.length() > longest.length() && countOccurrences(s, sub) > 1) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    // Đếm số lần xuất hiện của substring
    private static int countOccurrences(String s, String sub) {
        int count = 0, index = 0;
        while ((index = s.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    // Đếm số từ
    public static int countWords(String s) {
        return s.trim().split("\\s+").length;
    }

    // Thay thế substring
    public static String replaceSubstring(String s, String oldStr, String newStr) {
        return s.replace(oldStr, newStr);
    }

    // Demo
    public static void main(String[] args) {
        String text = "hello world hello java";

        System.out.println("Chuỗi gốc: " + text);
        System.out.println("Số từ: " + countWords(text));
        System.out.println("Chuỗi con dài nhất lặp lại: " + longestRepeatedSubstring(text));
        System.out.println("Thay thế 'hello' -> 'hi': " + replaceSubstring(text, "hello", "hi"));
    }
}
