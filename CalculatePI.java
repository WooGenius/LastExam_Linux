import java.util.Random;

public class CalculatePI implements Runnable {
	static int totalPoint = 0;
	static int validPoint = 0;
	Random random = new Random();

	@Override
	public void run() {
		System.out.println("Start");
		for (int i = 0; i < 100000; i++) {
			double x = random.nextDouble();
			double y = random.nextDouble();
			double length = Math.sqrt(x*x + y*y);
			synchronized (this) {
				if (length < 1) {
						validPoint++;
				}
				totalPoint++;
			}
		}
		System.out.println("End");
	}
	
	public static void main(String[] args) throws InterruptedException {
		CalculatePI cpi = new CalculatePI();
		Thread t1 = new Thread(cpi);
		Thread t2 = new Thread(cpi);
		Thread t3 = new Thread(cpi);
		Thread t4 = new Thread(cpi);
		Thread t5 = new Thread(cpi);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		double pi = ((double)validPoint/(double)totalPoint)*4;
		System.out.printf("PI : %.5f\n", pi);
	}

}
