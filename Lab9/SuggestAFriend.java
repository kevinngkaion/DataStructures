// Kevin Ngkaion
// cosc 222
// November 22, 2022
// Jim Nastos
// Lab 9

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SuggestAFriend {

	/**
	 * Given social network g and name s, returns an ArrayList of all
	 * the names that this social network would suggest s may know
	 * @param g
	 * @param s
	 */
	public static ArrayList<String> suggest(Graph g, String s) {
		// First, let's make sure name s exists in this graph g
		if (g.containsName(s) == false) {
			System.err.println(s + " does not exist in this graph");
			return null;
		}
		
		// DONE: Find and store the friends of s
		HashSet<String> friends = new HashSet<>(g.getNbrs(s)); // Storing in HashSet because we need to check if it contains something

		// DONE: Find the list of friends of the friends of s
		// Don't forget to exclude s from this list
		HashMap<String, Integer> mutualFriends = new HashMap<>();
		for (String friend : friends) { // Iterate through the friends list
			HashSet<String> temp = new HashSet<>(g.getNbrs(friend)); // for each friend, find their friends list
			for (String mFriend: temp) {
				if (!friends.contains(mFriend) && !mFriend.equals(s)) { // ignore if friend of friend is already a friend and if friend is self
					if (mutualFriends.containsKey(mFriend)) {
						mutualFriends.put(mFriend, mutualFriends.get(mFriend)+1);
					} else {
						mutualFriends.put(mFriend, 0);
					}
				}
			}
		}

		// DONE: Of all the friends of friends of s, find the ones with
		// the largest number of common friends with s
		ArrayList<String> suggestedFriends = null;
		int max = -1;
		for (String friend: mutualFriends.keySet()) {
			int num = mutualFriends.get(friend);
			if (num > max) {
				max = num;
				suggestedFriends = new ArrayList<>();
			}
			if (num == max) {
				suggestedFriends.add(friend);
			}
		}

		// DONE: return an ArrayList of all the names with most common friends
		return suggestedFriends;
	}
	

}
