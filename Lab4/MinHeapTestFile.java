// Kevin Ngkaion
// cosc 222
// Lab 4
// Oct 25, 2022

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class MinHeapTestFile {

	@Test
	void testEmptyPeek() {
		MinHeap<Integer> m = new MinHeap<>();
		assertEquals(null,m.peek());		
	}

	@Test
	void testEmptyPoll() {
		MinHeap<Integer> m = new MinHeap<>();
		assertEquals(null,m.poll());
	}

	@Test
	void testEmptySize() {
		MinHeap<Integer> m = new MinHeap<>();
		assertEquals(0,m.size());
		m.add(6);
		assertEquals(1,m.size());
	}

	@Test
	void testFewIntegers() {
		MinHeap<Integer> m = new MinHeap<>();
		m.add(5);
		m.add(1);
		m.add(9);
		assertEquals(1,m.poll());
		assertEquals(5,m.poll());
		assertEquals(9,m.poll());
	}

	@Test
	void testRepeatedValues() {
		MinHeap<Integer> m = new MinHeap<>();
		m.add(5);
		m.add(1);
		m.add(9);
		m.add(5);
		m.add(1);
		m.add(9);
		assertEquals(1,m.poll());
		assertEquals(1,m.poll());
		assertEquals(5,m.poll());
		assertEquals(5,m.poll());
		assertEquals(9,m.poll());
		assertEquals(9,m.poll());
		
	}

	@Test
	void testStrings() {
		MinHeap<String> m = new MinHeap<>();
		m.add("don't");
		m.add("tase");
		m.add("me");
		m.add("bro");
		m.add("all");
		m.add("your");
		m.add("base");
		m.add("are");
		m.add("belong");
		m.add("to");
		m.add("us");
		assertEquals(11,m.size());
		assertTrue("all".equals(m.poll()));
		assertTrue("are".equals(m.poll()));
	}

	@Test
	void testManyDoubles() {
		MinHeap<Double> m = new MinHeap<>();
		ArrayList<Double> a = new ArrayList<Double>();
		ArrayList<Double> sorted = new ArrayList<Double>();
		//DONE: Test that the heap works with many (15 or more) doubles
		for (int i = 0; i < 15; i++) {
			double x = Math.random() * 10;
			m.add(x);
			a.add(x);
		}
		Collections.sort(a);
		while(m.size() > 0) {
			sorted.add(m.poll());
		}
		assertTrue(sorted.toString().equals(a.toString()));
	}

	@Test
	void testManyCharacters() {
		MinHeap<Character> m = new MinHeap<>();
		//DONE: Test that the heap works with many (15 or more) characters
		ArrayList<Character> a = new ArrayList<Character>();
		ArrayList<Character> sorted = new ArrayList<Character>();
		for (int i = 0; i < 15; i++) {
			char x = (char)(int)(Math.random() * 127);
			m.add(x);
			a.add(x);
		}
		Collections.sort(a);
		while(m.size() > 0) {
			sorted.add(m.poll());
		}
		assertTrue(sorted.toString().equals(a.toString()));
	}


	@Test
	void anotherHeapTest() {
		//DONE: make another test looking for possible things that can break
		//      your heap implementation. Write a description of what you
		//      are trying to test (example, all negatives? all equal? does it
		//      work on sorted order input? reverse sorted order? etc)
		
		MinHeap<Integer> heap = new MinHeap<>();
		heap.add(5);
		heap.add(1);
		heap.add(8);
		heap.add(-5);
		heap.add(-10);
		heap.add(-1);
		heap.add(0);
		heap.add(0);
		ArrayList<Integer> correct = new ArrayList<>();
		ArrayList<Integer> sorted = new ArrayList<>();
		while (heap.size() > 0) {
			int x = heap.poll();
			sorted.add(x);
			correct.add(x);
		}
		Collections.sort(correct);
		assertTrue(correct.toString().equals(sorted.toString()));
		
		
	}
	
	@Test
	void testHeapSortLarge() {
		//TODO: use a heapSort method like in the UseExample.java to
		// test that heapSort will properly sort a large array. (JUnit
		// files can contain non-test static methods as well).
		// For example:
		// - generate an array of 100 random integers
		// - pass these through a heapSort method
		// - verify that heapSort's result is sorted, either by
		//      checking that a[i]<=a[i+1] for all pairs, or by comparing  
		//      it to a 'correct' answer given by Arrays.sort() or Collections.sort()
		MinHeap<Double> m = new MinHeap<>();
		ArrayList<Double> a = new ArrayList<Double>();
		ArrayList<Double> sorted = new ArrayList<Double>();
		//DONE: Test that the heap works with many (15 or more) doubles
		for (int i = 0; i < 100000; i++) {
			double x = Math.random() * 1_000_000;
			m.add(x);
			a.add(x);
		}
		Collections.sort(a);
		while(m.size() > 0) {
			sorted.add(m.poll());
		}
		assertTrue(sorted.toString().equals(a.toString()));
	}
}
