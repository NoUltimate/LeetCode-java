package leetcode.classify.search.bfs.单词接龙;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunbowen
 * @date 2021年02月04日 09:57
 */

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return 0;
        }
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        boolean[] visit = new boolean[wordList.size()];
        queue.add(beginWord);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                String word = queue.poll();
                for(int j = 0; j < wordList.size(); ++j) {
                    if (visit[j]) {
                        continue;
                    }
                    if (valid(word, wordList.get(j))) {
                        if (wordList.get(j).equals(endWord)) {
                            return depth + 1;
                        }
                        visit[j] = true;
                        queue.add(wordList.get(j));
                    }
                }
            }
        }
        return 0;
    }

    public boolean valid(String word, String targetWord) {
        int count = 0;
        for(int i = 0; i < targetWord.length(); ++i) {
            if (word.charAt(i) != targetWord.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
