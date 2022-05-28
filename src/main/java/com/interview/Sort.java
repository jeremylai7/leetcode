package com.interview;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2022/5/28
 * @desc: 十大排序
 **/
public class Sort {

    private final int[] ARRAY = {3,6,4,2,11,10,5};

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        int[] array = ARRAY;
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length - 1 - i ; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        print(array);

    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
