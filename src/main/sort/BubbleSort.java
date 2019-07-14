package main.sort;

import java.util.Arrays;

/**
 * 冒泡排序练习
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int [] array = new int[]{5,8,6,3,9,2,1,7};
        int [] array = new int[]{0,2,3,4,5,6,7,8,1};
//        sort(array);
//        betterSort(array);
          bestSort(array);
        System.out.println(Arrays.toString(array));

    }

    //初步改进
    public static void sort(int [] array){

        int count = 0;
        for (int i = 0; i<array.length - 1; i++){
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++){
                count++;
                int temp = 0;
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
        System.out.println(count);
    }


    //较大改进
    public static void betterSort(int [] array){

        int lastIndex = 0;
        int count = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++){
            boolean isSorted = true;
            for (int j = 0; j<sortBorder; j++){
                count++;
                int temp = 0;
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    lastIndex = j;
                }
            }
            sortBorder = lastIndex;
            if (isSorted){
                break;
            }
        }
        System.out.println(count);

    }

    //鸡尾酒排序(改进)
    public static void bestSort(int [] array){

        int temp = 0;
        int count = 0;
        int oddBorder = array.length - 1;//奇数轮边界
        int oddLastIndex = 0;
        int evenBorder = array.length - 1;//偶数轮边界
        int evenLastIndex = array.length - 1;
        for (int i = 0; i < array.length/2; i++){
            boolean isSorted = true;
            //奇数轮，从左向右进行比较和交换
            for (int j = 0; j < oddBorder; j++){
                count++;
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    oddLastIndex = j;
                }
            }
            oddBorder = oddLastIndex;
            if (isSorted){
                break;
            }

            isSorted = true;
            //偶数轮
            for (int j = evenBorder; j > i; j--){
                count++;
                if (array[j] < array[j - 1]){
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                    evenLastIndex = j;
                }
            }
            evenBorder = evenLastIndex;
            if (isSorted){
                break;
            }
        }
        System.out.println(count);

    }

}
