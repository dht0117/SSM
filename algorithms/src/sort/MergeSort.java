package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrs={1, 7, 9, 15, 6, 8, 3, 5,50,45,89,77,56,6};
        mergeSort(arrs,0,arrs.length-1);
        System.out.println(Arrays.toString(arrs));
    }

    public static void mergeSort(int[] arr,int L,int R){
        if (L==R){
            return;
        }else {
            int M=(L+R)/2;
            //对左边进行拆分
            mergeSort(arr,L,M);
            //对右边进行拆分
            mergeSort(arr,M+1,R);
            //合并
            merge(arr,L,M+1,R);

        }
    }

    /**
     * 合并数组
     * @param arr
     * @param L  数组的第一个元素
     * @param M   数组的中间元素
     * @param R   数组的最后一个元素
     */
    public static void merge(int[] arr,int L,int M,int R){
        //定义左右子数组
        int[] leftarr=new int[M-L];
        int[] rightarr=new int[R-M+1];

        //左右子数组中填充数据，确保下标从0开始
        for (int i=L;i<M;i++){
            leftarr[i-L]=arr[i];
        }
        for (int i=M;i<=R;i++){
            rightarr[i-M]=arr[i];
        }
        int i=0 ;int j=0;
        //k为指向大数组的指针
        int k=L;
        //比较左右两数组中的值，小的放在大数组中，并将指针向后移动
        while (i<leftarr.length && j<rightarr.length){
            if (leftarr[i]>rightarr[j]){
                arr[k]=rightarr[j];
                j++;
                k++;
            }else {
                arr[k]=leftarr[i];
                i++;
                k++;
            }
        }
        //当右边的数据全放入大数组时，把左边剩下的数据放入大数组即可
        while (i<leftarr.length){
            arr[k]=leftarr[i];
            i++;k++;
        }
        while (j<rightarr.length){
            arr[k]=rightarr[j];
            j++;k++;
        }

    }
}
