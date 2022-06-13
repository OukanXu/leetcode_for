public class quick_sort {

	public static void quick(int[] num,int low, int high) {
		if(low >= high) {
			return;
		}
		int l = low;
		int r = high;
		int key = num[low];
		int temp = 0;
		
	while(l < r) {
		//从右往左找到第一个小于key的
		while(l < r && num[r] >= key) {
			r--;
		}
		//从左往右找到第一个大于key的
		while(l < r && num[l] <= key) {
			l++;
		}
		//交换
		if(l < r) {
			temp = num[l];
			num[l] = num[r];
			num[r] = temp;
		}
		//继续遍历
	}
	//当左右的指针重叠,证明在此下标的右边都是大于key，此下标左边都是小于key
	//将key与此下标的值交换
	num[low] = num[l];
	num[l] = key;
	
	//如果左侧下标大于low，说明左侧还有数，继续递归调用
	if(l>low) {
		quick(num,low,l-1);
	}
	
	//如果右侧下标小于最大下标，说明右侧还有数组，继续递归调用
	if(r < high) {
		quick(num, r+1, high);
	}	
	}
	
	
	public static void main(String[] args) {
		int[] arr = {-2,-9,-1,11,25,63,10,44,77,44,54,32,7};
		quick(arr, 0, arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}


