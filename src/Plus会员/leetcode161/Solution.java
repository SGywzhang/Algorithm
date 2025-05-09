package Plus会员.leetcode161;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if(s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i + 1));
                }
                else{
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Object[][] testCases = {
                {"abc", "adc", true},    // 替换
                {"abc", "abxc", true},    // 插入
                {"abc", "ac", true},      // 删除
                {"abc", "abc", false},    // 完全相同
                {"abc", "a", false},      // 长度差超过1
                {"a", "bb", false},       // 长度差为1但编辑距离>1
                {"abc", "ac1111111", false}, // 长度差>1
                {"", "a", true},          // 空字符串vs单字符
                {"a", "", true},          // 单字符vs空字符串
                {"", "", false}           // 两个空字符串
        };

        for (int i = 0; i < testCases.length; i++) {
            String s = (String) testCases[i][0];
            String t = (String) testCases[i][1];
            boolean expected = (boolean) testCases[i][2];
            boolean result = solution.isOneEditDistance(s, t);
            System.out.printf("Test %d: %-15s %-15s => %-5s (Expected: %-5s)\n",
                    i + 1, "\"" + s + "\"", "\"" + t + "\"", result, expected);
        }
    }
}
