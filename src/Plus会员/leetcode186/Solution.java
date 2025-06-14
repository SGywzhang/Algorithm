package Plus会员.leetcode186;

public class Solution {
    /**
     * 翻转字符串中的单词顺序，原地修改
     * @param s 字符数组，包含若干单词和空格
     */
    public void reverseWords(char[] s) {
        // 先整体翻转
        reverse(s, 0, s.length - 1);
        int start = 0;
        // 再逐个单词翻转
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
    }
    /**
     * 翻转字符数组s的[l, r]区间
     */
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] s = "the sky is blue".toCharArray();
        sol.reverseWords(s);
        // 输出翻转后的结果
        System.out.println(new String(s)); // blue is sky the
    }
} 