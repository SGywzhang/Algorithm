package Plus会员.leetcode158;

public class Solution {
    private String file; // 文件内容
    private int filePointer = 0; // 当前读取指针
    private char[] buffer = new char[4]; // 上次多读的缓存
    private int bufPtr = 0, bufCnt = 0; // 缓存指针和计数
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
     * 支持多次调用的read，每次读取n个字符到buf
     * @param buf 目标缓冲区
     * @param n 需要读取的字符数
     * @return 实际读取的字符数
     */
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (bufPtr == bufCnt) { // 缓存已用完，重新读4个
                bufCnt = read4(buffer);
                bufPtr = 0;
                if (bufCnt == 0) break; // 文件已读完
            }
            while (total < n && bufPtr < bufCnt) {
                buf[total++] = buffer[bufPtr++];
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Solution sol = new Solution("abcde");
        char[] buf = new char[10];
        // 第一次读取2个字符
        int n1 = sol.read(buf, 2);
        System.out.println("Read chars: " + n1 + ", Content: " + new String(buf, 0, n1)); // ab
        // 第二次读取3个字符
        int n2 = sol.read(buf, 3);
        System.out.println("Read chars: " + n2 + ", Content: " + new String(buf, 0, n2)); // cde
    }
} 