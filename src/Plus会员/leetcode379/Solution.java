package Plus会员.leetcode379;

import java.util.*;

public class Solution {
    class PhoneDirectory {
        Set<Integer> used;
        Queue<Integer> available;
        int maxNumbers;
        public PhoneDirectory(int maxNumbers) {
            used = new HashSet<>();
            available = new LinkedList<>();
            this.maxNumbers = maxNumbers;
            for(int i = 0; i < maxNumbers; i++){
                available.offer(i);
            }
        }

        public int get() {
            if(available.isEmpty()){
                return -1;
            }
            int number = available.poll();
            used.add(number);
            return number;
        }

        public boolean check(int number) {
            return !this.used.contains(number);
        }

        public void release(int number) {
            if(used.remove(number)){
                available.offer(number);
            }
        }
    }

    public static void main(String[] args) {
        PhoneDirectory directory = new Solution().new PhoneDirectory(3);
        System.out.println(directory.get());    // 0
        System.out.println(directory.get());    // 1
        System.out.println(directory.check(2)); // true
        System.out.println(directory.get());    // 2
        System.out.println(directory.check(2)); // false
        directory.release(2);
        System.out.println(directory.check(2)); // true
    }
}
