package com.mds.matrix.test;

import java.util.Arrays;

/**
 * @author cmx
 * @Date 2019/5/19 19:32
 */
public class Sort {


    public static int[] readArray = {4,7,0,2,6,6,8,2,8,9,12,56,87,123,58,90,16};

    public static int[] bubbleSort(int[] arr){
        int length = arr.length - 1;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i; j ++){
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j +1] = temp;
                }
            }
        }
        return arr;
    }



    public static int[] quickSort(int[] arr, int left, int right){

        int low = left;
        int key = arr[low];
        int high = right;

        if(left >= right){
            System.out.println("left" + left + "..." + "right " + right);
            return arr;
        }

        while(low < high) {
            while (low < high && arr[low] <= key) {
                low++;
            }
            while (high > low && arr[high] >= key) {
                high--;
            }
            if(low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        arr[left] = arr[low];
        arr[low] = key;
        quickSort(arr, low, high - 1);
        quickSort(arr, high + 1, right);
        return arr;
    }


    public static void quickSorted0(int[] arr, int low, int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSorted0(arr, low, j-1);
        //递归调用右半数组
        quickSorted0(arr, j+1, high);
    }


    public static int[] quickSort_2(int[] arr, int start, int end){
        if(arr == null || start > end){
            return arr;
        }
        int i = start;
        int j = end;
        int key = arr[start];
        while(i < j){
            while(j > i && arr[j] >= key){
                j--;
            }
            if(j > i){
                arr[i++] = arr[j];
            }
            while(i < j && arr[i] <= key){
                i++;
            }
            arr[j--] = arr[i];
        }
        arr[i] = key;
        quickSort_2(arr, start, i - 1);
        quickSort_2(arr, i + 1, end);
        return arr;
    }


    public static void main(String[] args){

        //System.out.println(Arrays.toString(bubbleSort(readArray)));
        System.out.println(Arrays.toString(quickSort_2(readArray, 0, readArray.length - 1)));
//        quickSorted0(readArray, 0, readArray.length -1);
//        System.out.println(Arrays.toString(readArray));
    }

}
