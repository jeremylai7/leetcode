package com.leetcode;

import org.junit.Test;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

/**
 * @Author: laizc
 * @Date: Created in  2021-03-29
 * @desc: 字母异位词分组
 */
public class L49GroupAnagrams {

	private String[] array =  {"eat", "tea", "tan", "ate", "nat", "bat"};


	/**
	 * 使用map将相同的字母放在同一个key上
	 */
	@Test
	public void mapTest() {
		Map<String,List<String>> map = new HashMap<>();
		for (String str : array) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!map.containsKey(key)) {
				map.put(key,new ArrayList<>());
			}
			map.get(key).add(str);
		}
		List<List<String>> list = new ArrayList<>(map.values());
		System.out.println(list);

	}


}
