package BFS.leetcode752;

import java.util.*;
class Solution {
    public static int openLock(String[] deadends, String target) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        int level = 0;
        beginSet.add("0000");
        endSet.add(target);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() < endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String cur : beginSet) {
                for (int i = 0; i < 4; i++) {
                    char c = cur.charAt(i);
                    String next1 = cur.substring(0, i) +  (c == '9' ?  0 : c - '0' + 1) + cur.substring(i + 1);
                    String next2 = cur.substring(0, i) +  (c == '0' ?  9 : c - '0' - 1) + cur.substring(i + 1);
                    if (endSet.contains(next1)) return level + 1;
                    if (endSet.contains(next2)) return level + 1;
                    if (!deadSet.contains(next1)) {
                        nextSet.add(next1);
                        deadSet.add(next1); // Add to deadSet
                    }
                    if (!deadSet.contains(next2)) {
                        nextSet.add(next2);
                        deadSet.add(next2); // Add to deadSet
                    }
                }
            }
            level++;
            beginSet = nextSet;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        //System.out.println(openLock(new String[]{"8888"}, "0009"));



    }
}