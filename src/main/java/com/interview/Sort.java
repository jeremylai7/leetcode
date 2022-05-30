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

    /**
     * 快速排序
     */
    @Test
    public void quickSort() {
        int[] array = ARRAY;
        recall(array,0,array.length - 1);
        print(array);
    }

    private void recall(int[] array,int left,int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 找到基准值，先存起来
        int stand = array[i];
        while (i < j) {
            // 找到比基准值小的数
            while (i < j && array[j] > stand) {
               j--;
            }
            // 小于基准值并赋值
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            // 找到大于基准值的数
            while (i < j && array[i] < stand) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = stand;
        recall(array,left,i - 1);
        recall(array,i + 1,right);





    }


    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
