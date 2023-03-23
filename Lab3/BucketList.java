// Kevin Ngkaion
// OC# 300325759


import java.util.ArrayList;
import java.util.Collection;

//TODO: 5 "to do" items below

public class BucketList<V> implements BucketListADT<V> {

	private ArrayList<SortedBucket<V>> list;
	private int min;
	private int max;
	
	/**
	 * Constructor. Builds a list of buckets which
	 * supports Entry (key,value pairs)
	 * with expected key values from min to max 
	 * 
	 * @param min
	 * @param max
	 * @param n
	 */
	public BucketList(int min, int max, int n) {
		list = new ArrayList<SortedBucket<V>>();
		for (int i=0; i<n; i++){
			//DONE: instantiate a SortedBucket of <V> type
			//DONE: add it to our BucketList instance variable "list"
			list.add(new SortedBucket<V>());
		}
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Adds the given Entry into the appropriate bucket in
	 * this list of buckets.
	 * @param item
	 */
	@Override
	public void add(Entry<V> item) {
		int n = list.size();
		// DO NOT CHANGE THIS FORMULA. This ensures items will be
		// added to the correct bucket.
		int indexToInsert = n*(item.getKey()-min)/(max-min+1);

		// DONE: check if the calculated indexToInsert is
		// outside of the allowed range. If it is too large, just
		// insert into the last bucket. If it is too small (negative)
		// then insert item into bucket 0.
		if (indexToInsert < 0 || item.getKey() < min)
			(list.get(0)).add(item);
		else if (indexToInsert > list.size() || item.getKey() > max) {
			(list.get(list.size() - 1)).add(item);
		} else
			(list.get(indexToInsert)).add(item);
		
	}
	
	/**
	 * Adds all entries in the Collection c to this List of Buckets
	 * @param c is a Collection of Entries
	 */
	@Override
	public void addAll(Collection<Entry<V>> c) {
		// Don't touch this.
		// Implement above method .add() for this to work.
		
		for (Entry<V> e : c)
			this.add(e);
	}
	
	/**
	 * @return Returns a single ArrayList of the whole
	 * sorted order of all buckets put together
	 * 
	 */
	@Override
	public ArrayList<Entry<V>> getSortedOrder() {
		ArrayList<Entry<V>> output = new ArrayList<Entry<V>>();

		//DONE: add the contents of each bucket into the output ArrayList
		//Hint: our bucket's .getBucketContents() will get the contents
		//of that bucket in sorted order if they are stored in sorted order
		for (SortedBucket<V> sb : list) {
			output.addAll(sb.getBucketContents());
		}
		return output;
	}
	
	/**
	 * Returns an ArrayList of the bucket contents of bucket i
	 * @param i
	 * @return
	 */
	@Override
	public ArrayList<Entry<V>> getBucket(int i) {
		//DONE: return the (i)th bucket as an arrayList.
		//Hint: our SortedBucket class has .getBucketContents()
		return (list.get(i)).getBucketContents();
	}
	
	/**
	 * Returns the number of buckets in this list of buckets
	 * @return int
	 */
	@Override
	public int getNumBuckets(){
		// Leave this alone.
		return list.size();
	}
	
	
	/* 
	 * Shows contents of all buckets, each bucket in [ ] brackets.
	 * Will show empty buckets as well.
	 */
	public String toString() {
		// Leave this alone
		StringBuilder output = new StringBuilder("[");
		for (SortedBucket<V> s: this.list) {
			output.append(s.toString());
		}
		output.append("]");
		return output.toString();
	}
}
