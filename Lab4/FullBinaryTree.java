// Kevin Ngkaion
// cosc 222
// Lab 4
// Oct 25, 2022

import java.util.ArrayList;

/**
 *  A class representing a full binary tree, implemented on an
 *  ArrayList. Complete the methods to retrieve the left and right
 *  child indexes, as shown in class with the array implementation of
 *  a fullBinaryTree.
 *  You will also have to extend this class with your MinHeap implementation.
 */

public class FullBinaryTree <E> {

	protected ArrayList<E> nodes;
	
	public FullBinaryTree() {
		//Do not edit.
		nodes = new ArrayList<E>();
	}
	
	public int size() {
		//Do not edit.
		return nodes.size();
	}
	
	/**
	 * Returns the INDEX of where the left child would be, if it exists.
	 */
	protected static int leftChild(int i) {
		//DONE: return the index of the left child
		return (i * 2) + 1;
	}
	
	/**
	 * Returns the INDEX of where the right child would be, if it exists.
	 */
	protected static int rightChild(int i) {
		//DONE: return the index of the right child
		return (i * 2) + 2;
	}
	
	/**
	 * Returns the index of the parent node of i. For convenience, the
	 * parent of the root is the root.
	 */
	public static int parent(int i) {
		//DONE: if i=0, return 0. Else, return (i-1)/2
		return i==0 ? 0 : (i-1) / 2;
	}

	/**
	 * Adds an element to the full binary tree, just at the end of the tree.
	 * This method is not really used -- you should be overwriting it
	 * in your MinHeap class.
	 * @param e
	 */
	public void add(E e) {
		//Do not edit.
		nodes.add(e);
	}
}
