package sort;
/**
 * 冒泡排序算法
 */

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,3};
        int[] bubble = Bubble(ints);
        System.out.println(Arrays.toString(bubble));

    }

    public static int[] Bubble(int[] arr){
        int temp;

        boolean ischang;

        for (int i=0;i<arr.length-1;i++){
            ischang=false;
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    ischang=true;
                }
            }
            if (ischang ==false){
                break;
            }
        }
        return arr;
    }
}


