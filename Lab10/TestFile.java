import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class TestFile {

	@Test
	void testSmall1() {
		Graph g = Solution.readGraph("small1");
		assertFalse(Solution.has0or2oddDegrees(g));
		assertTrue(Solution.isConnected(g));
		assertFalse(Solution.isEulerian(g));
	}

	@Test
	void testSmall2() {
		Graph g = Solution.readGraph("small2");
		assertTrue(Solution.has0or2oddDegrees(g));
		assertTrue(Solution.isConnected(g));
		assertTrue(Solution.isEulerian(g));
	}

	@Test
	void testSmall3() {
		Graph g = Solution.readGraph("small3");
		assertTrue(Solution.has0or2oddDegrees(g));
		assertFalse(Solution.isConnected(g));
		assertFalse(Solution.isEulerian(g));
	}

	@Test
	void testMedium1() {
		Graph g = Solution.readGraph("medium1");
		assertFalse(Solution.has0or2oddDegrees(g));
		assertTrue(Solution.isConnected(g));
		assertFalse(Solution.isEulerian(g));
	}

	@Test
	void testMedium2() {
		Graph g = Solution.readGraph("medium2");
		assertTrue(Solution.has0or2oddDegrees(g));
		assertTrue(Solution.isConnected(g));
		assertTrue(Solution.isEulerian(g));
	}

	@Test
	void testMedium3() {
		Graph g = Solution.readGraph("medium3");
		assertTrue(Solution.has0or2oddDegrees(g));
		assertTrue(Solution.isConnected(g));
		assertTrue(Solution.isEulerian(g));
	}

	@Test
	void testMedium4() {
		Graph g = Solution.readGraph("medium4");
		assertTrue(Solution.has0or2oddDegrees(g));
		assertFalse(Solution.isConnected(g));
		assertFalse(Solution.isEulerian(g));
	}

}
