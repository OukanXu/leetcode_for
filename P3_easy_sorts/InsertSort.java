package leetcode_for.P3_easy_sorts;
/*
 * j为有序数组的最后一位，与无序数组第一位对比，交换
 */
public class InsertSort {
    public static void insert_sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j>=0 && arr[j]>arr[j+1]; j--){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
           
        }
    }
}
