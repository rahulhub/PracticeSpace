package com.dev.tutorial;

public class Test {
	
	int modularExponentiation(int x,int n,int M)
	{
	    if(n==0)
	        return 1;
	    else if(n%2 == 0)        //n is even
	        return modularExponentiation((x*x)%M,n/2,M);
	    else                             //n is odd
	        return (x*modularExponentiation((x*x)%M,(n-1)/2,M))%M;

	}

	public static void main(String[] args) {
		
		Test tes = new Test();
		int result = tes.modularExponentiation(5, 2, 28);
		
		System.out.println(result);
		

	}

}
