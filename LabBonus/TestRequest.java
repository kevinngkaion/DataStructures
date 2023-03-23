/**
 * @author cosc222
 * Kevin Ngkaion
 * COSC-222 BONUS LAB
 * OC# 300325759
 * December 6, 2022
 */

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


// TODO: there are 4 "to do" items below


public class TestRequest {

	/* Declaration of the test objects */

	Requests r;

	/* Instantiation of the objects */

	@BeforeEach
	public void initialize() {
		System.out.println("Initializing");
		r = new Requests();

	}

	@Test
	public void test1() {
		System.out.print("TestRequest 1: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("Sarah", 2);
		r.add("Ken", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Sarah");
		assertEquals(i.next().getName(),"Ken");
		System.out.print("Check");
	}

	@Test
	public void test2() {
		System.out.print("TestRequest 2: ");
		//TODO: Test if it works if there are no customers in Platinum
		r.add("Jim", 3);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",1);
		r.add("Jackie", 1);
		r.add("Sarah", 2);
		r.add("Ken", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Sarah");
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Ken");
		System.out.print("Check");
	}

	@Test
	public void test3() {
		System.out.print("TestRequest 3: ");
		//TODO: Test if it works if there are no customers in Platinum and none in Bronze
		r.add("Jim", 2);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",1);
		r.add("Jackie", 1);
		r.add("Sarah", 2);
		r.add("Ken", 1);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Ken");
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Sarah");
		System.out.print("Check");
	}

	@Test
	public void test4() {
		System.out.print("TestRequest 4: ");
		//TODO: Test if it works if all customers in Platinum and none in Bronze
		r.add("Jim", 0);
		r.add("Jenny",0);
		r.add("Julie",0);
		r.add("Jason",0);
		r.add("Jessica",0);
		r.add("Jackie", 0);
		r.add("Sarah", 0);
		r.add("Ken", 0);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Sarah");
		assertEquals(i.next().getName(),"Ken");
		System.out.print("Check");
	}

	@Test
	public void test5() {
		System.out.print("TestRequest 5: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("Sarah", 2);
		r.add("Ken", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Sarah");
		assertEquals(i.next().getName(),"Ken");
		System.out.print("Check");
	}

	// test if removal works
	@Test
	public void test6() {
		System.out.print("TestRequest 6: ");
		//TODO: TestRequest if i.remove() works
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("Sarah", 2);
		r.add("Ken", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		i.remove();
		i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Sarah");
		assertEquals(i.next().getName(),"Ken");
		System.out.print("Check");
	}

}
