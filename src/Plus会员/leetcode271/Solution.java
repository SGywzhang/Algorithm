package Plus会员.leetcode271;

import java.util.*;

/**
 * 编码与解码字符串
 */
public class Solution {
    /**
     * 编码字符串列表为单个字符串
     * 格式：长度 + '#' + 字符串内容
     * @param strs 字符串列表
     * @return 编码后的字符串
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }
    
    /**
     * 解码字符串为字符串列表
     * @param s 编码后的字符串
     * @return 原始字符串列表
     */
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++; // 找到长度结束位置
            int len = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> strs = Arrays.asList("lint", "code", "love", "you");
        String encoded = sol.encode(strs);
        List<String> decoded = sol.decode(encoded);
        System.out.println("原始: " + strs);
        System.out.println("编码: " + encoded);
        System.out.println("解码: " + decoded);
        System.out.println("是否相等: " + strs.equals(decoded));
    }
} 