package honey;

public class HoneyBee extends Thread{
	static Shared s;
	static {
		if (Bear.s==null) s=new Shared();
		else s=Bear.s;
	}
    private static int N=10;
    
    private static int posId=0;
    private int id=++posId;
    public void run() {
    	try {
    		while(!interrupted()) {
    			 sleep((long)(Math.random()*1000));//simulation of producing
    			 s.mutex.acquire();
    			 s.pot++;
    			 System.out.println("bee "+id+" - pot "+s.pot);
    			 if (s.pot==N) s.eat.release();//signalling bear
    			 else s.mutex.release();
    		}
    }
    	catch(InterruptedException e) { }
   }
   public static void main(String[] args) {
	   Bear bear=new Bear();
	   bear.start();
	   HoneyBee[] bees=new HoneyBee[3];
	   for (int i=0;i<3;i++) {
		   bees[i]=new HoneyBee();
		   bees[i].start();
	   }
	   try {
		sleep((long)(Math.random()*10000));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   bear.interrupt();
	   for (int i=0;i<3;i++) {
		   bees[i].interrupt();
	   }
   }
}
