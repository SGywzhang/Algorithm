package Plus会员.leetcode157;

public class Solution {
    private String file; // 文件内容
    private int filePointer = 0; // 当前读取指针
    public Solution(String file) {
        this.file = file;
    }
    /**
     * 模拟read4 API，每次最多读取4个字符到buf4
     * @param buf4 目标缓冲区
     * @return 实际读取的字符数
     */
    public int read4(char[] buf4) {
        int i = 0;
        while (i < 4 && filePointer < file.length()) {
            buf4[i++] = file.charAt(filePointer++);
        }
        return i;
    }
    /**
     * 读取n个字符到buf
     * @param buf 目标缓冲区
     * @param n 需要读取的字符数
     * @return 实际读取的字符数
     */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] buf4 = new char[4];
        while (total < n) {
            int count = read4(buf4);
            if (count == 0) break; // 文件已读完
            for (int i = 0; i < count && total < n; i++) {
                buf[total++] = buf4[i];
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Solution sol = new Solution("abcde");
        char[] buf = new char[10];
        // 第一次读取4个字符
        int n = sol.read(buf, 4);
        System.out.println("Read chars: " + n + ", Content: " + new String(buf, 0, n)); // abcd
        // 第二次再读取2个字符
        n = sol.read(buf, 2);
        System.out.println("Read chars: " + n + ", Content: " + new String(buf, 0, n)); // e
    }
} 