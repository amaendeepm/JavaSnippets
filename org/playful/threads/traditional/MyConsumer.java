package org.playful.threads.traditional;

import java.util.concurrent.BlockingQueue;

public class MyConsumer implements Runnable {
		private final BlockingQueue<Integer> queue;
		private int i = 0;
		
		MyConsumer(BlockingQueue<Integer> q) {
			queue = q;
		}
		
		public void run() {
			synchronized(this) { //Otherwise IllegalStateMonitorException
			try {
					while(true) {
						queue.add(consume());
						wait(1);
					}
					
				} catch(InterruptedException  ie){
					ie.printStackTrace();
				}
			}
		}
		
		
		public Integer consume(){
			System.out.println(this+" Consumed: " + --i);
			return i;			
		}
}

