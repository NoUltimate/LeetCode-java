[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
# 状态变化
* 持股 -> 冷冻期
* 冷冻期 -> 不持股 不持股 -> 不持股
* 不持股 -> 持股 持股 -> 持股

#### 第一步：状态定义

`dp[i][j]` 表示 `[0, i]` 区间内，在下标为 `i` 这一天状态为 `j` 时的最大收益。

这里 `j` 取三个值：

- `0` 表示不持股；
- `1` 表示持股；
- `2` 表示处在冷冻期。

#### [](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/#%E7%AC%AC%E4%BA%8C%E6%AD%A5%EF%BC%9A%E7%8A%B6%E6%80%81%E8%BD%AC%E7%A7%BB%E6%96%B9%E7%A8%8B)第二步：状态转移方程

- 不持股可以由这两个状态转换而来：
    - 昨天不持股，今天什么都不操作，仍然不持股；
    - 昨天持股，今天卖了一股。
- 持股可以由这两个状态转换而来：
    - 昨天持股，今天什么都不操作，仍然持股；
    - 昨天处在冷冻期，今天买了一股；
- 处在冷冻期只可以由不持股转换而来，因为题目中说，刚刚把股票卖了，需要冷冻 1 天。

上面的分析可以用下面这张图表示：
![https://pic.leetcode-cn.com/6dba5214e21684d0383521aaf820b66191106473b9e8a07faaa394e5136b5f47-image.png](https://pic.leetcode-cn.com/6dba5214e21684d0383521aaf820b66191106473b9e8a07faaa394e5136b5f47-image.png)

与之前股票问题的不同之处只在于：**从不持股状态不能直接到持股状态，得经过一个冷冻期，才能到持股状态**。

#### [](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/#%E7%AC%AC%E4%B8%89%E6%AD%A5%EF%BC%9A%E6%80%9D%E8%80%83%E5%88%9D%E5%A7%8B%E5%8C%96)第三步：思考初始化

在第 0 天，不持股的初始化值为 `0`，持股的初始化值为 `-prices[0]`（表示购买了一股），虽然不处于冷冻期，但是初始化的值可以为 `0`。

#### [](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/#%E7%AC%AC%E5%9B%9B%E6%AD%A5%EF%BC%9A%E6%80%9D%E8%80%83%E8%BE%93%E5%87%BA)第四步：思考输出

每一天都由前面几天的状态转换而来，最优值在最后一天。取不持股和冷冻期的最大者。

```java
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][3];

        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
```