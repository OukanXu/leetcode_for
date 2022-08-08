package leetcode_for.P3_easy_sorts;
/*
 * 从第一位开始，选择最小的，如果不是最小的，交换，一次循环选择出最小的一位在最左
 */
public class SelectionSort {
    public static int[] selection_sort(int [] arr){


        for(int i = 0; i< arr.length-1; i++){
            int min = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
            }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}

