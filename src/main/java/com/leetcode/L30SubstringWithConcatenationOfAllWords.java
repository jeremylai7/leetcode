package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-07
 * @desc: 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

	注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。


	示例 1：

	输入：s = "barfoothefoobarman", words = ["foo","bar"]
	输出：[0,9]
	解释：
	从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
	输出的顺序不重要, [9,0] 也是有效答案。

 */
public class L30SubstringWithConcatenationOfAllWords {

	@Test
	public void test() {
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> list = findSubstring(s,words);
		System.out.println(list);

	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int wordNum = words.length;
		if (wordNum == 0) {
			return result;
		}
		int wordLen = words[0].length();
		// hashMap1 存所有单词
		Map<String,Integer> allWords = new HashMap<>();
		for (String word : words) {
			int value = allWords.getOrDefault(word,0);
			allWords.put(word,value + 1);
		}
		// 遍历所有的子串
		for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
			// hashMap2 存当前扫描的字符串含有的单词
			Map<String,Integer> hashWord = new HashMap<>();
			int num = 0;
			while (num < wordNum) {
				// 截取单词
				String word = s.substring(i + num * wordLen,i + (num + 1) * wordLen);
				if (allWords.containsKey(word)) {
					int value = hashWord.getOrDefault(word,0);
					hashWord.put(word,value + 1);
					//判断当前单词的 value 和 hashMap1 中该单词的 value
					if (hashWord.get(word) > allWords.get(word)) {
						break;
					}
				} else {
					break;
				}
				num++;
			}
			if (num == wordNum) {
				result.add(i);
			}
		}
		return result;
	}
}
