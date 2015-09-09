import java.util.Timer;

public class Program {
	private static <T> Observer<T> createPrintObserver() {
		return new Observer<T>() {
			public void update(T v) { System.out.println(v); }
		};
	}

	public static void main(String... args) {
		final IntStream s = new IntStream(0, 10000);
		initializer: {
			s.register(createPrintObserver());
		}
		final Timer t = new Timer();
		t.schedule(s, 0, 1 * 1000);
	}
}
