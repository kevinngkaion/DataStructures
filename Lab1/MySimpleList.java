/**
 * This is an interface that defines the methods of a list data type
 */

public interface MySimpleList {

	
	
	/** Gets the int at position pos
	 * @param pos int
	 * @return the int at index pos
	 */
	public int get(int pos);

	
	/**
	 * Removes (and returns) the int at postion pos
	 * @param pos int
	 * @return the int removed
	 */
	public int remove(int pos);


	// DONE: add Javadoc for add()
	/**
	 * Adds a new int to the arrayList at the end. Creates larger array if array is already full
	 * @param pos int
	 */
	public void add(int value);
	
	
	// DONE: add Javadoc for size()
	/**
	 * Returns the size of the arrayList
	 * @return size of arrayList
	 */
	public int size();
	
	
	/** Returns the string representation of the contents of this list
	 * @return a String representation of the contents of this list
	 */
	public String toString();
}
