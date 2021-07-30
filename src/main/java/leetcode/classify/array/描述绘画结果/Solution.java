package leetcode.classify.array.描述绘画结果;
/*
 * 1943. 描述绘画结果
 * https://leetcode-cn.com/problems/describe-the-painting/
 * 差分数组
 * @author sunbowen
 * @date 2021年07月29日 14:53
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
