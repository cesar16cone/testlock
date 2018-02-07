package testlock;

public class H extends Thread {
	Boolean terminar;
	public H(Boolean terminar){
		this.terminar=terminar;
	}
	public void run() {
		/*synchronized(terminar){
			System.out.println("Ejemplo."+ terminar+"\nHilo 3 en espera");
			try {
				terminar.wait();
				System.out.println("Finalizando el hilo");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		System.out.println("Trabajando el hilo3 "+terminar);
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//Se.printStackTrace();
				System.out.println("Finalizando el hilo3 "+terminar);
				break;//return;
			}
			System.out.print(".");
			if(Thread.interrupted()){
				System.out.println("Finalizando el hilo3 "+terminar);
				break;//return;
			}
		}
	} 
};