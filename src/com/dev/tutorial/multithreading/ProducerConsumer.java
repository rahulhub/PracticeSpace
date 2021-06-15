package com.dev.tutorial.multithreading;

import java.util.LinkedList;
import java.util.Queue;

// We need to implement producer-consumer problem
// 1. create two threads a producer and a consumer
// 2. share common memory of defnied size
// 3. These processes will run in parallel 

public class ProducerConsumer<T> {
	
	// we need FIFO kind of data structure : queue
	Queue<T> queue = null;
	private int Q_SIZE = 1000;
	
	ProducerConsumer(int size){
		queue = new LinkedList<>();
		this.Q_SIZE = size;
	}
	
	
	private synchronized void produce(T message) throws InterruptedException {
		
		while(queue.size() >= Q_SIZE) {
			wait();
		}
		
//		if(queue.size() < Q_SIZE) {
			queue.add(message);
			notify();
//		}
		
		
		
		
	}
	
	private synchronized void consume() {
		
		if(queue.size() == 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			T msg = queue.poll();
			notify();
			System.out.println(msg);
			
		
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ProducerConsumer<Integer> proCon = new ProducerConsumer<Integer>(2);
		
		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				 int i = 1000;
				while( i > 0) {
					try {
						proCon.produce(i);
						i--;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
					proCon.consume();
			}
			
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
 
	}

}
