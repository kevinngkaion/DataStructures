// Kevin Ngkaion
// cosc 222
// Lab 5
// Oct 25, 2022

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hashing {

	// with ~341,000 words, a table size of 1mil keeps the load factor low
	static final int tableSize = 1_000_000;

	public static void main(String[] args) throws IOException {

		// DONE: You will be hashing strings using polynomial in k, for all values
		// k=1 to 50. Once you have this one case (of k=31) working, you will
		// probably want to wrap your code in a for loop for k=1 to 50
		int k = 31;

		// Leave these two lines alone for opening the input file
		FileReader f = new FileReader("./englishWords.txt");
		Scanner sc = new Scanner(f);
		
		// Copy all words into an arraylist
		ArrayList<String> words = new ArrayList<String>();
		while (sc.hasNext()) {
			words.add(sc.nextLine());
		}
		

		// This creates your hashtable or simulated hashtable of size tableSize
		
		// Wrap everything in for loop to change value of K;

		for (k = 1; k < 51; k++) {
			
			int[] counts = new int[tableSize];
			
			// Var to count # of collisions
			int collisions = 0;

			// This loop runs through the words in the file
			for (String s : words) {				
				// DONE: remove or comment-out this next line, or modify it
				// for your own debugging purposes
				

				// DONE: Find hashValue of s using hash(s,k). Update your simulated hashtable
				// note: if your hash(s,k) function is correct, hash(s,31) should
				//			correspond exactly to s.hashCode();
				int hash = hash(s,k);
				if (hash > counts.length || hash < 0) {
					hash %= tableSize;
					if (hash < 0) {
						hash += tableSize;
					}
				}
				// TODO: Don't forget to count collisions
				if (counts[hash] > 0) {
					collisions++;
				}
				counts[hash]++;
			}
			int maxBucketSize = getMaxBucketSize(counts);

			
			// DONE: Find the maximum bucket size
			// DONE: Report the total number of collisions found at this k value
			// DONE: Report the maximum bucket size found at this k value
			System.out.println("k: " + k + " | collisions: " + collisions + " | maxBucketSize: " + maxBucketSize);
		}

		// Leave this line alone to close the input file
		f.close();
		
	}
	
	public static int getMaxBucketSize(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i ++) {
			if (max < array[i])
				max = array[i];
		}
		return max;
	}


	public static int hash(String s, int k) {
		int value = 0;
		
		// DONE: Compute the hash function in O(n) time, where n = s.length()
		// You can do this using Horner's method to compute the polynomial
		// s[0]*k^(n-1) + s[1]*k^(n-2) + ... + s[n-1]

		if (s.length() > 0) {
			value = s.charAt(0);
			for (int i = 1; i < s.length(); i++) {
				value = (value * k) + s.charAt(i);
			}
		}

		return value;
	}
}

/***********************************************************
 * Report your best k values here in this comment block
 * (if you want, you can output all k values and then visually
 * inspect your output for your 3 best k values). Give your 3
 * best k-values for (i) the smallest total number of collisions,
 * and also give another set of (ii) your 3 best k-values according
 * to the smallest value for the max-bucket-size.
 * 
 * Best k-values for minimizing bucket size: [19: 5, 43: 5, 49: 5]
 * Best k-values for minimizing # of collisions: [29: 51,768, 31: 51,765, 43: 51,839]
 * 
 * I handled negative hash values by using % 1 million to the value. If the value was still negative after that,
 * I would add 1 million to the value.
 * 
 */