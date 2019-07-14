package main.heap;

import java.util.Arrays;

/**
 * 二叉堆
 */
public class BinaryHeap {

    /**
     * 上浮
     * @param array
     */
    public static void upAdjust(int[] array){

        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;
        int temp = array[childIndex];
        while(childIndex > 0 && array[parentIndex] > temp){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length){

        int temp = array[parentIndex];
        int childIndex = (parentIndex * 2) + 1;
        while (childIndex < length){
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }
            if (temp <= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;

        }

        array[parentIndex] = temp;

    }


    public static void buildHeap(int[] array){
        for (int i = (array.length - 2)/2;i >= 0; i--){
            downAdjust(array, i, array.length);
        }
    }


    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
