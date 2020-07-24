package java8Basics;

public class MaximunSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		int size = arr.length;
		
		int tempmax = arr[0];
		int currmax = tempmax;
		
		for(int i =1 ; i<size;i++)
		{
			currmax = Math.max(arr[i],currmax+arr[i]);
			tempmax = Math.max(currmax,tempmax);
		}
		
		System.out.println(tempmax);

	}

}
