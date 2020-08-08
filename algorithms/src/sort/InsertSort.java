package sort;
/**
 * 插入排序
 */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr={1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,9,8};
        int[] insert = insert(arr);
        System.out.println(Arrays.toString(insert));
    }

    public static int[] insert(int[] arr){
        int temp;

        for (int i=1;i<arr.length;i++){
            int j=i-1;
            temp=arr[i];
            while (j>=0&&arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }

        return arr;
    }
}
