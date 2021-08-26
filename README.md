# leetcode 刷题with Java

本项目按照文件名称可以查看没一个题目的解法，具体可以查看[题解](https://github.com/jeremylai7/leetcode/tree/master/src/main/java/com/leetcode),本目录根据解法总一个归纳和总结。

* [回溯](#回溯)
    * [39 组合总和](#组合总和)
    * [40 组合总和 II](#组合总和II)
    * [46 全排列](#全排列)
    * [47 全排列 II](#全排列II)


### 回溯
* 概念: 回溯是暴力搜索法的一种
1. 枚举出所有解，找打符合条件的解。
2. 把问题分解的过程分多个阶段，每个阶段都会面临一个分叉路，先走一条路。
3. 路走完了，或者路不符合期望条件时，就回退到上一个分叉路，找另外没有走过的路。
4. 回溯实现一般都是用**递归**。

* 流程图 
以找出a,b,c所有的组合为例，画出全排列的流程图。

![流程图](https://user-images.githubusercontent.com/11553237/130755983-d80694f1-7a4d-46d8-a67a-a18ba0bc9527.png)

* 回溯算法的基本模板:
```
public Solution {
   List<List<Integer>> result;

   LinkedList<Integer> path;

   private List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums) {
        if (递归终止条件) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
```  
### 回溯例子
#### [组合总和](https://leetcode-cn.com/problems/combination-sum)
##### 题目描述
![image](https://user-images.githubusercontent.com/11553237/130767960-4d920d68-ae7a-46c6-9fd4-9de8d7470c31.png)

##### 解法
画出树形图

![leetcode树形图](https://user-images.githubusercontent.com/11553237/130768623-34bed63f-a001-426e-867a-256ca2ab6e4d.png)

1. 数组先排序，以target作为根节点，创建一个分支做减法。
2. 得到分支结果后，以该结果作为根节点，创建分支做减法。
3. 如果结果未负数，则返回带上一个分支，代码里的break前提就是数组要进行排序；如果结果未零，添加符合条件的值，递归终止。

```
class Solution {

    List<List<Integer>> list = new ArrayList<>();

    int[] candidate;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        candidate = candidates;
        recall(0,target,new LinkedList<>());
		return list;
    }

    private void recall(int start, int target, LinkedList<Integer> path) {
		if (target == 0) {
			list.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i <candidate.length ; i++) {
			int sub = target - candidate[i];
			if (sub < 0) {
				break;
			}
			path.add(candidate[i]);
			recall(i,sub,path);
			path.removeLast();
		}
	}
}
```

#### 组合总和II

##### 解题思路

1. 数组先排序，以target作为根节点，创建一个分支做减法。**同一层下不能出现相同的元素，这是和[组合总和](#组合总和)不同的地方**。
2. 得到分支结果后，以该结果作为根节点，创建分支做减法。
3. 如果结果未负数，则返回带上一个分支，代码里的break前提就是数组要进行排序；如果结果未零，添加符合条件的值，递归终止。

```
class Solution {

    List<List<Integer>> list = new ArrayList<>();

	int[] candidate;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		candidate = candidates;
		recall(0,target,new LinkedList<>());
		return list;
    }

    private void recall(int start, int target, LinkedList<Integer> path) {
	if (target == 0) {
		list.add(new ArrayList<>(path));
		return;
	}
	for (int i = start; i <candidate.length ; i++) {
	        //这里解决集合重复问题 
		if (i > start && candidate[i] == candidate[i-1]) {
			continue;
		}
		int sub = target - candidate[i];
		if (sub < 0) {
			break;
		}
		path.add(candidate[i]);
		recall(i + 1,sub,path);
		path.removeLast();
	}
     }
}
```

#### 全排列
##### 解题思路
1. 每个元素都需要遍历一遍。
2. 遍历元素的时，遍历完第一数，做一个分叉遍历未遍历的数据。
3. 遍历结束后，返回上一个分叉。

##### 流程图
![流程图](https://user-images.githubusercontent.com/11553237/130755983-d80694f1-7a4d-46d8-a67a-a18ba0bc9527.png)
```

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
```

#### 全排列II
##### 解题思路
1. **首先要将元素做一个排序**，每个元素都需要遍历一遍，**如果当前元素遍历过了就遍历下一个，或者当前元素等于上一个元素并且上一个元素被遍历就遍历下一个**。
2. 遍历元素的时，遍历完第一数，做一个分叉遍历未遍历的数据。
3. 遍历结束后，返回上一个分叉。

```
class Solution {

    private boolean[] used;

    private LinkedList<Integer> path;

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new LinkedList<>();
	used = new boolean[nums.length];
	Arrays.sort(nums);
	recall(nums);
	return lists;
    }

    private void recall(int[] nums) {
	if (path.size() == nums.length) {
		lists.add(new ArrayList<>(path));
		return;
	}
	for (int i = 0; i < nums.length ; i++) {
	        //这是和全排列不同的地方
		if (used[i] || (i > 0 && nums[i] == nums[i-1] && used[i-1])) {
			continue;
		}
		used[i] = true;
		path.add(nums[i]);
		recall(nums);
		path.removeLast();
		used[i] = false;

	}
    }

}
```








