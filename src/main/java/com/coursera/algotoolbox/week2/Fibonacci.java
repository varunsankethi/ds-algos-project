package com.coursera.algotoolbox.week2;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  
  private static long calcFibFast(int n) {
	  
	  long[] fibArray = new long[n+1];
	  
	  if (n == 0) {
		  return 0;
	  }
	  
	  if (n == 1) {
		  return 1;
	  }
	  fibArray[0] = 0;
	  fibArray[1] = 1;
	  
	  for(int i = 2; i<=n ; i++) {
		  fibArray[i] = fibArray[i-1] + fibArray[i-2];		  
	  }
	  
	  return fibArray[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calcFibFast(n));
  }
}
