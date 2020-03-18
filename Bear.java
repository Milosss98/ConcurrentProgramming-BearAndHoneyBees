package honey;

public class Bear extends Thread{
  
	static Shared s;
	static {
		if (HoneyBee.s==null) s=new Shared();
		else s=HoneyBee.s;
	}
	public void run() {
		
	try {
		while(!interrupted()) {
	   s.eat.acquire();
	   System.out.println("*eating*");
	   sleep((long)(Math.random()*1000));
	   s.pot=0;
	   s.mutex.release();//signalling to bees
	    
	}
	}
	catch(InterruptedException e) { }
	}
}
