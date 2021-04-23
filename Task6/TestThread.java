public class TestThread extends Thread {
private int theValue;
public TestThread(int aValue) { theValue=aValue; }

public void run() {
	Example e = Example.getInstance();
	e.setVal(theValue);
	}
public static void main(String[] args) throws java.lang.InterruptedException {
	TestThread[] tests=new TestThread[10000];
	for (int i=0; i<10000; i++) { tests[i]=new TestThread(i); }
	for (int i=0; i<10000; i++) { tests[i].start(); }
	for (int i=0; i<10000; i++) { tests[i].join(); }
	Example e = Example.getInstance();
	System.out.println("The Example has value " + e.getVal() + " and has been updated " +
			e.getUpdateCount() + " time(s)");
	}
}
class Example {
private static Example myInstance;
private int updateCount=0;
private int val=0;

private Example() { }
public synchronized static Example getInstance() {
	if (myInstance == null) {myInstance = new Example();}
	return myInstance;
}
public synchronized void setVal(int aVal) { val=aVal; updateCount++; }
public synchronized int getVal() { return val; }
public synchronized int getUpdateCount() { return updateCount; }
}