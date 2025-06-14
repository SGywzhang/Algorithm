package Plus会员.leetcode302;

/**
 * 包含全部黑色像素的最小矩形
 */
public class Solution {
    /**
     * 找到包含所有黑色像素的最小矩形面积
     * @param image 二维图像矩阵
     * @param x 已知黑色像素的行坐标
     * @param y 已知黑色像素的列坐标
     * @return 最小矩形面积
     */
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    
    /**
     * 二分搜索列边界
     */
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') k++;
            if (k < bottom == whiteToBlack) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    
    /**
     * 二分搜索行边界
     */
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') k++;
            if (k < right == whiteToBlack) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] image = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        System.out.println(sol.minArea(image, 0, 2)); // 6
    }
} 