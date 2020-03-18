package honey;

import java.util.concurrent.Semaphore;

public class Shared {
	Semaphore eat=new Semaphore(0);
	Semaphore mutex=new Semaphore(1);
	int pot=0;

}
