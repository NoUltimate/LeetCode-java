[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

*首先，要想找以第i根柱子为最矮柱子所能延伸的最大面积*

是以`i` 为中心，向左找第一个小于 `heights[i]` 的位置 `left_i`；向右找第一个小于于 `heights[i]` 的位置 `right_i`，即最大面积为 `heights[i] * (right_i - left_i -1)`，如下图所示：

![https://pic.leetcode-cn.com/441ac778821dc26689b31466bced9f61ec241f092bf7e4f0f8699ef4fa3be1b2-1559826097853.png](https://pic.leetcode-cn.com/441ac778821dc26689b31466bced9f61ec241f092bf7e4f0f8699ef4fa3be1b2-1559826097853.png)

所以，我们的问题就变成如何找 right_i 和 left_i？

* 思路一：
当我们找 i 左边第一个小于 heights[i] 如果 heights[i-1] >= heights[i] 其实就是和 heights[i-1] 左边第一个小于 heights[i-1] 一样。依次类推，右边同理。

* 思路二：栈
利用单调栈维护一个单调递增的栈，就可以找到 left_i 和 right_i。
