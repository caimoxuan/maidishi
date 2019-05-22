package com.mds.matrix.test;

import java.util.Arrays;

/**
 * @author cmx
 * @Date 2019/5/19 20:56
 */
public class Search {

    public static int[] sorted = {1,4,5,7,8,9,11,13,45};

    public static int binarySearch(int[] arr, int key, int start, int end){

        int middle = start + (end - start) / 2;

        if(arr[middle] == key){
            return middle;
        }

        if(start >= end){
            return -1;
        }

        if(key < arr[middle]){
          return  binarySearch(arr, key, start, middle - 1);
        }else{
          return  binarySearch(arr, key, middle + 1, end);
        }
    }
    public static void main(String[] args){
        System.out.println(binarySearch(sorted, 12, 0, sorted.length - 1));
    }


}
