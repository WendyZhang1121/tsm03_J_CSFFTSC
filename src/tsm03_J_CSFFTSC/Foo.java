package tsm03_J_CSFFTSC;

import java.io.IOException;
import java.util.Vector;

class Foo {
	private final Vector<Helper> helper;
	public Foo() {
		helper = new Vector<Helper>();
	}

	public Helper getHelper() { 
		if (helper.isEmpty()) {
			initialize();
		}
		return helper.elementAt(0); 
	}

	public synchronized void initialize() { 
		if (helper.isEmpty()) {
			helper.add(new Helper(42)); 
			}
	}
	
	public void testCase(){
		Thread test = new Thread(new Runnable() {
			public void run() {
				Foo testF = new Foo();
				testF.getHelper();
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		testCase(); // starts thread 1 
		testCase(); // starts thread 2
	}
}
