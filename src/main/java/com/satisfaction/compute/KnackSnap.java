package com.satisfaction.compute;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnackSnap {
	
	@RequestMapping
	public String getOptimizedDishes(){
		Scanner s = null;
		try {
			s = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		int t = s.nextInt();
		int n = s.nextInt();
		int time[] = new int[n];
		int sVal[] = new int[n];
		for(int i=0;i<n;i++){
			sVal[i] = s.nextInt();
			time[i] = s.nextInt();
 		}
		
		int result = knapSack(t, time, sVal, n);
		
		System.out.println(result);
		return String.valueOf(result);
	}
	
	// A utility function that returns maximum of two integers
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can be put in a knapsack of capacity t
	public int knapSack(int t, int time[], int sVal[], int n) {

		int k[][] = new int[n + 1][t + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int s = 0; s <= t; s++) {
				if (i == 0 || s == 0)
					k[i][s] = 0;
				else if (time[i - 1] <= s)
					k[i][s] = max(sVal[i - 1] + k[i - 1][s - time[i - 1]], k[i - 1][s]);
				else
					k[i][s] = k[i - 1][s];
			}
		}

		return k[n][t];
	}
}
