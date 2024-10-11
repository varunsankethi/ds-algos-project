package com.coursera.algotoolbox.week1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class MaxPairwiseProduct {
	static int getMaxPairwiseProduct(int[] numbers) {
		int max_product = 0;
		int n = numbers.length;

		for (int first = 0; first < n; ++first) {
			for (int second = first + 1; second < n; ++second) {
				max_product = Math.max(max_product, numbers[first] * numbers[second]);
			}
		}

		return max_product;
	}

	static long getMaxPairwiseProductFast(int[] numbers) {

		int firstLargestIndex = 0;
		long firstLargestNumber = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > firstLargestNumber) {
				firstLargestNumber = numbers[i];
				firstLargestIndex = i;

			}
		}

		long secondLargestNumber = 0;

		for (int j = 0; j < numbers.length; j++) {
			if (j != firstLargestIndex && numbers[j] > secondLargestNumber) {
				secondLargestNumber = numbers[j];
			}
		}
		
		System.out.println("First largest number = " + firstLargestNumber);
		System.out.println("Second largest number = " + secondLargestNumber);

		return Long.valueOf(firstLargestNumber) * Long.valueOf(secondLargestNumber);

	}

	public static void main(String[] args) {

		// Creating stress test

		/*
		 * while (true) {
		 * 
		 * int numOfNums = generateRandomNumber(100000) + 2; int[] numbers = new
		 * int[numOfNums];
		 * 
		 * System.out.println("Number of numbers = " + numOfNums);
		 * 
		 * for (int i = 0; i < numOfNums; i++) { numbers[i] =
		 * generateRandomNumber(10000); }
		 * 
		 * System.out.println(Arrays.toString(numbers)); int slowProduct =
		 * getMaxPairwiseProduct(numbers); int fastProduct =
		 * getMaxPairwiseProductFast(numbers);
		 * 
		 * if (slowProduct != fastProduct) { System.out.println("Wrong answer");
		 * System.out.println("Slow product " + slowProduct);
		 * System.out.println("Fast product " + fastProduct); break;
		 * 
		 * } else { System.out.println("OK"); }
		 * 
		 * }
		 */

		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProductFast(numbers));

	}

	static int generateRandomNumber(int moduloNumber) {
		return Math.abs(ThreadLocalRandom.current().nextInt()) % moduloNumber;

	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
