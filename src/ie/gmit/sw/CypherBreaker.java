package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker {
	private static final int MAX_QUEUE_SIZE = 100;
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private Resultable result = new Result("", 0, -1000.00);
	
	public CypherBreaker(String cypherText, TextScorer ts){
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		init();
	}
	
	public void init(){
		//start a thread for each key
		for(int i = 2; i <= cypherText.length()/2; i++){
			new Thread(new Decryptor(queue, cypherText, i)).start();
		}
		
		new Thread(new Runnable(){
			public void run(){
				
				while(!queue.isEmpty()){
					try {
						Resultable r = queue.take();
						
						//check if r.getscore() is higher than result.getscore(). If it is, then result = r;
						//have a method increment with a synchronized code block using Object lock = new Object;
						//increment() each time you take something from the queue. 
						//In increment method check if(count == cyphertext.length()/2) then add a poison object
						//then in here, check if r is a poison object, if it is display score and return;	
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}