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

    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        int[] array = ARRAY;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        print(array);
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        int[] array = ARRAY;
        int preIndex,current;
        for (int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        print(array);

    }



    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
