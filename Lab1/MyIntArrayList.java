/**
 *  A simple integer ArrayList class which should perform faster than Java's own ArrayList
 */

// Kevin Ngkaion
// COSC-222 Lab 1
// Sept 13, 2022
// Prof. Jim Nastos

/* DONE: Complete the "ToDo" and "FixMe" tasks in this file. Your changes should make
all the tests in TestMyArray.java pass with 'TRUE' output. Change each "TODO"
item to DONE, and add DONE to your list of Java tags so that it remains in your 'Tasks' Window.
(under Window->Preferences->...  */

public class MyIntArrayList implements MySimpleList {
	
	private int size;
	private int[] contents;
	
	public MyIntArrayList () {
		//DONE: Construct your arrayList with an underlying array of some default size
		this.size = 0;
		contents = new int[10];
	}
	
	public MyIntArrayList (int n) {
		//DONE: Construct your arrayList with an underlying array of some size n
		this.size = 0;
		contents = new int[n];
	}
	
	public void add(int n) {
		if (size == contents.length) {
			//DONE: underlying array is full. Allocate additional space
			int[] temp = new int[size * 2];
			System.arraycopy(contents, 0, temp, 0, size);
			/*
			 * for (int i = 0; i < contents.length; i++) { temp[i] = contents[i]; }
			 */
			contents = temp;
		}
		//DONE: Complete this method by adding int n to your array
		contents[size] = n;
		size++;
	}
		
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (size == 0) {
			sb.append("[]");
		} else {
			sb.append("[" + contents[0]);
		}
		for (int i = 1; i < this.size; i++) {
			sb.append(", " + contents[i]);
		}
		sb.append("]");
		
		return sb.toString();
		//DONE: If your array contains 5,4,6 then return string "[5, 4, 6]" regardless of your underlying array size
		
	}

	public int remove(int pos) {
		//DONE: Remove the int at the given position 'pos'
		//DONE: Shift the rest of the items over to maintain array.
		//DONE: Decrease size of your collection
		//DONE: Return the integer item removed
		int removed = contents[pos];
		for (int i = pos; i < this.size; i++) {
			contents[i] = contents[i+1];
		}
		size--;		
		return removed;
	}

	//DONE: include any missing methods (.size() and .get(i)) from the interface

	@Override
	public int get(int pos) {
		return contents[pos];
	}

	@Override
	public int size() {
		return size;
	}
}
