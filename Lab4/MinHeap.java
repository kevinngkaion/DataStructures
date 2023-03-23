// Kevin Ngkaion
// cosc 222
// Lab 4
// Oct 25, 2022

/**
 * MinHeap of Comparables. Two E objects which extend Comparable can
 * be compared by e1.compareTo(e2), and if this results in a negative
 * value, e1 comes before e2. If it results in a positive value, e2 comes
 * first.
 * This class extends fullBinaryTree, meaning we can use the left and right
 * child functions to get the index of child nodes. But it must also support
 * heap functionality, like up-heap, trickle-down, and extract-min.
 * @param <E>
 */

public class MinHeap<E extends Comparable<E>>
extends FullBinaryTree<E>
implements HeapADT<E> {

	/**
	 * Constructs the underlying ArrayList<E> called 'nodes' 
	 */
	public MinHeap() {
		// Nothing to change here.
		super();
	}
	
	@Override
	public E poll() {
		//DONE: Get (and remove) the root element. If there are any
		//elements left, extract the last element of nodes and
		//place it into the root position. Then call trickleDown(0) before
		//returning the original root.
		if(nodes.isEmpty())
			return null;
		else {
			E e = nodes.get(0);
			int last = nodes.size() - 1;
			nodes.set(0, nodes.get(last));
			nodes.remove(last);
			trickleDown(0);
			return e;
		}
	}

	private void trickleDown(int i) {
		//DONE: To trickle-down at index i:
		//Determine which of the left or right child is smaller
		//(if they exist at all), then if that child comes
		//before the value at position i, swap them and recurse.
		int right, left, smaller;
		left = MinHeap.leftChild(i);
		right = MinHeap.rightChild(i);
		if (left > nodes.size() - 1) {
			return;
		} else if (right > nodes.size() - 1) {
			smaller = left;
		} else {
			smaller = nodes.get(right).compareTo(nodes.get(left)) < 0 ? right : left;
		}
		if (nodes.get(i).compareTo(nodes.get(smaller)) > 0) {
			swap(i,smaller);
			trickleDown(smaller);
		}
	}

	@Override
	public E peek() {
		//DONE: return the root, without removing it
		return nodes.isEmpty() ? null : nodes.get(0);
	}
	
	@Override
	public void add(E e) {
		//DONE: add an element at the end of nodes, then
		//call upHeap on the last index.
		nodes.add(e);
		upHeap(nodes.size()-1);
	}

	private void upHeap(int index) {
		//DONE: If index==0, you are done. Otherwise, if the element at
		//index comes before its parent, swap it with its parent and then
		//call upHeap on the parent index.
		if (index == 0) {
			return;
		} else {
			int parent = MinHeap.parent(index);
			if (nodes.get(index).compareTo(nodes.get(parent)) < 0) {
				swap(index, parent);
				upHeap(parent);
			}
		}
	}
	
	private void swap(int x, int y) {
		E temp = nodes.get(x);
		nodes.set(x, nodes.get(y));
		nodes.set(y, temp);
	}
	
	public String toString() {
		// Nothing to change here.
		return nodes.toString();
	}
}
