package P5_Sort_Total;

public class HeapSort {
    
    //插入一个数，若大于父节点，交换
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //返回最大值（arr[0]）,并且剩余仍为大顶堆：将arr[0]与arr[arr.length-1]交换，heapSize-1， 再执行heapify操作，最终得到大顶堆
    //某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize){ //index 指从哪个位置开始做heapify
        int left = index*2+1;//左孩子下标

        while(left < heapSize){//当下方还有左孩子时
            //两个孩子中谁大，把下标给largest，向下遍历
            int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;
            // 父和较大子中谁大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){//如果largest为父节点的值，不继续向下走
                break;
            }
            swap(arr, largest, index);
            index = largest;//index 变为原本较大孩子的下标
            left = index*2+1;
        }
    }

    //将i位置的值改为？，不知道是变大还是变小，将i执行heapInsert和heapify操作，两个只能中一个，若i变大了，执行heapInsert，反之执行heapify

    /*
     * N节点的完全二叉树高度为logN
     * 
     * 用户移除最大值并将剩余调整为大顶堆操作， logN
     */

     /* time cost: O(NlogN)
      * 堆排序过程：
        heapsize = 1, 是一个大顶堆，heapsize+1
        hespsize = 2， 加入了一个新数，不断执行heapInsert操作。。。

        将最大值(堆顶)与最末尾交换，heapsize--， 将最大值从堆中剔除，剩余执行heapify，生成一个大顶堆，重复以上操作

      */

      public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);//生成大顶堆 O(NlogN) 
        }
        // for(int i = arr.length; i >= 0; i--){
        //  heapify(arr,i,arr.length)
        //}最优解：O(N)(从最末尾节点开始执行heapify)



        int heapSize = arr.length;
        swap(arr,0,--heapSize);//将最大值放在末尾，并从堆中删除
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
      }
}
