import java.util.Iterator;

/** Example usage of the Requests class and its iterator.
 *  You can play all you like here.
 * 
 * @author cosc222
 *
 */

public class MainCustomers {

	public static void main(String[] args) {

		Requests req = new Requests();
		req.add("Jim", 0);
		req.add("Jenny",1);
		req.add("Julie",2);
		req.add("Jason",2);
		req.add("Jessica",0);
		req.add("Joseph",5);
		req.add("Jackie", 1);
		req.add("Sarah", 2);
		req.add("Ken", 3);
		
		// See if we can iterate through all the requests:
		System.out.println("1) ----");
		System.out.println("Attempting to iterate through all requests automatically...");
		for (Customer c : req)
			System.out.println(c);
		
		
		System.out.println("2) ----");
		System.out.println("Attempting to explicitly create an iterator...");
		Iterator<Customer> i = req.iterator();

		System.out.println("3) ----");
		System.out.println("Attempting to iterate through the list with .next(), and removing Sarah");
		while(i.hasNext()) {
			Customer c = i.next();
			System.out.println(c);
			if (c.getName().equals("Sarah")) i.remove();
		}

		/*
		 * Expected output is:
		 * 
		 * [Jim, Platinum]
		 * [Jessica, Platinum]
		 * [Jenny, Gold]
		 * [Jackie, Gold]
		 * [Julie, Silver]
		 * [Jason, Silver]
		 * [Sarah, Silver]
		 * [Ken, Bronze]
		*/
		

		System.out.println("4) ----");
		System.out.println("Viewing all customers after Sarah is removed");

		
		i = req.iterator();  // re-initializes the iterator
		while(i.hasNext()) {
			Customer c = i.next();
			System.out.println(c);
		}
		
		/*
		 * Expected output is:
		 * [Jim, Platinum]
		 * [Jessica, Platinum]
		 * [Jenny, Gold]
		 * [Jackie, Gold]
		 * [Julie, Silver]
		 * [Jason, Silver]
		 * [Ken, Bronze]
		 */
		
	}

}
