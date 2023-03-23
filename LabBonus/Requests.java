/*
 * Kevin Ngkaion
 * COSC-222 BONUS LAB
 * OC# 300325759
 * December 6, 2022
 */

import java.util.ArrayList;
import java.util.Iterator;

/** This class maintains customer requests of customer loyalty types: Platinum, Gold, Silver, and Bronze. 
 * These will be implemented as loyalty 0, 1, 2, 3, respectively.
 * It implements the Iterable interface, meaning
 * a user can create an iterator to iterate through the items it contains.
 * 
 * The order in which customers should be iterated is through their loyalty rank first, (platinum first, bronze last)
 * and then in order in which these customers were placed in the collection.
 * 
 * @author cosc222
 *
 */

public class Requests implements Iterable<Customer> {

	private int size;
	private ArrayList<ArrayList<Customer>> reqs;

	public Requests() {
		size = 0;

		// This is going to be an arrayList of 4 ArrayLists
		reqs = new ArrayList<ArrayList<Customer>>();

		reqs.add(new ArrayList<>()); // index 0 is platinum

		//DONE: add an ArrayList for gold, silver, bronze
		reqs.add(new ArrayList<>());
		reqs.add(new ArrayList<>());
		reqs.add(new ArrayList<>());
	}

	/**
	 * Adds a customer by name,loyalty (0=platinum, 1=gold, 2=silver, 3=bronze)
	 * @param name
	 * @param loy
	 */
	public void add(String name, int loy) {
		//Leave this method as is. Complete the next method.
		add(new Customer(name,loy));
	}

	public void add(Customer c) {
		int loy = c.getLoyalty();
		// Leave this line as is. If a customer has an invalid loyalty level, it is not added.
		if (loy == -1) return;


		//DONE: add Customer c to the appropriate list. Don't forget to increase the size variable.
		reqs.get(loy).add(c);
		size++;
	}

	@Override
	public Iterator<Customer> iterator() {

		return new RequestsIterator();
	}


	public class RequestsIterator implements Iterator<Customer> {
		// inner class. Do not move the class. Ensure it remains in the Requests class
		// For an example on how to implement an Iterator, see
		//			https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java

		private int index = 0; // this keeps track of which item in the collection is the next one to be returned by the iterator			
		private int loy = 0;
		private int relPos = 0;
		@Override
		public boolean hasNext() {
			//DONE: this should return true if index has not yet reached the last item
			return (index < size );
		}

		@Override
		public Customer next() {
			//DONE: This method must return the next item in this collection, keeping in mind that
			//the customers in Platinum go first (if any), the customers in Gold go next (if any), etc.
			//This method is your main task of this assignment.
			// This should run in O(1) time.
				int clubSize = reqs.get(loy).size();
				if (relPos == clubSize) {
					relPos = 0;
					loy++;
				}
				Customer c = reqs.get(this.loy).get(relPos);
				index++;
				relPos++;
				return c;
		}

		@Override
		public void remove() {
			//TODO: Solutions without this method completed will earn up to 8/10. 
			// .remove is in the Iterable interface, but Java leaves it as an
			// optional method that can be omitted.
			// This method must remove the previous item that was returned by this iterator
			int i = 0;
			int temp = index-1;
			int rowSize = reqs.get(i).size();
			while(temp > rowSize) {
				temp -= rowSize;
				i++;
				rowSize = reqs.get(i).size();
			}
			reqs.get(i).remove(temp);
			index--;
			relPos--;
			size--;
		}

	}

}
