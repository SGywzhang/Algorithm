package Plus会员.leetcode10;

public class Solution {
    /**
     * 判断字符串s是否与正则表达式p完全匹配
     * 支持'.'匹配任意单字符，'*'匹配零个或多个前一个字符
     * @param s 输入字符串
     * @param p 正则表达式
     * @return 是否完全匹配
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j]表示s的前i个字符与p的前j个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // 空串和空模式匹配
        // 初始化：p以'*'结尾时，可能匹配空串
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        // 动态规划填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // 当前字符匹配，继承前一状态
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*'可以看作0次（跳过前一个字符和'*'）
                    dp[i][j] = dp[i][j - 2];
                    // 或者前一个字符能匹配当前s字符，则可以多用一次
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 典型用例测试
        System.out.println(sol.isMatch("aa", "a")); // false
        System.out.println(sol.isMatch("aa", "a*")); // true
        System.out.println(sol.isMatch("ab", ".*")); // true
        System.out.println(sol.isMatch("aab", "c*a*b")); // true
        System.out.println(sol.isMatch("mississippi", "mis*is*p*.")); // false
    }
} 