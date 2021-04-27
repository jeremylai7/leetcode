package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-04-27
 * @desc:  柠檬水找零
 */
public class L860LemonadeChange {

	private int[] array = {5,5,10,20};

	/**
	 * 贪心算法
	 */
	@Test
	public void greedyTest() {
		boolean change = true;
		int five = 0,ten = 0;
		for (int i = 0; i < array.length; i++) {
			int index = array[i];
			if (index == 5) {
				five++;
			}else if (index == 10) {
				if (five == 0){
					change = false;
					break;
				}
				five--;
				ten++;
			}else {
				if (five > 0 && ten > 0){
					five--;
					ten--;
				}else if (five >=3) {
					five = five - 3;
				}else {
					change = false;
					break;
				}

			}
		}
		System.out.println(change);

	}
}
