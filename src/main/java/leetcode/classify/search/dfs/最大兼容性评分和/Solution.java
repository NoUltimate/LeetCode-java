package leetcode.classify.search.dfs.最大兼容性评分和;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月31日 16:17
 */

public class Solution {
    int max = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        dfs(students, mentors, new boolean[students.length], 0, 0);
        return max;
    }

    public void dfs(int[][] students, int[][] mentors, boolean[] visit,  int count, int sum) {
        if (count == mentors.length) {
            max = Math.max(max, sum);
            return ;
        }
        for(int i = 0; i < mentors.length; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(students, mentors, visit, count + 1, sum + get(students[count], mentors[i]));
            visit[i] = false;
        }
    }

    public int get(int[] student, int[] mentor) {
        int count = 0;
        for(int i = 0; i < student.length; ++i) {
            if (student[i] == mentor[i]) count++;
        }
        return count;
    }
}
