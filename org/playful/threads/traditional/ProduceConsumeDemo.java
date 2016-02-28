package org.playful.threads.traditional;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


//Following Def from: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html
public class ProduceConsumeDemo {

	public static void main(String[] args) {
		BlockingQueue q = new ArrayBlockingQueue(100);
		
		MyProducer p = new MyProducer(q);
		MyConsumer c1 = new MyConsumer(q);
		MyConsumer c2 = new MyConsumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}
