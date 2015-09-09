import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class BucketList {
	private final int start;
	private final int end;
	private final int[] array;

	private void ensureWithinRange(int i) {
		if (i < start || i >= end)
			throw new IllegalArgumentException("Specified value not within range.");
	}

	BucketList(int start, int end) {
		if (start >= end)
			throw new IllegalArgumentException("Start must be less than end.");
		this.start = start;
		this.end = end;
		this.array = new int[this.end - this.start];
	}

	void add(int i) {
		ensureWithinRange(i);
		this.array[i - this.start]++;
	}

	Integer frequency(int i) {
		ensureWithinRange(i);
		return this.array[i - this.start];
	}

	Set<Integer> entrySet() {
		return new AbstractSet<Integer>() {
			public int size() {
				return 0;
			}
			public Iterator<Integer> iterator() {
				return null;
			}
		};
	}
}
