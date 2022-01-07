package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-07
 * @desc: 交错字符串
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

	两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

	s = s1 + s2 + ... + sn
	t = t1 + t2 + ... + tm
	|n - m| <= 1
	交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
	提示：a + b 意味着字符串 a 和 b 连接。

	 

	示例 1：


	输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
	输出：true
	示例 2：

	输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
	输出：false
 */
public class L97InterleavingString {

	@Test
	public void test() {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		boolean flag = isInterleave(s1,s2,s3);
		System.out.println(flag);
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		Map<String, Integer> memoization = new HashMap<>();
		return getAns(s1,0,s2,0,s3,0,memoization);
	}

	private boolean getAns(String s1, int i, String s2, int j, String s3, int k,Map<String,Integer> memoization) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		String key = i + "@" + j;
		if (memoization.containsKey(key)) {
			return memoization.getOrDefault(key,-1) == 1;
		}

		if (i == s1.length() && j == s2.length() && k == s3.length()) {
			memoization.put(key,1);
			return true;
		}
		//i 到达了末尾，移动 j 和 k
		if (i == s1.length()) {
			while (j < s2.length()) {
				if (s2.charAt(j) != s3.charAt(k)) {
					memoization.put(key,0);
					return false;
				}
				j++;
				k++;
			}
			memoization.put(key,1);
			return true;
		}
		//j 到达末尾，移动 i 和 k
		if (j == s2.length()) {
			while (i < s1.length()) {
				if (s1.charAt(i) != s3.charAt(k)) {
					memoization.put(key,0);
					return false;
				}
				i++;
				k++;
			}
			memoization.put(key,1);
			return true;
		}
		//后移 i 和 k
		if (s1.charAt(i) == s3.charAt(k)) {
			if (getAns(s1,i + 1,s2,j,s3,k + 1,memoization)) {
				memoization.put(key,1);
				return true;
			}
		}
		//移动 i 和 k 失败，移动 j 和 k
		if (s2.charAt(j) == s3.charAt(k)) {
			if (getAns(s1,i,s2,j+1,s3,k+1,memoization)) {
				memoization.put(key,1);
				return true;
			}
		}
		memoization.put(key,0);
		return false;

	}
}
