# 回溯(深度搜索)

回溯就是有规律的遍历，改变状态，然后再该回来状态(回溯)

**模版** 参数：原始参数（题目必备的参数）、start（开始位置）， cur（当前答案）, ans（保存的所有答案）

Java中注意如果将当前答案添加到最终ans list时，要new一个新的对象

```java
public class Solution {
    // 参数注意浅拷贝和深拷贝
    private int[] visit = new int[10];
    // 返回可以是boolean，原本只是尝试走多条不同的路，现在走的路会影响之前节点的选择
    public void dfs(int row, int col, int count) {
        // 判断越界等情况进行剪枝
        if (row < 0 || col < 0) {
            return ;
        }

        // 找到符合条件的结束这个路线的搜索
        if (count == 4) {
            
        }

        for(int i = 0; i < 4; ++i) {
            if (valid()) {
                // 修改状态说明这个点搜索过了
                visit[i] = 1;
                // 向不同方向深度搜索
                dfs(row, col + 1, count + 1);
                // 变回原来的状态，要换一条路走得先从原来的路返回到起点
                visit[i] = 0;
            }
        }
    }   
    
    public boolean valid() {
        return true;
    }   

}
```