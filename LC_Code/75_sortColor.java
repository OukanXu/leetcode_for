/*给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库的sort函数的情况下解决这个问题。

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]

输入：nums = [2,0,1]
输出：[0,1,2]
*/


//冒泡
class Solution {
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length-1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//选择
class Solution {
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int index = i;
            for(int j = i+1; j < nums.length; j++){
                
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
            swap(nums, i, index);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//插入
class Solution {
    public void sortColors(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    swap(nums, j, j-1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//归并
class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        process(nums,l,r);
    }

    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void process(int[] arr, int l, int r){
        if(l == r){return;}

        int m = l + ((r-l)>>1);
        process(arr, l, m);
        process(arr,m+1,r);
        merge(arr,l,m,r);       
    }

    public void merge(int[] arr, int l, int m, int r){
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = m+1;
        int i = 0;

        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }

        for(int j = 0; j < help.length; j++){
            arr[l+j] = help[j];
        }
    }
}

//快排
import java.util.Random;

class Solution {
    public void sortColors(int[] nums) {
        int L = 0;
        int R = nums.length-1;
        quickSort(nums, L, R);
    }

    public void quickSort(int[] arr, int L, int R){
        //随机抽取一个数到最后一位
        if(L<R){
            swap(arr,L + (int)(Math.random() * (R-L+1)),R);
            int[] p = patition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
        
    }

    public int[] patition(int[] arr, int L, int R){
        //动left，more，less
        int less = L-1;
        int more = R;
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                swap(arr, L, --more);
                
            }else if(arr[L] == arr[R]){
                L++;
            }
        }
        swap(arr,R,more);
        return new int[]{less+1,more};
    }




    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//堆
import java.util.Random;

class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            heapInsert(nums,i);
        }

        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while(heapSize > 0){
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    

    public void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public void heapify(int[] arr, int index, int heapSize){
        int left = index*2+1;
        
        //当下方还有左孩子时，比较俩孩子和父节点大小
        while(left < heapSize){
            int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;//比较俩孩子大小，要注意当left+1不存在时，最大值应该为left
            largest = arr[largest] > arr[index] ? largest : index;//比较与父节点，谁大
            if(largest == index){break;}//如果父节点最大，就不往下走
            swap(arr, index, largest);
            index = largest;
            left = index*2+1;

        }
    }




    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}