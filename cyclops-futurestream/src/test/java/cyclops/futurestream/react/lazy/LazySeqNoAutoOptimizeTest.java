package cyclops.futurestream.react.lazy;

import java.util.function.Supplier;

import cyclops.futurestream.LazyReact;
import cyclops.futurestream.FutureStream;

public class LazySeqNoAutoOptimizeTest extends LazySeqTest {
	@Override
	protected <U> FutureStream<U> of(U... array) {
		return new LazyReact()
							.of(array);
	}
	@Override
	protected <U> FutureStream<U> ofThread(U... array) {
		return new LazyReact()
							.of(array);
	}

	@Override
	protected <U> FutureStream<U> react(Supplier<U>... array) {
		return new LazyReact()
								.ofAsync(array);
	}
}
