/* Kevin Ngkaion
 * COSC-222
 * Lab 10
 * Using Euler's algorithm to check if all nodes can be connected without repeating an edge
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Graph[] g = new Graph[6];
		g[0] = readGraph("small1");
		g[1] = readGraph("small2");
		g[2] = readGraph("medium1");
		g[3] = readGraph("medium2");
		g[4] = readGraph("medium3");
		g[5] = readGraph("medium4");
		
		// This will view the adjacency list of a graph
		System.out.println(g[1]);
		System.out.println(has0or2oddDegrees(g[1]));
		
		for (int i=0; i<6; i++)
			System.out.println("graph " + (i+1) + " " + isEulerian(g[i]));

	}
	
	static boolean isEulerian(Graph graph) {
		return isConnected(graph) && has0or2oddDegrees(graph);
	}

	static boolean isConnected(Graph graph) {
		//TODO: complete this
		// HashSet to track which nodes we haven't seen
		HashSet<String> notSeen = new HashSet<String>(graph.getAllVertices());
		// Queue for BFS
		Queue<String> q = new LinkedList<>();
		// For each node
		String start = graph.getSomeVertex();
		q.add(start);
		while (!q.isEmpty()) {
			String current = q.poll();
			// check if we have seen this
			// if not yet seen, remove from list and add its neighbors to q
			if (notSeen.contains(current)) {
				notSeen.remove(current);
				q.addAll(graph.getNbrs(current));
			}
		}
		return notSeen.isEmpty();
	}
	
	static boolean has0or2oddDegrees(Graph graph) {
		//DONE: complete this
		// Completed by modifying the Graph class to add edges that already exist
		int numOdds = 0;
		for (String key : graph.getAllVertices()) { // Graph.getAllVertices() return's its keySet
			if (graph.degree(key) % 2 != 0) { // Check degree of each node. Increment numOdds if odd
				numOdds++;
			}
		}
		return (numOdds == 0 || numOdds == 2);
	}

	/**
	 * This function reads a list of edges from a given filename
	 * and returns a simple Graph.
	 * DO NOT EDIT THIS METHOD.
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Graph readGraph(String filename) {

		FileReader f = null;
		try {
			f = new FileReader(filename);
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find file: " + filename);
			System.err.println("This can probably be fixed by dragging your data files onto your Eclipse Project (not src folder)");
			e.printStackTrace();
		}

		Scanner sc = new Scanner(f);

		Graph g = new Graph();
		while (sc.hasNext()) {
			String u = sc.next();
			String v = sc.next();
			g.add(u);
			g.add(v);
			g.add(u,v);
		}
		sc.close();
		return g;
	}
}
