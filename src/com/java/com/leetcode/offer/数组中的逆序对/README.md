[剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)
---
# 合并排序

* 通过合并排序过程中合并过程计算逆序对
* 例如数组[3,1,4,2]在合并排序过程中产生下面两个数组
    * [1,3]
    * [2,4]
* 这两个数组合并每次取两边最小的那个-> [1,2,3,4]
* 而在合并过程中我们发现3>2，那么这个就是一个逆序对