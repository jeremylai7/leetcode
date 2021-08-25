# leetcode 刷题with Java

很多网上的算法都是一个题目一个题目讲解，本项目按照文件名称可以查看没一个题目的解法，但是算法主要是掌握一类解法。所以就总结了一些分类。

* [回溯](#回溯)
    * 39 组合总和
    * 40 组合总和 II
    * 46 全排列 


### 回溯
> 概念: 回溯是暴力搜索法的一种，
1. 枚举出所有解，找打符合条件的解。
2. 把问题分解的过程分多个阶段，每个阶段都会面临一个分叉路，先走一条路。
3. 路走完了，或者路不符合期望条件时，就回退到上一个分叉路，找另外没有走过的路。
4. 回溯实现一般都是用递归。



