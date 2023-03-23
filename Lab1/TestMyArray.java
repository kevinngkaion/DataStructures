/**
 *  This program instantiates a java ArrayList<Integer> and an instance of your
 *  own custom int array (MyIntArrayList) and compares them for speed and accuracy
 *
 *  You do not need to edit this file, but you can add more tests if you like.
 *  
 *  You are done if all the tests pass with 'true' below
 */

import java.util.ArrayList;
import java.util.Random;

public class TestMyArray {

	static ArrayList<Integer> arr; 
	static MyIntArrayList myArr;
	static Random rand = new Random();

	public static void main(String[] args) {
		int testSize = 10_000_000; // use a value between 100,000 and 20 million
		

		correctnessTestsAddOnly();
		System.out.println("-----------------------------------");
		correctnessTestsAddAndRemove();
		System.out.println("-----------------------------------");
		timeTests(testSize);		
	}

	public static void correctnessTestsAddOnly() {
		System.out.println("Correctness Tests (add only)");
		myArr = new MyIntArrayList();
		arr = new ArrayList<>();
		myArr.add(5); myArr.add(1); myArr.add(-3); myArr.add(14); myArr.add(6);
		arr.add(5); arr.add(1); arr.add(-3); arr.add(14); arr.add(6);
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		
		myArr.add(0); myArr.add(5); myArr.add(1); myArr.add(-3); myArr.add(14); myArr.add(6);
		arr.add(0); arr.add(5); arr.add(1); arr.add(-3); arr.add(14); arr.add(6);
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );
		System.out.println("mine at position 3: " + myArr.get(3));
		System.out.println("java at position 3: " + arr.get(3) + " equal? "+ (myArr.get(3)==arr.get(3)) );
		
	}

	public static void correctnessTestsAddAndRemove() {
		System.out.println("Correctness Tests (add and remove)");
		myArr = new MyIntArrayList();
		arr = new ArrayList<>();
		myArr.add(5); myArr.add(1); myArr.add(-3); myArr.add(14); myArr.add(6); myArr.remove(3);
		arr.add(5); arr.add(1); arr.add(-3); arr.add(14); arr.add(6); arr.remove(3);
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );

		myArr.remove(0);
		arr.remove(0);
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );

		
		myArr.add(0); myArr.add(5); myArr.add(1); myArr.add(-3); myArr.add(14); myArr.add(6);
		arr.add(0); arr.add(5); arr.add(1); arr.add(-3); arr.add(14); arr.add(6);
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );
		System.out.println("mine at position 3: " + myArr.get(3));
		System.out.println("java at position 3: " + arr.get(3) + " equal? "+ (myArr.get(3)==arr.get(3)) );

		myArr.remove(0); myArr.remove(myArr.size()-1);
		arr.remove(0); arr.remove(arr.size()-1);
		System.out.println("mine: " + myArr);
		System.out.println("java: " + arr + " equal? " + myArr.toString().equals(arr.toString()));
		System.out.println("mine: " + myArr.size());
		System.out.println("java: " + arr.size() + " equal? "+ (myArr.size()==arr.size()) );

	}
	
	public static void timeTests(int testSize) {
		long start,end, myTime, javaTime;

		System.out.println("Time Tests with size " + testSize);

		for (int trial = 1; trial <= 5; trial++) {
			// test my array
			start = System.nanoTime();
			myArr = new MyIntArrayList();
			for (int i=0; i<testSize; i++) myArr.add(rand.nextInt());
			end = System.nanoTime();
			myTime = end-start;
			// test java's ArrayList
			start = System.nanoTime();
			arr = new ArrayList<>();
			for (int i=0; i<testSize; i++) arr.add(rand.nextInt());
			end = System.nanoTime();
			javaTime = end-start;
			
			System.out.println(trial+". myTime: " + myTime/1000000 + " milliseconds");
			System.out.println(trial+". java: " + javaTime/1000000 + " milliseconds. Win? " + (myTime<javaTime));
			if (testSize <= 100) {
				// if-statement is here to prevent outputting millions of values, but
				// will display arrays if small to help for debugging purposes
				System.out.println(arr);
				System.out.println(myArr);
			}

		}
		
	}
}
