package BFS.leetcode127;

import java.util.*;

class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char originalChar = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        if (endSet.contains(newWord)){
                            return level + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            nextLevelSet.add(newWord);
                        }
                    }
                    charArray[i] = originalChar;
                }
            }
            beginSet = nextLevelSet;
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
