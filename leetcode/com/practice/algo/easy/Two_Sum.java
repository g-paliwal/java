class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] sortedNum = mergeSort(nums ,0 , nums.length-1);

		for(int i= 0;i<sortedNum.length ;i++) {
			int searchNum = target - sortedNum[i];
			int otherindex = binarySearch(sortedNum, searchNum, i+1, sortedNum.length-1);
			if(otherindex != -1) {
				int findex = findIndex(nums, 0 , sortedNum[i]);
				int SecSearchIndex =  (sortedNum[i] == searchNum) ? findex+1 : 0 ;
				int sindex = findIndex(nums,SecSearchIndex, sortedNum[otherindex]);
				if(findex < sindex) 
					return new int[] {findex ,sindex};
				else 
					return new int[] {sindex ,findex};
					
			}
		}
			
		return new int[]{0,0};

	}
	
	private int findIndex(int[] nums,int startIndex, int value) {
		for(int i=startIndex;i<nums.length ;i++) {
			if(nums[i]==value)
				return i;
		}
			return -1;
	}
	
	private int binarySearch(int[] nums, int number, int start, int end) {
		if(start >  end)
			return -1;
		if(start == end ) {
			if(nums[start] ==number )
				return start;
			return -1;
		}
		int mid = (start+end) /2 ;
		if(number == nums[mid])
			return mid;
		else if(number < nums[mid])
			return binarySearch(nums, number, start, mid-1);
		else 
			return binarySearch(nums, number, mid+1, end);		
	}

	private int[] mergeSort(int[] nums, int sindex, int lindex) {
		if(sindex>= lindex)
			return nums;
		int mindex = (sindex+lindex) /2;

		nums = mergeSort(nums, sindex, mindex);
		nums = mergeSort(nums, mindex+1, lindex);

		nums = merge(nums ,sindex,mindex,lindex);

		return nums;		
	}

	private int[] merge(int[] nums, int sindex, int mindex, int lindex) {
		int tmp[] = nums.clone();
		int k=sindex;
		int i=sindex;
		int j = mindex+1 ;
		for(; i<= mindex && j<= lindex; ) {
			if( nums[i] < nums[j] ) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
			}
		}

		while( i <= mindex) {			
			tmp[k++] = nums[i++];
		}		

		while( j <= lindex) {			
			tmp[k++] = nums[j++];
		}		
		nums = tmp;
		return nums;
	}



}
