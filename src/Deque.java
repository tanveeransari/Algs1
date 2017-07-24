import java.util.*;

public class Deque<Item> implements Iterable<Item> {
	private int n;
	private Node first;
	private Node last;

	// helper linked list class
	private class Node {
		private Item item;
		private Node next;

		public Node() {
			next = null;
		}

		public Node(Item item) {
			this();
			this.item = item;
		}

		public Node(Item item, Node next) {
			this(item);
			this.next = next;
		}
	}

	public Deque() {
		first = last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		final Node oldFirst = first;
		first = new Node(item, oldFirst);
		if (last == null) {
			last = first;
		}

		first.next = oldFirst;
		n++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		final Node oldLast = last;
		last = new Node(item);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		n++;
		assert (check());
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque underflow");
		}

		final Item item = first.item; // save item to return
		final boolean sameFirstLast = first == last;
		first = first.next; // delete first node
		if (first == null && sameFirstLast) {
			last = null;
		}
		n--;
		assert check();
		return item; // return the saved item
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque underflow");
		}

		Node lastButOne = first;

		while (lastButOne.next != null && lastButOne.next.next != null) {
			lastButOne = lastButOne.next;
		}

		final Item item = last.item;
		lastButOne.next = null;
		if (last == lastButOne) {
			last = null;
			first = null;
		} else {
			last = lastButOne;
		}

		n--;

		if (isEmpty()) {
			last = null; // to avoid loitering
		}

		assert check();
		return item;

	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder();
		for (final Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}

	// check internal invariants
	private boolean check() {
		if (n < 0) {
			return false;
		} else if (n == 0) {
			if (first != null) {
				return false;
			}
			if (last != null) {
				return false;
			}
		} else if (n == 1) {
			if (first == null || last == null) {
				return false;
			}
			if (first != last) {
				return false;
			}
			if (first.next != null) {
				return false;
			}
		} else {
			if (first == null || last == null) {
				return false;
			}
			if (first == last) {
				return false;
			}
			if (first.next == null) {
				return false;
			}
			if (last.next != null) {
				return false;
			}

			// check internal consistency of instance variable n
			int numberOfNodes = 0;
			for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
				numberOfNodes++;
			}
			if (numberOfNodes != n) {
				return false;
			}

			// check internal consistency of instance variable last
			Node lastNode = first;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			if (last != lastNode) {
				return false;
			}
		}

		return true;
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			final Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {

	}

}