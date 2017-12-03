package sjsu.stowbunenko.cs146.project4;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * Tests the functionality of the linked list.
 * 
 * @author Vincent Stowbunenko
 *
 */
class LinkedListTester {

	@Test
	public void testEmpty() {
		LinkedList<Double> list = new LinkedList<>();
		assertFalse(list.iterator().hasNext());
	}

	@Test
	public void validate_shouldThrowIfNextOnEmpty() {
		LinkedList<Double> list = new LinkedList<>();
		Throwable e = null;
		try {
			list.iterator().next();
			fail("Expected an NoSuchElementException to be thrown");
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}

	@Test
	public void validate_shouldThrowIfIterateBeyond() {
		LinkedList<Double> list = new LinkedList<>();
		Throwable e = null;
		list.push(0.770);
		list.push(0.374);
		Iterator<Double> iterator = list.iterator();
		iterator.next();
		iterator.next();
		try {
			iterator.next();
			fail("Expected an NoSuchElementException to be thrown");
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}

	@Test
	public void testPush() {
		LinkedList<Double> list = new LinkedList<>();
		Double[] items = { 0.429, 0.069, 0.544 };
		for (Double item : items)
			list.push(item);
		Iterator<Double> iterator = list.iterator();
		for (int i = items.length - 1; i >= 0; i--) {
			assertTrue(iterator.hasNext());
			assertEquals(items[i], iterator.next());
		}
		assertFalse(iterator.hasNext());
	}

}
