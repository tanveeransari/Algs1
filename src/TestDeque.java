import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flextrade.jfixture.JFixture;

public class TestDeque {

	private Deque<Integer> subjectUnderTest;
	private JFixture fixture;

	@Before
	public void setUp() throws Exception {
		subjectUnderTest = new Deque<Integer>();
		fixture = new JFixture();
	}

	@After
	public void tearDown() throws Exception {
		subjectUnderTest = null;
		fixture = null;
	}

	@Test
	public void testAddFirstIncrementsCount() {
		subjectUnderTest.addFirst(fixture.create(Integer.TYPE));
		assertFalse(subjectUnderTest.isEmpty());
		assertEquals(1, subjectUnderTest.size());
		subjectUnderTest.addFirst(fixture.create(Integer.TYPE));
		assertEquals(2, subjectUnderTest.size());
	}

	@Test
	public void testAddFirstRemoveLastReturnsSameElement() {
		assertTrue(subjectUnderTest.isEmpty());
		final Integer valueToAdd = fixture.create(Integer.TYPE);
		subjectUnderTest.addFirst(valueToAdd);
		assertEquals(valueToAdd, subjectUnderTest.removeLast());
	}
	
	@Test
	public void testAddLastRemoveFirstReturnsSameElement() {
		assertTrue(subjectUnderTest.isEmpty());
		final Integer valueToAdd = fixture.create(Integer.TYPE);
		subjectUnderTest.addLast(valueToAdd);
		assertEquals(valueToAdd, subjectUnderTest.removeFirst());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddFirstThrowsOnNullAdd() {
		subjectUnderTest.addFirst(null);
	}

	@Test
	public void testAddLastIncrementsCount() {
		subjectUnderTest.addLast(fixture.create(Integer.TYPE));
		assertFalse(subjectUnderTest.isEmpty());
		assertEquals(1, subjectUnderTest.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddLastThrowsOnNullAdd() {
		subjectUnderTest.addLast(null);
	}

	@Test
	public void testAddRemoveOneElementReturnsElement() {
		assertTrue(subjectUnderTest.isEmpty());
		final Integer valueToAdd = fixture.create(Integer.TYPE);
		subjectUnderTest.addFirst(valueToAdd);
		assertEquals(valueToAdd, subjectUnderTest.removeFirst());
	}

	@Test
	public void testIsEmptyOnInitialization() {
		assertTrue(subjectUnderTest.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstThrowsNoSuchElementExceptin() {
		subjectUnderTest.removeFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastThrowsNoSuchElementExceptin() {
		subjectUnderTest.removeLast();
	}
}
