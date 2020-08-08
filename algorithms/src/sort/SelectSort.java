package sort;
/**
 * 选择排序算法
 */

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr=  {1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,6};
        int[] selsect = Selsect(arr);
        System.out.println(Arrays.toString(selsect));
    }
    public static int[] Selsect(int[] arr){
        int temp;
        int pos;
        int max;

        for (int i=0;i<arr.length-1;i++){  //需要n-1次排序
            pos=0;
            max=0;
            for (int j=0;j<arr.length-i;j++){   //需要遍历n、n-1、n-2。。。个数
                if(arr[j]>max){
                    max=arr[j];
                    pos=j;
                }

            }
            temp=arr[arr.length-1-i];
            arr[arr.length-1-i]=max;
            arr[pos]=temp;

        }
        return arr;
    }
}
