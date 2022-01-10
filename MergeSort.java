package com;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={7,5,2,4,9};
        int[] ans=mergeSort(arr); //updating the original array
        System.out.println(Arrays.toString(ans));

    }
    static int[] mergeSort(int[] arr)
    {
         if(arr.length == 1)
        {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left= mergeSort(Arrays.copyOfRange(arr,0,mid)); //from left hand side we will be getting answer in form of array
        int[] right= mergeSort(Arrays.copyOfRange(arr,mid,arr.length));//and same from right side

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i=0;
        int j=0;
        int k=0; //for the final array

        while(i < first.length && j < second.length)
        {
            if(first[i] < second[j])
            {
                mix[k]=first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;//move ahead as well,as u add the elements
        }
        //it may be possible that one of the arrays is not complete
        //copy the remaining elements
        while( i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while( j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
