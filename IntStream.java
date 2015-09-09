import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TimerTask;

class IntStream extends TimerTask implements Stream<Integer> {
	private final Set<Observer<Integer>> observers = new HashSet<Observer<Integer>>();
	private final int start;
	private final int end;
	private final int range;
	private final Random random = new Random();

	IntStream(int start, int end) {
		if (start >= end)
			throw new IllegalArgumentException("Start must be less than end.");
		this.start = start;
		this.end = end;
		this.range = this.end - this.start;
	}

	public void register(Observer<Integer> o) {
		this.observers.add(o);
	}

	public void run() {
		int n = random.nextInt(this.range) + this.start;
		update(n);
	}

	private void update(int v) {
		for (Observer<Integer> o : observers)
			o.update(v);
	}
}
