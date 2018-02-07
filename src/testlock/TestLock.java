package testlock;

public class TestLock {
	static Boolean lock;
	TestLock(){
		lock=new Boolean(false);
	}
	

	public static void main(String[] args) {
		//TestLock o=new TestLock();
		lock=false;
		System.out.println("Hola Mundo!!! ");
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Ejemplo "+lock);
				try {
					synchronized(lock){
						lock.wait();
					}
					System.out.println("Termina el hijo1!!!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		};
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("Ejemplo "+lock);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(lock){
					lock.notify();
				}
				System.out.println("Termina el hijo2!!!");
			} 
		};
		t1.start();
		t2.start();
		/*try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized(lock){
			lock=true;
		}*/
		try {
			t1.join();
			t2.join();
			System.out.println("Continua el padre!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(lock){
			lock=false;
		}		
		Thread t3 = new H(lock);
		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized(lock){
			//lock.notify();
			lock=true;
			//lock.valueOf(true);
		}
		try {
			//
			t3.interrupt();
			t3.join();
			System.out.println("Termina el padre!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
