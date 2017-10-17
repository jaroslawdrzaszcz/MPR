package junitdemo;

public class Calculator {

	public int add(int i, int j) {
		return i+j;
	}

	public int multiply(int i, int j) {
		// TODO Auto-generated method stub
		return i*j;
	}

	public int divide(int i, int j) {
		// TODO Auto-generated method stub
		return i/j;
	}

	public int subtract(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}

	public int power(int i, int j) {
		// TODO Auto-generated method stub
		int res = 1;
		if (j==0)
			return res;
		else 
		{	res = i;
			for(int a=1; a<j; a++)
			{
			res = res*i;}
			return res;
		}
		}

	public int factorial(int i) {
		// TODO Auto-generated method stub
		if (i<2){
			return 1;
		}
		else{
			
			return i*factorial(i-1);
		}
	}

	
	/*public int factorial(int i) {
		// TODO Auto-generated method stub
			int res = 1;
		if (i==0)
			return res;
		else 
		{
			for(int a=1; a<=i; a++)
			{
			res = res*a;}
			return res;
		}
	}*/
}
