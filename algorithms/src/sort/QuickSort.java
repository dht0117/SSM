package sort;
/**
 * 快速排序算法
 * 思想：通过一次排序，将要排序的数据分割成两部分，其中一部分数据要比另一部分数据小，
 * 然后再按此方法对两部分数据进行快速排序，
 * 递归的思想
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,6};
        int[] quick = quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(quick));
    }

    public static int[] quicksort(int[] arr,int L,int R){
        int i=L;
        int j=R;
        int temp;
        int medium=arr[(L+R)/2];
        while (i<=j){
            while (arr[i]<medium) i++;
            while (medium<arr[j]) j--;
//            if (arr[i]>arr[j]){
            //此时已经分别找到了比支点大的左边数字和比支点小的右边数字
            if (i<=j){       //<--  判断条件
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                j--;
            }
        }

        if (L<j){
            quicksort(arr,L,j);
        }

        if (i<R){
            quicksort(arr,i,R);
        }

        return arr;
    }
}
