package sort;
/**
 * 希尔排序--------------插入排序的改进版本
 */

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arrs={1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,6};
        shellSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static void shellSort(int[] arr) {
        //每次增量都为step/2
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //从增量那组开始插入排序
            for (int i = step; i < arr.length; i++) {
                int j = i ;
                int temp=arr[j];
                //j-step代表同组的下一个数据
                while (j -step >= 0 && arr[j-step] > temp) {
                    arr[j]=arr[j-step];
                    j=j-step;
                }
                arr[j] = temp;
            }
        }
    }
}
