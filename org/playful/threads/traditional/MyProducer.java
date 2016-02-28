package org.playful.threads.traditional;

import java.util.concurrent.BlockingQueue;

public class MyProducer implements Runnable {
	private final BlockingQueue<Integer> queue;
	private int i = 0;
	
	MyProducer(BlockingQueue<Integer> q) {
		queue = q;
	}
	
	public void run() {
		synchronized(this) { //Otherwise IllegalStateMonitorException
		try {
				while(true) {
					if(queue.remainingCapacity() >0)
						queue.add(produce());
					wait(1);
				}
				
			} catch(InterruptedException  ie){
				ie.printStackTrace();
			}
		}
	}
	
	
	public Integer produce(){
		System.out.println(this+" Produced: " + ++i);
		return i;
	}
}


