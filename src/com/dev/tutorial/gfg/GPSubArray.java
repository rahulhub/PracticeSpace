package com.dev.tutorial.gfg;

/* Given an array arr[] of N integers, the task is to find the count of all subarrays from the given array of at least size 3 forming a Geometric Progression.

Examples:  

    Input: arr[] = {1, 2, 4, 8}
    Output: 3
    Explanation: The required subarrays forming geometric progression are: 

        {1, 2, 4}
        {2, 4, 8}
        {1, 2, 4, 8} */

public class GPSubArray {

	//The idea is to use a property of Geometric Progression i.e., 
	//{a, b, c} is GP if and only if a*c = b^2. Follow the below steps to solve the problem:
	
	static int numberOFSubArr(int arr[],int arrLength)
	{
		if(arrLength < 3)
			return 0;
		
		int count=0;
		int response = 0;
		for(int i = 2;i<arrLength;++i) {
			if(arr[i-1]*arr[i-1] == arr[i]*arr[i-2]) {
				++count;
			}else {
				count=0;
			}
			
			response += count;
		}
		
		
		
		return response;
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,4,8,16};
		System.out.println(numberOFSubArr(arr,arr.length));
	}

}
