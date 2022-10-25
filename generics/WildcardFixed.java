package generics;

import java.util.List;

public class WildcardFixed {
	void foo(List<?> i) {
		fooHelper(i);
	}

	// Helper method created so that th ewildcard can be captures
	// through type inference
	private <T> void fooHelper(List<T> l) {
		l.set(0, l.get(0));
	}
}

